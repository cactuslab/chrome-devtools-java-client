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

import com.github.kklisura.cdt.protocol.events.emulation.ScreenOrientationLockChanged;
import com.github.kklisura.cdt.protocol.events.emulation.VirtualTimeBudgetExpired;
import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.annotations.ReturnTypeParameter;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.protocol.types.dom.RGBA;
import com.github.kklisura.cdt.protocol.types.emulation.DevicePosture;
import com.github.kklisura.cdt.protocol.types.emulation.DisabledImageType;
import com.github.kklisura.cdt.protocol.types.emulation.DisplayFeature;
import com.github.kklisura.cdt.protocol.types.emulation.MediaFeature;
import com.github.kklisura.cdt.protocol.types.emulation.PressureMetadata;
import com.github.kklisura.cdt.protocol.types.emulation.PressureSource;
import com.github.kklisura.cdt.protocol.types.emulation.PressureState;
import com.github.kklisura.cdt.protocol.types.emulation.SafeAreaInsets;
import com.github.kklisura.cdt.protocol.types.emulation.ScreenInfo;
import com.github.kklisura.cdt.protocol.types.emulation.ScreenOrientation;
import com.github.kklisura.cdt.protocol.types.emulation.SensorMetadata;
import com.github.kklisura.cdt.protocol.types.emulation.SensorReading;
import com.github.kklisura.cdt.protocol.types.emulation.SensorType;
import com.github.kklisura.cdt.protocol.types.emulation.SetDeviceMetricsOverrideScrollbarType;
import com.github.kklisura.cdt.protocol.types.emulation.SetEmitTouchEventsForMouseConfiguration;
import com.github.kklisura.cdt.protocol.types.emulation.SetEmulatedVisionDeficiencyType;
import com.github.kklisura.cdt.protocol.types.emulation.UserAgentMetadata;
import com.github.kklisura.cdt.protocol.types.emulation.VirtualTimePolicy;
import com.github.kklisura.cdt.protocol.types.emulation.WorkAreaInsets;
import com.github.kklisura.cdt.protocol.types.page.Viewport;
import java.util.List;

/** This domain emulates different environments for the page. */
public interface Emulation {

  /** Tells whether emulation is supported. */
  @Deprecated
  @Returns("result")
  Boolean canEmulate();

  /** Clears the overridden device metrics. */
  void clearDeviceMetricsOverride();

  /** Clears the overridden Geolocation Position and Error. */
  void clearGeolocationOverride();

  /** Requests that page scale factor is reset to initial values. */
  @Experimental
  void resetPageScaleFactor();

  /**
   * Enables or disables simulating a focused and active page.
   *
   * @param enabled Whether to enable to disable focus emulation.
   */
  @Experimental
  void setFocusEmulationEnabled(@ParamName("enabled") Boolean enabled);

  /** Automatically render all web contents using a dark theme. */
  @Experimental
  void setAutoDarkModeOverride();

  /**
   * Automatically render all web contents using a dark theme.
   *
   * @param enabled Whether to enable or disable automatic dark mode. If not specified, any existing
   *     override will be cleared.
   */
  @Experimental
  void setAutoDarkModeOverride(@Optional @ParamName("enabled") Boolean enabled);

  /**
   * Enables CPU throttling to emulate slow CPUs.
   *
   * @param rate Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
   */
  void setCPUThrottlingRate(@ParamName("rate") Double rate);

  /**
   * Sets or clears an override of the default background color of the frame. This override is used
   * if the content does not specify one.
   */
  void setDefaultBackgroundColorOverride();

  /**
   * Sets or clears an override of the default background color of the frame. This override is used
   * if the content does not specify one.
   *
   * @param color RGBA of the default background color. If not specified, any existing override will
   *     be cleared.
   */
  void setDefaultBackgroundColorOverride(@Optional @ParamName("color") RGBA color);

