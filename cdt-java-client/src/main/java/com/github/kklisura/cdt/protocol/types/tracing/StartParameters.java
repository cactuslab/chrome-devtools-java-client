package com.github.kklisura.cdt.protocol.types.tracing;

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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the start command. */
public class StartParameters {

  @Deprecated
  @Experimental
  @Optional
  @ParamName("categories")
  private String categories;

  @Deprecated
  @Experimental
  @Optional
  @ParamName("options")
  private String options;

  @Experimental
  @Optional
  @ParamName("bufferUsageReportingInterval")
  private Double bufferUsageReportingInterval;

  @Optional
  @ParamName("transferMode")
  private StartTransferMode transferMode;

  @Optional
  @ParamName("streamFormat")
  private StreamFormat streamFormat;

  @Experimental
  @Optional
  @ParamName("streamCompression")
  private StreamCompression streamCompression;

  @Optional
  @ParamName("traceConfig")
  private TraceConfig traceConfig;

  @Experimental
  @Optional
  @ParamName("perfettoConfig")
  private String perfettoConfig;

  @Experimental
  @Optional
  @ParamName("tracingBackend")
  private TracingBackend tracingBackend;

  /** Category/tag filter */
  public String getCategories() {
    return categories;
  }

  /** Category/tag filter */
  public StartParameters setCategories(String categories) {
    this.categories = categories;
    return this;
  }

  /** Tracing options */
  public String getOptions() {
    return options;
  }

  /** Tracing options */
  public StartParameters setOptions(String options) {
    this.options = options;
    return this;
  }

  /** If set, the agent will issue bufferUsage events at this interval, specified in milliseconds */
  public Double getBufferUsageReportingInterval() {
    return bufferUsageReportingInterval;
  }

  /** If set, the agent will issue bufferUsage events at this interval, specified in milliseconds */
  public StartParameters setBufferUsageReportingInterval(Double bufferUsageReportingInterval) {
    this.bufferUsageReportingInterval = bufferUsageReportingInterval;
    return this;
  }

  /**
   * Whether to report trace events as series of dataCollected events or to save trace to a stream
   * (defaults to `ReportEvents`).
   */
  public StartTransferMode getTransferMode() {
    return transferMode;
  }

  /**
   * Whether to report trace events as series of dataCollected events or to save trace to a stream
   * (defaults to `ReportEvents`).
   */
  public StartParameters setTransferMode(StartTransferMode transferMode) {
    this.transferMode = transferMode;
    return this;
  }

  /**
   * Trace data format to use. This only applies when using `ReturnAsStream` transfer mode (defaults
   * to `json`).
   */
  public StreamFormat getStreamFormat() {
    return streamFormat;
  }

  /**
   * Trace data format to use. This only applies when using `ReturnAsStream` transfer mode (defaults
   * to `json`).
   */
  public StartParameters setStreamFormat(StreamFormat streamFormat) {
    this.streamFormat = streamFormat;
    return this;
  }

  /**
   * Compression format to use. This only applies when using `ReturnAsStream` transfer mode
   * (defaults to `none`)
   */
  public StreamCompression getStreamCompression() {
    return streamCompression;
  }

  /**
   * Compression format to use. This only applies when using `ReturnAsStream` transfer mode
   * (defaults to `none`)
   */
  public StartParameters setStreamCompression(StreamCompression streamCompression) {
    this.streamCompression = streamCompression;
    return this;
  }

  public TraceConfig getTraceConfig() {
    return traceConfig;
  }

  public StartParameters setTraceConfig(TraceConfig traceConfig) {
    this.traceConfig = traceConfig;
    return this;
  }

  /**
   * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message When specified, the
   * parameters `categories`, `options`, `traceConfig` are ignored. (Encoded as a base64 string when
   * passed over JSON)
   */
  public String getPerfettoConfig() {
    return perfettoConfig;
  }

  /**
   * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message When specified, the
   * parameters `categories`, `options`, `traceConfig` are ignored. (Encoded as a base64 string when
   * passed over JSON)
   */
  public StartParameters setPerfettoConfig(String perfettoConfig) {
    this.perfettoConfig = perfettoConfig;
    return this;
  }

  /** Backend type (defaults to `auto`) */
  public TracingBackend getTracingBackend() {
    return tracingBackend;
  }

  /** Backend type (defaults to `auto`) */
  public StartParameters setTracingBackend(TracingBackend tracingBackend) {
    this.tracingBackend = tracingBackend;
    return this;
  }
}
