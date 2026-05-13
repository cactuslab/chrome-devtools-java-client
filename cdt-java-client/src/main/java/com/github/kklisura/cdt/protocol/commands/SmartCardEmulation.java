package com.github.kklisura.cdt.protocol.commands;

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

import com.github.kklisura.cdt.protocol.events.smartcardemulation.BeginTransactionRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.CancelRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.ConnectRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.ControlRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.DisconnectRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.EndTransactionRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.EstablishContextRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.GetAttribRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.GetStatusChangeRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.ListReadersRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.ReleaseContextRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.SetAttribRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.StatusRequested;
import com.github.kklisura.cdt.protocol.events.smartcardemulation.TransmitRequested;
import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.protocol.types.smartcardemulation.ConnectionState;
import com.github.kklisura.cdt.protocol.types.smartcardemulation.Protocol;
import com.github.kklisura.cdt.protocol.types.smartcardemulation.ReaderStateOut;
import com.github.kklisura.cdt.protocol.types.smartcardemulation.ResultCode;
import java.util.List;

@Experimental
public interface SmartCardEmulation {

  /** Enables the |SmartCardEmulation| domain. */
  void enable();

  /** Disables the |SmartCardEmulation| domain. */
  void disable();

  /**
   * Reports the successful result of a |SCardEstablishContext| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaa1b8970169fd4883a6dc4a8f43f19b67 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardestablishcontext
   *
   * @param requestId
   * @param contextId
   */
  void reportEstablishContextResult(
      @ParamName("requestId") String requestId, @ParamName("contextId") Integer contextId);

  /**
   * Reports the successful result of a |SCardReleaseContext| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga6aabcba7744c5c9419fdd6404f73a934 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardreleasecontext
   *
   * @param requestId
   */
  void reportReleaseContextResult(@ParamName("requestId") String requestId);

  /**
   * Reports the successful result of a |SCardListReaders| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga93b07815789b3cf2629d439ecf20f0d9 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardlistreadersa
   *
   * @param requestId
   * @param readers
   */
  void reportListReadersResult(
      @ParamName("requestId") String requestId, @ParamName("readers") List<String> readers);

  /**
   * Reports the successful result of a |SCardGetStatusChange| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
   *
   * @param requestId
   * @param readerStates
   */
  void reportGetStatusChangeResult(
      @ParamName("requestId") String requestId,
      @ParamName("readerStates") List<ReaderStateOut> readerStates);

  /**
   * Reports the result of a |SCardBeginTransaction| call. On success, this creates a new
   * transaction object.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaddb835dce01a0da1d6ca02d33ee7d861 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardbegintransaction
   *
   * @param requestId
   * @param handle
   */
  void reportBeginTransactionResult(
      @ParamName("requestId") String requestId, @ParamName("handle") Integer handle);

  /**
   * Reports the successful result of a call that returns only a result code. Used for:
   * |SCardCancel|, |SCardDisconnect|, |SCardSetAttrib|, |SCardEndTransaction|.
   *
   * <p>This maps to: 1. SCardCancel PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaacbbc0c6d6c0cbbeb4f4debf6fbeeee6 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcancel
   *
   * <p>2. SCardDisconnect PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga4be198045c73ec0deb79e66c0ca1738a Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scarddisconnect
   *
   * <p>3. SCardSetAttrib PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga060f0038a4ddfd5dd2b8fadf3c3a2e4f Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardsetattrib
   *
   * <p>4. SCardEndTransaction PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gae8742473b404363e5c587f570d7e2f3b Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardendtransaction
   *
   * @param requestId
   */
  void reportPlainResult(@ParamName("requestId") String requestId);

  /**
   * Reports the successful result of a |SCardConnect| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
   *
   * @param requestId
   * @param handle
   */
  void reportConnectResult(
      @ParamName("requestId") String requestId, @ParamName("handle") Integer handle);

  /**
   * Reports the successful result of a |SCardConnect| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
   *
   * @param requestId
   * @param handle
   * @param activeProtocol
   */
  void reportConnectResult(
      @ParamName("requestId") String requestId,
      @ParamName("handle") Integer handle,
      @Optional @ParamName("activeProtocol") Protocol activeProtocol);

  /**
   * Reports the successful result of a call that sends back data on success. Used for
   * |SCardTransmit|, |SCardControl|, and |SCardGetAttrib|.
   *
   * <p>This maps to: 1. SCardTransmit PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
   *
   * <p>2. SCardControl PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gac3454d4657110fd7f753b2d3d8f4e32f Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcontrol
   *
   * <p>3. SCardGetAttrib PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaacfec51917255b7a25b94c5104961602 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetattrib
   *
   * @param requestId
   * @param data
   */
  void reportDataResult(@ParamName("requestId") String requestId, @ParamName("data") String data);