  /**
   * Overrides the values for env(safe-area-inset-*) and env(safe-area-max-inset-*). Unset values
   * will cause the respective variables to be undefined, even if previously overridden.
   *
   * @param insets
   */
  @Experimental
  void setSafeAreaInsetsOverride(@ParamName("insets") SafeAreaInsets insets);

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   *
   * @param width Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the
   *     override.
   * @param height Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the
   *     override.
   * @param deviceScaleFactor Overriding device scale factor value. 0 disables the override.
   * @param mobile Whether to emulate mobile device. This includes viewport meta tag, overlay
   *     scrollbars, text autosizing and more.
   */
  void setDeviceMetricsOverride(
      @ParamName("width") Integer width,
      @ParamName("height") Integer height,
      @ParamName("deviceScaleFactor") Double deviceScaleFactor,
      @ParamName("mobile") Boolean mobile);

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   *
   * @param width Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the
   *     override.
   * @param height Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the
   *     override.
   * @param deviceScaleFactor Overriding device scale factor value. 0 disables the override.
   * @param mobile Whether to emulate mobile device. This includes viewport meta tag, overlay
   *     scrollbars, text autosizing and more.
   * @param scale Scale to apply to resulting view image.
   * @param screenWidth Overriding screen width value in pixels (minimum 0, maximum 10000000).
   * @param screenHeight Overriding screen height value in pixels (minimum 0, maximum 10000000).
   * @param positionX Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
   * @param positionY Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
   * @param dontSetVisibleSize Do not set visible view size, rely upon explicit setVisibleSize call.
   * @param screenOrientation Screen orientation override.
   * @param viewport If set, the visible area of the page will be overridden to this viewport. This
   *     viewport change is not observed by the page, e.g. viewport-relative elements do not change
   *     positions.
   * @param displayFeature If set, the display feature of a multi-segment screen. If not set,
   *     multi-segment support is turned-off. Deprecated, use Emulation.setDisplayFeaturesOverride.
   * @param devicePosture If set, the posture of a foldable device. If not set the posture is set to
   *     continuous. Deprecated, use Emulation.setDevicePostureOverride.
   * @param scrollbarType Scrollbar type. Default: `default`.
   * @param screenOrientationLockEmulation If set to true, enables screen orientation lock
   *     emulation, which intercepts screen.orientation.lock() calls from the page and reports
   *     orientation changes via screenOrientationLockChanged events. This is useful for emulating
   *     mobile device orientation lock behavior in responsive design mode.
   */
  void setDeviceMetricsOverride(
      @ParamName("width") Integer width,
      @ParamName("height") Integer height,
      @ParamName("deviceScaleFactor") Double deviceScaleFactor,
      @ParamName("mobile") Boolean mobile,
      @Experimental @Optional @ParamName("scale") Double scale,
      @Experimental @Optional @ParamName("screenWidth") Integer screenWidth,
      @Experimental @Optional @ParamName("screenHeight") Integer screenHeight,
      @Experimental @Optional @ParamName("positionX") Integer positionX,
      @Experimental @Optional @ParamName("positionY") Integer positionY,
      @Experimental @Optional @ParamName("dontSetVisibleSize") Boolean dontSetVisibleSize,
      @Optional @ParamName("screenOrientation") ScreenOrientation screenOrientation,
      @Experimental @Optional @ParamName("viewport") Viewport viewport,
      @Deprecated @Experimental @Optional @ParamName("displayFeature")
          DisplayFeature displayFeature,
      @Deprecated @Experimental @Optional @ParamName("devicePosture") DevicePosture devicePosture,
      @Experimental @Optional @ParamName("scrollbarType")
          SetDeviceMetricsOverrideScrollbarType scrollbarType,
      @Experimental @Optional @ParamName("screenOrientationLockEmulation")
          Boolean screenOrientationLockEmulation);

  /**
   * Start reporting the given posture value to the Device Posture API. This override can also be
   * set in setDeviceMetricsOverride().
   *
   * @param posture
   */
  @Experimental
  void setDevicePostureOverride(@ParamName("posture") DevicePosture posture);

  /**
   * Clears a device posture override set with either setDeviceMetricsOverride() or
   * setDevicePostureOverride() and starts using posture information from the platform again. Does
   * nothing if no override is set.
   */
  @Experimental
  void clearDevicePostureOverride();

  /**
   * Start using the given display features to pupulate the Viewport Segments API. This override can
   * also be set in setDeviceMetricsOverride().
   *
   * @param features
   */
  @Experimental
  void setDisplayFeaturesOverride(@ParamName("features") List<DisplayFeature> features);

  /**
   * Clears the display features override set with either setDeviceMetricsOverride() or
   * setDisplayFeaturesOverride() and starts using display features from the platform again. Does
   * nothing if no override is set.
   */
  @Experimental
  void clearDisplayFeaturesOverride();

  /** @param hidden Whether scrollbars should be always hidden. */
  @Experimental
  void setScrollbarsHidden(@ParamName("hidden") Boolean hidden);

  /** @param disabled Whether document.coookie API should be disabled. */
  @Experimental
  void setDocumentCookieDisabled(@ParamName("disabled") Boolean disabled);

