package com.github.kklisura.cdt.launch;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2026 Kenan Klisura
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.github.kklisura.cdt.launch.ChromeLauncher.Environment;
import com.github.kklisura.cdt.launch.ChromeLauncher.ShutdownHookRegistry;
import com.github.kklisura.cdt.launch.config.ChromeLauncherConfiguration;
import com.github.kklisura.cdt.launch.exceptions.ChromeProcessTimeoutException;
import com.github.kklisura.cdt.launch.support.ProcessLauncher;
import com.github.kklisura.cdt.launch.utils.LogCollector;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.impl.ChromeServiceImpl;
import com.github.kklisura.cdt.utils.FilesUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.LoggerFactory;

/**
 * Chrome launcher test.
 *
 * @author Kenan Klisura
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ChromeLauncherTest {

  @Mock private ProcessLauncher processLauncher;

  @Mock private Environment environment;

  @Mock private ShutdownHookRegistry shutdownHookRegistry;

  @Mock private Process process;

  private ChromeLauncher launcher;

  @BeforeEach
  public void setUp() {
    launcher =
        new ChromeLauncher(
            processLauncher, environment, shutdownHookRegistry, new ChromeLauncherConfiguration());
  }

  @Test
  public void testGetChromeBinaryPathThrowsExceptionWhenNoBinaryFoundOnChromePath() {
    when(environment.getEnv("CHROME_PATH")).thenReturn("test");
    when(processLauncher.isExecutable("test")).thenReturn(false);

    assertThrows(RuntimeException.class, () -> launcher.getChromeBinaryPath());
  }

  @Test
  public void testGetChromeBinaryPathThrowsExceptionWhenNoBinaryFound() {
    when(environment.getEnv("CHROME_PATH")).thenReturn(null);

    when(processLauncher.isExecutable("/snap/bin/chromium")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/chromium")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/chromium-browser")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/google-chrome-stable")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/google-chrome")).thenReturn(false);
    when(processLauncher.isExecutable("/Applications/Chromium.app/Contents/MacOS/Chromium"))
        .thenReturn(false);
    when(processLauncher.isExecutable(
            "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"))
        .thenReturn(false);
    when(processLauncher.isExecutable(
            "/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary"))
        .thenReturn(false);
    when(processLauncher.isExecutable(
            "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"))
        .thenReturn(false);
    when(processLauncher.isExecutable("C:/Program Files/Google/Chrome/Application/chrome.exe"))
        .thenReturn(false);

    assertThrows(RuntimeException.class, () -> launcher.getChromeBinaryPath());
  }

  @Test
  public void testGetChromeBinaryPathReturnsSomePath() {
    when(environment.getEnv("CHROME_PATH")).thenReturn(null);

    when(processLauncher.isExecutable("/usr/bin/chromium")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/chromium-browser")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/google-chrome-stable")).thenReturn(false);
    when(processLauncher.isExecutable("/usr/bin/google-chrome")).thenReturn(true);

    Path chromeBinaryPath = launcher.getChromeBinaryPath();

    assertNotNull(chromeBinaryPath);
    assertTrue(chromeBinaryPath.toString().endsWith("/usr/bin/google-chrome"));
  }

  @Test
  public void testGetChromeBinaryPathReturnsPathFromEnv() {
    when(environment.getEnv("CHROME_PATH")).thenReturn("test/env/path");
    when(processLauncher.isExecutable("test/env/path")).thenReturn(true);

    Path chromeBinaryPath = launcher.getChromeBinaryPath();

    assertNotNull(chromeBinaryPath);
    assertTrue(chromeBinaryPath.toString().endsWith("test/env/path"));
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsAndDefaultUserDataDir()
      throws IOException, InterruptedException, ChromeProcessTimeoutException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder()
            .noFirstRun(Boolean.FALSE)
            .incognito()
            .remoteDebuggingPort(null)
            .disableBackgroundNetworking()
            .disableDefaultApps()
            .build();

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));
    when(process.isAlive()).thenReturn(true);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      mocked
          .when(() -> FilesUtils.randomTempDir("cdt-user-data-dir"))
          .thenReturn("temp-user-data-dir");

      ChromeService launch = launcher.launch(binaryPath, chromeArguments);

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      ArgumentCaptor<List<String>> captureArguments = listCaptor();
      verify(processLauncher).launch(eq("test-binary-path"), captureArguments.capture());
      List<String> arguments = captureArguments.getValue();

      assertEquals(5, arguments.size());
      assertTrue(arguments.contains("--incognito"));
      assertTrue(arguments.contains("--disable-background-networking"));
      assertTrue(arguments.contains("--disable-default-apps"));
      assertTrue(arguments.contains("--remote-debugging-port=0"));
      assertTrue(arguments.contains("--user-data-dir=temp-user-data-dir"));

      assertThrows(IllegalStateException.class, () -> launcher.launch(binaryPath, chromeArguments));

      // Test closing
      when(process.waitFor(60, TimeUnit.SECONDS)).thenReturn(true);
      when(process.isAlive()).thenReturn(true, false);

      ArgumentCaptor<Path> deletePathCapture = ArgumentCaptor.forClass(Path.class);
      mocked
          .when(() -> FilesUtils.deleteQuietly(deletePathCapture.capture()))
          .thenAnswer(invocation -> null);

      launcher.close();
      launcher.close();

      verify(process).destroy();
      verify(shutdownHookRegistry).remove(any());
      assertEquals("temp-user-data-dir", deletePathCapture.getValue().toString());
    }
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsAndCustomUserDataDir()
      throws IOException, InterruptedException, ChromeProcessTimeoutException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder()
            .noFirstRun(Boolean.FALSE)
            .incognito()
            .remoteDebuggingPort(null)
            .disableBackgroundNetworking()
            .disableDefaultApps()
            .userDataDir("user-data-dir-param")
            .build();

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);
    when(process.isAlive()).thenReturn(true);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      ChromeService launch = launcher.launch(binaryPath, chromeArguments);

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      ArgumentCaptor<List<String>> captureArguments = listCaptor();
      verify(processLauncher).launch(eq("test-binary-path"), captureArguments.capture());
      List<String> arguments = captureArguments.getValue();

      assertEquals(5, arguments.size());
      assertTrue(arguments.contains("--incognito"));
      assertTrue(arguments.contains("--disable-background-networking"));
      assertTrue(arguments.contains("--disable-default-apps"));
      assertTrue(arguments.contains("--remote-debugging-port=0"));
      assertTrue(arguments.contains("--user-data-dir=user-data-dir-param"));

      assertThrows(IllegalStateException.class, () -> launcher.launch(binaryPath, chromeArguments));

      // Test closing
      when(process.waitFor(60, TimeUnit.SECONDS)).thenReturn(true);
      when(process.isAlive()).thenReturn(true, false);

      launcher.close();
      launcher.close();

      mocked.verify(() -> FilesUtils.deleteQuietly(null));
    }
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsAndCloseWithInterruptedException()
      throws IOException, InterruptedException, ChromeProcessTimeoutException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder().incognito().userDataDir("user-data-dir-param").build();

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));
    when(process.isAlive()).thenReturn(true);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      ChromeService launch = launcher.launch(binaryPath, chromeArguments);

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      ArgumentCaptor<List<String>> captureArguments = listCaptor();
      verify(processLauncher).launch(eq("test-binary-path"), captureArguments.capture());
      List<String> arguments = captureArguments.getValue();

      assertEquals(3, arguments.size());
      assertTrue(arguments.contains("--incognito"));
      assertTrue(arguments.contains("--remote-debugging-port=0"));
      assertTrue(arguments.contains("--user-data-dir=user-data-dir-param"));

      assertThrows(IllegalStateException.class, () -> launcher.launch(binaryPath, chromeArguments));

      // Test closing
      when(process.waitFor(60, TimeUnit.SECONDS)).thenThrow(new InterruptedException());
      when(process.destroyForcibly()).thenReturn(process);

      launcher.close();

      verify(process).destroy();
      mocked.verify(() -> FilesUtils.deleteQuietly(null));
    }
  }

  @Test
  public void testLaunchHeadlessWithBinary()
      throws IOException, InterruptedException, ChromeProcessTimeoutException {
    when(environment.getEnv("CHROME_PATH")).thenReturn("/test-binary-path");
    when(processLauncher.isExecutable("/test-binary-path")).thenReturn(true);

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(processLauncher.launch(eq("/test-binary-path"), any())).thenReturn(process);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      mocked
          .when(() -> FilesUtils.randomTempDir("cdt-user-data-dir"))
          .thenReturn("temp-user-data-dir");

      ChromeService launch = launcher.launch();

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      ArgumentCaptor<List<String>> captureArguments = listCaptor();
      verify(processLauncher).launch(eq("/test-binary-path"), captureArguments.capture());
      List<String> arguments = captureArguments.getValue();

      assertEquals(21, arguments.size());
      assertTrue(arguments.contains("--no-first-run"));
      assertTrue(arguments.contains("--remote-debugging-port=0"));
      assertTrue(arguments.contains("--mute-audio"));
      assertTrue(arguments.contains("--disable-client-side-phishing-detection"));
      assertTrue(arguments.contains("--disable-popup-blocking"));
      assertTrue(arguments.contains("--disable-default-apps"));
      assertTrue(arguments.contains("--disable-extensions"));
      assertTrue(arguments.contains("--metrics-recording-only"));
      assertTrue(arguments.contains("--no-default-browser-check"));
      assertTrue(arguments.contains("--disable-background-timer-throttling"));
      assertTrue(arguments.contains("--disable-translate"));
      assertTrue(arguments.contains("--safebrowsing-disable-auto-update"));
      assertTrue(arguments.contains("--headless"));
      assertTrue(arguments.contains("--hide-scrollbars"));
      assertTrue(arguments.contains("--disable-background-networking"));
      assertTrue(arguments.contains("--disable-prompt-on-repost"));
      assertTrue(arguments.contains("--disable-hang-monitor"));
      assertTrue(arguments.contains("--disable-sync"));
      assertTrue(arguments.contains("--disable-gpu"));
      assertTrue(arguments.contains("--remote-allow-origins=*"));
      assertTrue(arguments.contains("--user-data-dir=temp-user-data-dir"));
    }
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsFailsOnReading()
      throws IOException, InterruptedException {
    final ChromeArguments chromeArguments =
        ChromeArguments.builder()
            .incognito()
            .remoteDebuggingPort(null)
            .disableBackgroundNetworking()
            .disableDefaultApps()
            .userDataDir("user-data-dir-param")
            .build();

    when(environment.getEnv("CHROME_PATH")).thenReturn("/test-binary-path");
    when(processLauncher.isExecutable("/test-binary-path")).thenReturn(true);

    when(process.getInputStream()).thenThrow(new RuntimeException("test exception"));
    when(process.isAlive()).thenReturn(true);
    when(process.waitFor(60, TimeUnit.SECONDS)).thenReturn(true);

    when(processLauncher.launch(eq("/test-binary-path"), any())).thenReturn(process);

    assertThrows(RuntimeException.class, () -> launcher.launch(chromeArguments));
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsThrowsExceptionOnTimeout()
      throws IOException, InterruptedException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder()
            .incognito()
            .disableBackgroundNetworking()
            .disableDefaultApps()
            .userDataDir("user-data-dir-param")
            .build();

    final String trigger = "test\r\ntest";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));
    when(process.isAlive()).thenReturn(true);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);
    when(process.waitFor(60, TimeUnit.SECONDS)).thenReturn(true);

    ChromeLauncherConfiguration configuration = new ChromeLauncherConfiguration();
    configuration.setStartupWaitTime(1);
    launcher =
        new ChromeLauncher(processLauncher, environment, shutdownHookRegistry, configuration);

    ChromeProcessTimeoutException e =
        assertThrows(
            ChromeProcessTimeoutException.class,
            () -> launcher.launch(binaryPath, chromeArguments));
    assertEquals(
        "Failed while waiting for chrome to start: Timeout expired! Chrome output: test\ntest",
        e.getMessage());

    ArgumentCaptor<Thread> addShutdown = ArgumentCaptor.forClass(Thread.class);
    ArgumentCaptor<Thread> removeShutdown = ArgumentCaptor.forClass(Thread.class);
    verify(shutdownHookRegistry).register(addShutdown.capture());
    verify(shutdownHookRegistry).remove(removeShutdown.capture());
    assertEquals(removeShutdown.getValue(), addShutdown.getValue());
  }

  @Test
  public void testLaunchWithBinaryAndArgumentsThrowsExceptionOnTimeoutForciblyClosingProcess()
      throws IOException, InterruptedException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder()
            .incognito()
            .disableBackgroundNetworking()
            .disableDefaultApps()
            .userDataDir("user-data-dir-param")
            .build();

    final String trigger = "test\r\n\r\n";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));
    when(process.isAlive()).thenReturn(true);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);
    when(process.waitFor(60, TimeUnit.SECONDS)).thenReturn(false, true);
    when(process.destroyForcibly()).thenReturn(process);

    ChromeLauncherConfiguration configuration = new ChromeLauncherConfiguration();
    configuration.setStartupWaitTime(1);
    launcher =
        new ChromeLauncher(processLauncher, environment, shutdownHookRegistry, configuration);

    ChromeProcessTimeoutException e =
        assertThrows(
            ChromeProcessTimeoutException.class,
            () -> launcher.launch(binaryPath, chromeArguments));
    assertEquals(
        "Failed while waiting for chrome to start: Timeout expired! Chrome output: test\n",
        e.getMessage());

    ArgumentCaptor<Thread> addShutdown = ArgumentCaptor.forClass(Thread.class);
    ArgumentCaptor<Thread> removeShutdown = ArgumentCaptor.forClass(Thread.class);
    verify(shutdownHookRegistry).register(addShutdown.capture());
    verify(shutdownHookRegistry).remove(removeShutdown.capture());
    assertEquals(removeShutdown.getValue(), addShutdown.getValue());
  }

  @Test
  public void testIsAlive() throws IOException {
    assertFalse(launcher.isAlive());

    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder().incognito().userDataDir("user-data-dir-param").build();

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(process.isAlive()).thenReturn(true);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);

    launcher.launch(binaryPath, chromeArguments);

    assertTrue(launcher.isAlive());
  }

  @Test
  public void testExitValueThrowsExceptionWhenProcessNotStarted() {
    assertThrows(IllegalStateException.class, () -> launcher.exitValue());
  }

  @Test
  public void testExitValue() throws IOException {
    final Path binaryPath = Paths.get("test-binary-path");

    final ChromeArguments chromeArguments =
        ChromeArguments.builder().incognito().userDataDir("user-data-dir-param").build();

    final String trigger = "\r\n\r\nDevTools listening on ws://127.0.0.1:9123/";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(process.exitValue()).thenReturn(123);

    when(processLauncher.launch(eq("test-binary-path"), any())).thenReturn(process);

    launcher.launch(binaryPath, chromeArguments);

    assertEquals(123, launcher.exitValue());
  }

  /**
   * Registers appender that adds logging events to the argument loggingEvents. This also sets the
   * level of the logger to DEBUG.
   *
   * @param name Name of the logger.
   * @param loggingEvents Logging events.
   */
  private static void registerAppenderOnDebugLogger(
      String name, Level level, List<String> loggingEvents) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    final Logger logger = loggerContext.getLogger(name);
    logger.setLevel(level);
    logger.addAppender(new LogCollector(loggingEvents));
  }

  @Test
  public void testLaunchWithDebugLogging()
      throws IOException, ChromeProcessTimeoutException, InterruptedException {
    List<String> loggingEvents = new ArrayList<>();
    registerAppenderOnDebugLogger(
        "com.github.kklisura.cdt.launch.chrome.output", Level.DEBUG, loggingEvents);

    when(environment.getEnv("CHROME_PATH")).thenReturn("/test-binary-path");
    when(processLauncher.isExecutable("/test-binary-path")).thenReturn(true);

    final String trigger =
        "first-line\r\nsecond-line\r\nDevTools listening on ws://127.0.0.1:9123/\r\nthird-line\r\nforth-line\r\n";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(processLauncher.launch(eq("/test-binary-path"), any())).thenReturn(process);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      mocked
          .when(() -> FilesUtils.randomTempDir("cdt-user-data-dir"))
          .thenReturn("temp-user-data-dir");

      ChromeService launch = launcher.launch();

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      // Give a thread in waitForDevToolsServer method a bit more chance to collect logging events.
      Thread.sleep(100);

      assertEquals(5, loggingEvents.size());
      assertEquals("[DEBUG] first-line", loggingEvents.get(0));
      assertEquals("[DEBUG] second-line", loggingEvents.get(1));
      assertEquals("[DEBUG] DevTools listening on ws://127.0.0.1:9123/", loggingEvents.get(2));
      assertEquals("[DEBUG] third-line", loggingEvents.get(3));
      assertEquals("[DEBUG] forth-line", loggingEvents.get(4));
    }
  }

  @Test
  public void testLaunchWithErrorLoggingDoesNotLogAnything()
      throws IOException, ChromeProcessTimeoutException {
    List<String> loggingEvents = new ArrayList<>();
    registerAppenderOnDebugLogger(
        "com.github.kklisura.cdt.launch.chrome.output", Level.ERROR, loggingEvents);

    when(environment.getEnv("CHROME_PATH")).thenReturn("/test-binary-path");
    when(processLauncher.isExecutable("/test-binary-path")).thenReturn(true);

    final String trigger =
        "first-line\r\nsecond-line\r\nDevTools listening on ws://127.0.0.1:9123/\r\nthird-line\r\nforth-line\r\n";
    when(process.getInputStream()).thenReturn(new ByteArrayInputStream(trigger.getBytes()));

    when(processLauncher.launch(eq("/test-binary-path"), any())).thenReturn(process);

    try (MockedStatic<FilesUtils> mocked = org.mockito.Mockito.mockStatic(FilesUtils.class)) {
      mocked
          .when(() -> FilesUtils.randomTempDir("cdt-user-data-dir"))
          .thenReturn("temp-user-data-dir");

      ChromeService launch = launcher.launch();

      assertNotNull(launch);
      assertTrue(launch instanceof ChromeServiceImpl);

      assertEquals(9123, ((ChromeServiceImpl) launch).getPort());

      assertEquals(0, loggingEvents.size());
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private static ArgumentCaptor<List<String>> listCaptor() {
    return ArgumentCaptor.forClass((Class) List.class);
  }

  // Suppress unused warning on helper kept for future use.
  @SuppressWarnings("unused")
  private static void verifyTimes(Runnable r, int n) {
    for (int i = 0; i < n; i++) r.run();
    verify(r, times(n)).run();
  }
}
