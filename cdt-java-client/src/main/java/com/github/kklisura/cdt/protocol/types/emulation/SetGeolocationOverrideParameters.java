package com.github.kklisura.cdt.protocol.types.emulation;

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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the setGeolocationOverride command. */
public class SetGeolocationOverrideParameters {

  @Optional
  @ParamName("latitude")
  private Double latitude;

  @Optional
  @ParamName("longitude")
  private Double longitude;

  @Optional
  @ParamName("accuracy")
  private Double accuracy;

  @Optional
  @ParamName("altitude")
  private Double altitude;

  @Optional
  @ParamName("altitudeAccuracy")
  private Double altitudeAccuracy;

  @Optional
  @ParamName("heading")
  private Double heading;

  @Optional
  @ParamName("speed")
  private Double speed;

  /** Mock latitude */
  public Double getLatitude() {
    return latitude;
  }

  /** Mock latitude */
  public SetGeolocationOverrideParameters setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /** Mock longitude */
  public Double getLongitude() {
    return longitude;
  }

  /** Mock longitude */
  public SetGeolocationOverrideParameters setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /** Mock accuracy */
  public Double getAccuracy() {
    return accuracy;
  }

  /** Mock accuracy */
  public SetGeolocationOverrideParameters setAccuracy(Double accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /** Mock altitude */
  public Double getAltitude() {
    return altitude;
  }

  /** Mock altitude */
  public SetGeolocationOverrideParameters setAltitude(Double altitude) {
    this.altitude = altitude;
    return this;
  }

  /** Mock altitudeAccuracy */
  public Double getAltitudeAccuracy() {
    return altitudeAccuracy;
  }

  /** Mock altitudeAccuracy */
  public SetGeolocationOverrideParameters setAltitudeAccuracy(Double altitudeAccuracy) {
    this.altitudeAccuracy = altitudeAccuracy;
    return this;
  }

  /** Mock heading */
  public Double getHeading() {
    return heading;
  }

  /** Mock heading */
  public SetGeolocationOverrideParameters setHeading(Double heading) {
    this.heading = heading;
    return this;
  }

  /** Mock speed */
  public Double getSpeed() {
    return speed;
  }

  /** Mock speed */
  public SetGeolocationOverrideParameters setSpeed(Double speed) {
    this.speed = speed;
    return this;
  }
}