  /** @param enabled Whether touch emulation based on mouse input should be enabled. */
  @Experimental
  void setEmitTouchEventsForMouse(@ParamName("enabled") Boolean enabled);

  /**
   * @param enabled Whether touch emulation based on mouse input should be enabled.
   * @param configuration Touch/gesture events configuration. Default: current platform.
   */
  @Experimental
  void setEmitTouchEventsForMouse(
      @ParamName("enabled") Boolean enabled,
      @Optional @ParamName("configuration") SetEmitTouchEventsForMouseConfiguration configuration);

  /** Emulates the given media type or media feature for CSS media queries. */
  void setEmulatedMedia();

  /**
   * Emulates the given media type or media feature for CSS media queries.
   *
   * @param media Media type to emulate. Empty string disables the override.
   * @param features Media features to emulate.
   */
  void setEmulatedMedia(
      @Optional @ParamName("media") String media,
      @Optional @ParamName("features") List<MediaFeature> features);

  /**
   * Emulates the given vision deficiency.
   *
   * @param type Vision deficiency to emulate. Order: best-effort emulations come first, followed by
   *     any physiologically accurate emulations for medically recognized color vision deficiencies.
   */
  void setEmulatedVisionDeficiency(@ParamName("type") SetEmulatedVisionDeficiencyType type);

  /** Emulates the given OS text scale. */
  void setEmulatedOSTextScale();

  /**
   * Emulates the given OS text scale.
   *
   * @param scale
   */
  void setEmulatedOSTextScale(@Optional @ParamName("scale") Double scale);

  /**
   * Overrides the Geolocation Position or Error. Omitting latitude, longitude or accuracy emulates
   * position unavailable.
   */
  void setGeolocationOverride();

  /**
   * Overrides the Geolocation Position or Error. Omitting latitude, longitude or accuracy emulates
   * position unavailable.
   *
   * @param latitude Mock latitude
   * @param longitude Mock longitude
   * @param accuracy Mock accuracy
   * @param altitude Mock altitude
   * @param altitudeAccuracy Mock altitudeAccuracy
   * @param heading Mock heading
   * @param speed Mock speed
   */
  void setGeolocationOverride(
      @Optional @ParamName("latitude") Double latitude,
      @Optional @ParamName("longitude") Double longitude,
      @Optional @ParamName("accuracy") Double accuracy,
      @Optional @ParamName("altitude") Double altitude,
      @Optional @ParamName("altitudeAccuracy") Double altitudeAccuracy,
      @Optional @ParamName("heading") Double heading,
      @Optional @ParamName("speed") Double speed);

  /** @param type */
  @Experimental
  @Returns("requestedSamplingFrequency")
  Double getOverriddenSensorInformation(@ParamName("type") SensorType type);

  /**
   * Overrides a platform sensor of a given type. If |enabled| is true, calls to Sensor.start() will
   * use a virtual sensor as backend rather than fetching data from a real hardware sensor.
   * Otherwise, existing virtual sensor-backend Sensor objects will fire an error event and new
   * calls to Sensor.start() will attempt to use a real sensor instead.
   *
   * @param enabled
   * @param type
   */
  @Experimental
  void setSensorOverrideEnabled(
      @ParamName("enabled") Boolean enabled, @ParamName("type") SensorType type);

  /**
   * Overrides a platform sensor of a given type. If |enabled| is true, calls to Sensor.start() will
   * use a virtual sensor as backend rather than fetching data from a real hardware sensor.
   * Otherwise, existing virtual sensor-backend Sensor objects will fire an error event and new
   * calls to Sensor.start() will attempt to use a real sensor instead.
   *
   * @param enabled
   * @param type
   * @param metadata
   */
  @Experimental
  void setSensorOverrideEnabled(
      @ParamName("enabled") Boolean enabled,
      @ParamName("type") SensorType type,
      @Optional @ParamName("metadata") SensorMetadata metadata);

  /**
   * Updates the sensor readings reported by a sensor type previously overridden by
   * setSensorOverrideEnabled.
   *
   * @param type
   * @param reading
   */
  @Experimental
  void setSensorOverrideReadings(
      @ParamName("type") SensorType type, @ParamName("reading") SensorReading reading);

  /**
   * Overrides a pressure source of a given type, as used by the Compute Pressure API, so that
   * updates to PressureObserver.observe() are provided via setPressureStateOverride instead of
   * being retrieved from platform-provided telemetry data.
   *
   * @param enabled
   * @param source
   */
  @Experimental
  void setPressureSourceOverrideEnabled(
      @ParamName("enabled") Boolean enabled, @ParamName("source") PressureSource source);

