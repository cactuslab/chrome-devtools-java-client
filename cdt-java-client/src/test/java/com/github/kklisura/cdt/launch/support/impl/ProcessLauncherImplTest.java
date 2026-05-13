package com.github.kklisura.cdt.launch.support.impl;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

/**
 * Created by Kenan Klisura on 31/01/2018.
 *
 * @author Kenan Klisura
 */
public class ProcessLauncherImplTest {
  private ProcessLauncherImpl processLauncher;

  @BeforeEach
  public void setUp() {
    processLauncher = new ProcessLauncherImpl();
  }

  @Test
  public void testLaunch() throws Exception {
    List<String> args = new ArrayList<>();
    args.add("arg1");
    args.add("arg2");

    Process process = mock(Process.class);

    try (MockedConstruction<ProcessBuilder> mockedConstruction =
        mockConstruction(
            ProcessBuilder.class,
            (mock, context) -> {
              when(mock.command(org.mockito.ArgumentMatchers.<List<String>>any())).thenReturn(mock);
              when(mock.redirectErrorStream(true)).thenReturn(mock);
              when(mock.redirectOutput(Redirect.PIPE)).thenReturn(mock);
              when(mock.start()).thenReturn(process);
            })) {

      assertEquals(process, processLauncher.launch("program-name", args));

      ProcessBuilder processBuilder = mockedConstruction.constructed().get(0);
      org.mockito.ArgumentCaptor<List<String>> captureCommands = listCaptor();
      org.mockito.Mockito.verify(processBuilder).command(captureCommands.capture());

      List<String> commands = captureCommands.getValue();
      assertEquals(3, commands.size());
      assertEquals("program-name", commands.get(0));
      assertEquals("arg1", commands.get(1));
      assertEquals("arg2", commands.get(2));
    }
  }

  @Test
  public void testIsExecutable() {
    final Path path = mock(Path.class);

    try (MockedStatic<Paths> mockedPaths = mockStatic(Paths.class);
        MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
      mockedPaths.when(() -> Paths.get("test-file")).thenReturn(path);

      mockedFiles.when(() -> Files.isRegularFile(path)).thenReturn(false);
      assertFalse(processLauncher.isExecutable("test-file"));

      mockedFiles.when(() -> Files.isRegularFile(path)).thenReturn(true);
      mockedFiles.when(() -> Files.isReadable(path)).thenReturn(false);
      assertFalse(processLauncher.isExecutable("test-file"));

      mockedFiles.when(() -> Files.isReadable(path)).thenReturn(true);
      mockedFiles.when(() -> Files.isExecutable(path)).thenReturn(false);
      assertFalse(processLauncher.isExecutable("test-file"));

      mockedFiles.when(() -> Files.isExecutable(path)).thenReturn(true);
      assertTrue(processLauncher.isExecutable("test-file"));
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private static org.mockito.ArgumentCaptor<List<String>> listCaptor() {
    return org.mockito.ArgumentCaptor.forClass((Class) List.class);
  }
}
