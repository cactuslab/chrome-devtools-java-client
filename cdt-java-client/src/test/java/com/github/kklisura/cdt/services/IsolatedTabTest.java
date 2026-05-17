package com.github.kklisura.cdt.services;

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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.github.kklisura.cdt.protocol.commands.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Isolated tab test.
 *
 * @author Kenan Klisura
 */
@ExtendWith(MockitoExtension.class)
public class IsolatedTabTest {
  private static final String BROWSER_CONTEXT_ID = "browser-context-id";
  private static final String TARGET_ID = "target-id";

  @Mock private Target target;

  @Mock private ChromeDevToolsService devToolsService;

  private IsolatedTab isolatedTab;

  @BeforeEach
  public void setUp() {
    isolatedTab = new IsolatedTab(target, BROWSER_CONTEXT_ID, TARGET_ID, devToolsService);
  }

  @Test
  public void testGetters() {
    assertSame(devToolsService, isolatedTab.getDevToolsService());
    assertEquals(TARGET_ID, isolatedTab.getTargetId());
    assertEquals(BROWSER_CONTEXT_ID, isolatedTab.getBrowserContextId());
  }

  @Test
  public void testCloseClosesDevToolsThenTargetThenContext() {
    isolatedTab.close();

    // The dev tools service self-evicts, then the tab target and browser context are disposed. The
    // shared browser-level dev tools service is never closed.
    InOrder inOrder = inOrder(devToolsService, target);
    inOrder.verify(devToolsService).close();
    inOrder.verify(target).closeTarget(TARGET_ID);
    inOrder.verify(target).disposeBrowserContext(BROWSER_CONTEXT_ID);
    verifyNoMoreInteractions(devToolsService, target);
  }

  @Test
  public void testCloseDisposesContextWhenDevToolsCloseThrows() {
    RuntimeException failure = new RuntimeException("dev tools close failed");
    doThrow(failure).when(devToolsService).close();

    RuntimeException thrown = assertThrows(RuntimeException.class, isolatedTab::close);
    assertSame(failure, thrown);

    // A failure closing the dev tools service must not leak the tab target or browser context.
    verify(target).closeTarget(TARGET_ID);
    verify(target).disposeBrowserContext(BROWSER_CONTEXT_ID);
  }

  @Test
  public void testCloseDisposesContextWhenCloseTargetThrows() {
    RuntimeException failure = new RuntimeException("close target failed");
    doThrow(failure).when(target).closeTarget(TARGET_ID);

    RuntimeException thrown = assertThrows(RuntimeException.class, isolatedTab::close);
    assertSame(failure, thrown);

    // A failure closing the tab target must not leak the browser context.
    verify(devToolsService).close();
    verify(target).disposeBrowserContext(BROWSER_CONTEXT_ID);
  }
}