  /**
   * Overrides a pressure source of a given type, as used by the Compute Pressure API, so that
   * updates to PressureObserver.observe() are provided via setPressureStateOverride instead of
   * being retrieved from platform-provided telemetry data.
   *
   * @param enabled
   * @param source
   * @param metadata
   */
  @Experimental
  void setPressureSourceOverrideEnabled(
      @ParamName("enabled") Boolean enabled,
      @ParamName("source") PressureSource source,
      @Optional @ParamName("metadata") PressureMetadata metadata);

  /**
   * TODO: OBSOLETE: To remove when setPressureDataOverride is merged. Provides a given pressure
   * state that will be processed and eventually be delivered to PressureObserver users. |source|
   * must have been previously overridden by setPressureSourceOverrideEnabled.
   *
   * @param source
   * @param state
   */
  @Experimental
  void setPressureStateOverride(
      @ParamName("source") PressureSource source, @ParamName("state") PressureState state);

  /**
   * Provides a given pressure data set that will be processed and eventually be delivered to
   * PressureObserver users. |source| must have been previously overridden by
   * setPressureSourceOverrideEnabled.
   *
   * @param source
   * @param state
   */
  @Experimental
  void setPressureDataOverride(
      @ParamName("source") PressureSource source, @ParamName("state") PressureState state);

  /**
   * Provides a given pressure data set that will be processed and eventually be delivered to
   * PressureObserver users. |source| must have been previously overridden by
   * setPressureSourceOverrideEnabled.
   *
   * @param source
   * @param state
   * @param ownContributionEstimate
   */
  @Experimental
  void setPressureDataOverride(
      @ParamName("source") PressureSource source,
      @ParamName("state") PressureState state,
      @Optional @ParamName("ownContributionEstimate") Double ownContributionEstimate);

  /**
   * Overrides the Idle state.
   *
   * @param isUserActive Mock isUserActive
   * @param isScreenUnlocked Mock isScreenUnlocked
   */
  void setIdleOverride(
      @ParamName("isUserActive") Boolean isUserActive,
      @ParamName("isScreenUnlocked") Boolean isScreenUnlocked);

  /** Clears Idle state overrides. */
  void clearIdleOverride();

  /**
   * Overrides value returned by the javascript navigator object.
   *
   * @param platform The platform navigator.platform should return.
   */
  @Deprecated
  @Experimental
  void setNavigatorOverrides(@ParamName("platform") String platform);

  /**
   * Sets a specified page scale factor.
   *
   * @param pageScaleFactor Page scale factor.
   */
  @Experimental
  void setPageScaleFactor(@ParamName("pageScaleFactor") Double pageScaleFactor);

  /**
   * Switches script execution in the page.
   *
   * @param value Whether script execution should be disabled in the page.
   */
  void setScriptExecutionDisabled(@ParamName("value") Boolean value);

  /**
   * Enables touch on platforms which do not support them.
   *
   * @param enabled Whether the touch event emulation should be enabled.
   */
  void setTouchEmulationEnabled(@ParamName("enabled") Boolean enabled);

  /**
   * Enables touch on platforms which do not support them.
   *
   * @param enabled Whether the touch event emulation should be enabled.
   * @param maxTouchPoints Maximum touch points supported. Defaults to one.
   */
  void setTouchEmulationEnabled(
      @ParamName("enabled") Boolean enabled,
      @Optional @ParamName("maxTouchPoints") Integer maxTouchPoints);

  /**
   * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and
   * sets the current virtual time policy. Note this supersedes any previous time budget.
   *
   * @param policy
   */
  @Experimental
  @Returns("virtualTimeTicksBase")
  Double setVirtualTimePolicy(@ParamName("policy") VirtualTimePolicy policy);

  /**
   * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and
   * sets the current virtual time policy. Note this supersedes any previous time budget.
   *
   * @param policy
   * @param budget If set, after this many virtual milliseconds have elapsed virtual time will be
   *     paused and a virtualTimeBudgetExpired event is sent.
   * @param maxVirtualTimeTaskStarvationCount If set this specifies the maximum number of tasks that
   *     can be run before virtual is forced forwards to prevent deadlock.
   * @param initialVirtualTime If set, base::Time::Now will be overridden to initially return this
   *     value.
   */
  @Experimental
  @Returns("virtualTimeTicksBase")
  Double setVirtualTimePolicy(
      @ParamName("policy") VirtualTimePolicy policy,
      @Optional @ParamName("budget") Double budget,
      @Optional @ParamName("maxVirtualTimeTaskStarvationCount")
          Integer maxVirtualTimeTaskStarvationCount,
      @Optional @ParamName("initialVirtualTime") Double initialVirtualTime);