  /**
   * Reports the successful result of a |SCardStatus| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gae49c3c894ad7ac12a5b896bde70d0382 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardstatusa
   *
   * @param requestId
   * @param readerName
   * @param state
   * @param atr
   */
  void reportStatusResult(
      @ParamName("requestId") String requestId,
      @ParamName("readerName") String readerName,
      @ParamName("state") ConnectionState state,
      @ParamName("atr") String atr);

  /**
   * Reports the successful result of a |SCardStatus| call.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gae49c3c894ad7ac12a5b896bde70d0382 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardstatusa
   *
   * @param requestId
   * @param readerName
   * @param state
   * @param atr
   * @param protocol
   */
  void reportStatusResult(
      @ParamName("requestId") String requestId,
      @ParamName("readerName") String readerName,
      @ParamName("state") ConnectionState state,
      @ParamName("atr") String atr,
      @Optional @ParamName("protocol") Protocol protocol);

  /**
   * Reports an error result for the given request.
   *
   * @param requestId
   * @param resultCode
   */
  void reportError(
      @ParamName("requestId") String requestId, @ParamName("resultCode") ResultCode resultCode);

  /**
   * Fired when |SCardEstablishContext| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaa1b8970169fd4883a6dc4a8f43f19b67 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardestablishcontext
   */
  @EventName("establishContextRequested")
  EventListener onEstablishContextRequested(EventHandler<EstablishContextRequested> eventListener);

  /**
   * Fired when |SCardReleaseContext| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga6aabcba7744c5c9419fdd6404f73a934 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardreleasecontext
   */
  @EventName("releaseContextRequested")
  EventListener onReleaseContextRequested(EventHandler<ReleaseContextRequested> eventListener);

  /**
   * Fired when |SCardListReaders| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga93b07815789b3cf2629d439ecf20f0d9 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardlistreadersa
   */
  @EventName("listReadersRequested")
  EventListener onListReadersRequested(EventHandler<ListReadersRequested> eventListener);

  /**
   * Fired when |SCardGetStatusChange| is called. Timeout is specified in milliseconds.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
   */
  @EventName("getStatusChangeRequested")
  EventListener onGetStatusChangeRequested(EventHandler<GetStatusChangeRequested> eventListener);

  /**
   * Fired when |SCardCancel| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaacbbc0c6d6c0cbbeb4f4debf6fbeeee6 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcancel
   */
  @EventName("cancelRequested")
  EventListener onCancelRequested(EventHandler<CancelRequested> eventListener);

  /**
   * Fired when |SCardConnect| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
   */
  @EventName("connectRequested")
  EventListener onConnectRequested(EventHandler<ConnectRequested> eventListener);

  /**
   * Fired when |SCardDisconnect| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga4be198045c73ec0deb79e66c0ca1738a Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scarddisconnect
   */
  @EventName("disconnectRequested")
  EventListener onDisconnectRequested(EventHandler<DisconnectRequested> eventListener);

  /**
   * Fired when |SCardTransmit| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
   */
  @EventName("transmitRequested")
  EventListener onTransmitRequested(EventHandler<TransmitRequested> eventListener);

  /**
   * Fired when |SCardControl| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gac3454d4657110fd7f753b2d3d8f4e32f Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcontrol
   */
  @EventName("controlRequested")
  EventListener onControlRequested(EventHandler<ControlRequested> eventListener);

  /**
   * Fired when |SCardGetAttrib| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaacfec51917255b7a25b94c5104961602 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetattrib
   */
  @EventName("getAttribRequested")
  EventListener onGetAttribRequested(EventHandler<GetAttribRequested> eventListener);

  /**
   * Fired when |SCardSetAttrib| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#ga060f0038a4ddfd5dd2b8fadf3c3a2e4f Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardsetattrib
   */
  @EventName("setAttribRequested")
  EventListener onSetAttribRequested(EventHandler<SetAttribRequested> eventListener);

  /**
   * Fired when |SCardStatus| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gae49c3c894ad7ac12a5b896bde70d0382 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardstatusa
   */
  @EventName("statusRequested")
  EventListener onStatusRequested(EventHandler<StatusRequested> eventListener);

  /**
   * Fired when |SCardBeginTransaction| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gaddb835dce01a0da1d6ca02d33ee7d861 Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardbegintransaction
   */
  @EventName("beginTransactionRequested")
  EventListener onBeginTransactionRequested(EventHandler<BeginTransactionRequested> eventListener);

  /**
   * Fired when |SCardEndTransaction| is called.
   *
   * <p>This maps to: PC/SC Lite:
   * https://pcsclite.apdu.fr/api/group__API.html#gae8742473b404363e5c587f570d7e2f3b Microsoft:
   * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardendtransaction
   */
  @EventName("endTransactionRequested")
  EventListener onEndTransactionRequested(EventHandler<EndTransactionRequested> eventListener);
}