  /** Overrides default host system locale with the specified one. */
  @Experimental
  void setLocaleOverride();

  /**
   * Overrides default host system locale with the specified one.
   *
   * @param locale ICU style C locale (e.g. "en_US"). If not specified or empty, disables the
   *     override and restores default host system locale.
   */
  @Experimental
  void setLocaleOverride(@Optional @ParamName("locale") String locale);

  /**
   * Overrides default host system timezone with the specified one.
   *
   * @param timezoneId The timezone identifier. List of supported timezones:
   *     https://source.chromium.org/chromium/chromium/deps/icu.git/+/faee8bc70570192d82d2978a71e2a615788597d1:source/data/misc/metaZones.txt
   *     If empty, disables the override and restores default host system timezone.
   */
  void setTimezoneOverride(@ParamName("timezoneId") String timezoneId);

  /**
   * Resizes the frame/viewport of the page. Note that this does not affect the frame's container
   * (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported
   * on Android.
   *
   * @param width Frame width (DIP).
   * @param height Frame height (DIP).
   */
  @Deprecated
  @Experimental
  void setVisibleSize(@ParamName("width") Integer width, @ParamName("height") Integer height);

  /** @param imageTypes Image types to disable. */
  @Experimental
  void setDisabledImageTypes(@ParamName("imageTypes") List<DisabledImageType> imageTypes);

  /** Override the value of navigator.connection.saveData */
  @Experimental
  void setDataSaverOverride();

  /**
   * Override the value of navigator.connection.saveData
   *
   * @param dataSaverEnabled Override value. Omitting the parameter disables the override.
   */
  @Experimental
  void setDataSaverOverride(@Optional @ParamName("dataSaverEnabled") Boolean dataSaverEnabled);

  /** @param hardwareConcurrency Hardware concurrency to report */
  @Experimental
  void setHardwareConcurrencyOverride(
      @ParamName("hardwareConcurrency") Integer hardwareConcurrency);

  /**
   * Allows overriding user agent with the given string. `userAgentMetadata` must be set for Client
   * Hint headers to be sent.
   *
   * @param userAgent User agent to use.
   */
  void setUserAgentOverride(@ParamName("userAgent") String userAgent);

  /**
   * Allows overriding user agent with the given string. `userAgentMetadata` must be set for Client
   * Hint headers to be sent.
   *
   * @param userAgent User agent to use.
   * @param acceptLanguage Browser language to emulate.
   * @param platform The platform navigator.platform should return.
   * @param userAgentMetadata To be sent in Sec-CH-UA-* headers and returned in
   *     navigator.userAgentData
   */
  void setUserAgentOverride(
      @ParamName("userAgent") String userAgent,
      @Optional @ParamName("acceptLanguage") String acceptLanguage,
      @Optional @ParamName("platform") String platform,
      @Experimental @Optional @ParamName("userAgentMetadata") UserAgentMetadata userAgentMetadata);

  /**
   * Allows overriding the automation flag.
   *
   * @param enabled Whether the override should be enabled.
   */
  @Experimental
  void setAutomationOverride(@ParamName("enabled") Boolean enabled);

  /**
   * Allows overriding the difference between the small and large viewport sizes, which determine
   * the value of the `svh` and `lvh` unit, respectively. Only supported for top-level frames.
   *
   * @param difference This will cause an element of size 100svh to be `difference` pixels smaller
   *     than an element of size 100lvh.
   */
  @Experimental
  void setSmallViewportHeightDifferenceOverride(@ParamName("difference") Integer difference);

  /**
   * Returns device's screen configuration. In headful mode, the physical screens configuration is
   * returned, whereas in headless mode, a virtual headless screen configuration is provided
   * instead.
   */
  @Experimental
  @Returns("screenInfos")
  @ReturnTypeParameter(ScreenInfo.class)
  List<ScreenInfo> getScreenInfos();

  /**
   * Add a new screen to the device. Only supported in headless mode.
   *
   * @param left Offset of the left edge of the screen in pixels.
   * @param top Offset of the top edge of the screen in pixels.
   * @param width The width of the screen in pixels.
   * @param height The height of the screen in pixels.
   */
  @Experimental
  @Returns("screenInfo")
  ScreenInfo addScreen(
      @ParamName("left") Integer left,
      @ParamName("top") Integer top,
      @ParamName("width") Integer width,
      @ParamName("height") Integer height);

  /**
   * Add a new screen to the device. Only supported in headless mode.
   *
   * @param left Offset of the left edge of the screen in pixels.
   * @param top Offset of the top edge of the screen in pixels.
   * @param width The width of the screen in pixels.
   * @param height The height of the screen in pixels.
   * @param workAreaInsets Specifies the screen's work area. Default is entire screen.
   * @param devicePixelRatio Specifies the screen's device pixel ratio. Default is 1.
   * @param rotation Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270.
   *     Default is 0.
   * @param colorDepth Specifies the screen's color depth in bits. Default is 24.
   * @param label Specifies the descriptive label for the screen. Default is none.
   * @param isInternal Indicates whether the screen is internal to the device or external, attached
   *     to the device. Default is false.
   */
  @Experimental
  @Returns("screenInfo")
  ScreenInfo addScreen(
      @ParamName("left") Integer left,
      @ParamName("top") Integer top,
      @ParamName("width") Integer width,
      @ParamName("height") Integer height,
      @Optional @ParamName("workAreaInsets") WorkAreaInsets workAreaInsets,
      @Optional @ParamName("devicePixelRatio") Double devicePixelRatio,
      @Optional @ParamName("rotation") Integer rotation,
      @Optional @ParamName("colorDepth") Integer colorDepth,
      @Optional @ParamName("label") String label,
      @Optional @ParamName("isInternal") Boolean isInternal);

  /**
   * Updates specified screen parameters. Only supported in headless mode.
   *
   * @param screenId Target screen identifier.
   */
  @Experimental
  @Returns("screenInfo")
  ScreenInfo updateScreen(@ParamName("screenId") String screenId);

  /**
   * Updates specified screen parameters. Only supported in headless mode.
   *
   * @param screenId Target screen identifier.
   * @param left Offset of the left edge of the screen in pixels.
   * @param top Offset of the top edge of the screen in pixels.
   * @param width The width of the screen in pixels.
   * @param height The height of the screen in pixels.
   * @param workAreaInsets Specifies the screen's work area.
   * @param devicePixelRatio Specifies the screen's device pixel ratio.
   * @param rotation Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270.
   * @param colorDepth Specifies the screen's color depth in bits.
   * @param label Specifies the descriptive label for the screen.
   * @param isInternal Indicates whether the screen is internal to the device or external, attached
   *     to the device. Default is false.
   */
  @Experimental
  @Returns("screenInfo")
  ScreenInfo updateScreen(
      @ParamName("screenId") String screenId,
      @Optional @ParamName("left") Integer left,
      @Optional @ParamName("top") Integer top,
      @Optional @ParamName("width") Integer width,
      @Optional @ParamName("height") Integer height,
      @Optional @ParamName("workAreaInsets") WorkAreaInsets workAreaInsets,
      @Optional @ParamName("devicePixelRatio") Double devicePixelRatio,
      @Optional @ParamName("rotation") Integer rotation,
      @Optional @ParamName("colorDepth") Integer colorDepth,
      @Optional @ParamName("label") String label,
      @Optional @ParamName("isInternal") Boolean isInternal);

  /**
   * Remove screen from the device. Only supported in headless mode.
   *
   * @param screenId
   */
  @Experimental
  void removeScreen(@ParamName("screenId") String screenId);

  /**
   * Set primary screen. Only supported in headless mode. Note that this changes the coordinate
   * system origin to the top-left of the new primary screen, updating the bounds and work areas of
   * all existing screens accordingly.
   *
   * @param screenId
   */
  @Experimental
  void setPrimaryScreen(@ParamName("screenId") String screenId);

  /**
   * Notification sent after the virtual time budget for the current VirtualTimePolicy has run out.
   */
  @EventName("virtualTimeBudgetExpired")
  @Experimental
  EventListener onVirtualTimeBudgetExpired(EventHandler<VirtualTimeBudgetExpired> eventListener);

  /**
   * Fired when a page calls screen.orientation.lock() or screen.orientation.unlock() while device
   * emulation is enabled. This allows the DevTools frontend to update the emulated device
   * orientation accordingly.
   */
  @EventName("screenOrientationLockChanged")
  @Experimental
  EventListener onScreenOrientationLockChanged(
      EventHandler<ScreenOrientationLockChanged> eventListener);
}
