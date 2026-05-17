package com.github.kklisura.cdt.protocol.types.page;

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

/** Parameters for the printToPDF command. */
public class PrintToPDFParameters {

  @Optional
  @ParamName("landscape")
  private Boolean landscape;

  @Optional
  @ParamName("displayHeaderFooter")
  private Boolean displayHeaderFooter;

  @Optional
  @ParamName("printBackground")
  private Boolean printBackground;

  @Optional
  @ParamName("scale")
  private Double scale;

  @Optional
  @ParamName("paperWidth")
  private Double paperWidth;

  @Optional
  @ParamName("paperHeight")
  private Double paperHeight;

  @Optional
  @ParamName("marginTop")
  private Double marginTop;

  @Optional
  @ParamName("marginBottom")
  private Double marginBottom;

  @Optional
  @ParamName("marginLeft")
  private Double marginLeft;

  @Optional
  @ParamName("marginRight")
  private Double marginRight;

  @Optional
  @ParamName("pageRanges")
  private String pageRanges;

  @Optional
  @ParamName("headerTemplate")
  private String headerTemplate;

  @Optional
  @ParamName("footerTemplate")
  private String footerTemplate;

  @Optional
  @ParamName("preferCSSPageSize")
  private Boolean preferCSSPageSize;

  @Experimental
  @Optional
  @ParamName("transferMode")
  private PrintToPDFTransferMode transferMode;

  @Experimental
  @Optional
  @ParamName("generateTaggedPDF")
  private Boolean generateTaggedPDF;

  @Experimental
  @Optional
  @ParamName("generateDocumentOutline")
  private Boolean generateDocumentOutline;

  /** Paper orientation. Defaults to false. */
  public Boolean getLandscape() {
    return landscape;
  }

  /** Paper orientation. Defaults to false. */
  public PrintToPDFParameters setLandscape(Boolean landscape) {
    this.landscape = landscape;
    return this;
  }

  /** Display header and footer. Defaults to false. */
  public Boolean getDisplayHeaderFooter() {
    return displayHeaderFooter;
  }

  /** Display header and footer. Defaults to false. */
  public PrintToPDFParameters setDisplayHeaderFooter(Boolean displayHeaderFooter) {
    this.displayHeaderFooter = displayHeaderFooter;
    return this;
  }

  /** Print background graphics. Defaults to false. */
  public Boolean getPrintBackground() {
    return printBackground;
  }

  /** Print background graphics. Defaults to false. */
  public PrintToPDFParameters setPrintBackground(Boolean printBackground) {
    this.printBackground = printBackground;
    return this;
  }

  /** Scale of the webpage rendering. Defaults to 1. */
  public Double getScale() {
    return scale;
  }

  /** Scale of the webpage rendering. Defaults to 1. */
  public PrintToPDFParameters setScale(Double scale) {
    this.scale = scale;
    return this;
  }

  /** Paper width in inches. Defaults to 8.5 inches. */
  public Double getPaperWidth() {
    return paperWidth;
  }

  /** Paper width in inches. Defaults to 8.5 inches. */
  public PrintToPDFParameters setPaperWidth(Double paperWidth) {
    this.paperWidth = paperWidth;
    return this;
  }

  /** Paper height in inches. Defaults to 11 inches. */
  public Double getPaperHeight() {
    return paperHeight;
  }

  /** Paper height in inches. Defaults to 11 inches. */
  public PrintToPDFParameters setPaperHeight(Double paperHeight) {
    this.paperHeight = paperHeight;
    return this;
  }

  /** Top margin in inches. Defaults to 1cm (~0.4 inches). */
  public Double getMarginTop() {
    return marginTop;
  }

  /** Top margin in inches. Defaults to 1cm (~0.4 inches). */
  public PrintToPDFParameters setMarginTop(Double marginTop) {
    this.marginTop = marginTop;
    return this;
  }

  /** Bottom margin in inches. Defaults to 1cm (~0.4 inches). */
  public Double getMarginBottom() {
    return marginBottom;
  }

  /** Bottom margin in inches. Defaults to 1cm (~0.4 inches). */
  public PrintToPDFParameters setMarginBottom(Double marginBottom) {
    this.marginBottom = marginBottom;
    return this;
  }

  /** Left margin in inches. Defaults to 1cm (~0.4 inches). */
  public Double getMarginLeft() {
    return marginLeft;
  }

  /** Left margin in inches. Defaults to 1cm (~0.4 inches). */
  public PrintToPDFParameters setMarginLeft(Double marginLeft) {
    this.marginLeft = marginLeft;
    return this;
  }

  /** Right margin in inches. Defaults to 1cm (~0.4 inches). */
  public Double getMarginRight() {
    return marginRight;
  }

  /** Right margin in inches. Defaults to 1cm (~0.4 inches). */
  public PrintToPDFParameters setMarginRight(Double marginRight) {
    this.marginRight = marginRight;
    return this;
  }

  /**
   * Paper ranges to print, one based, e.g., '1-5, 8, 11-13'. Pages are printed in the document
   * order, not in the order specified, and no more than once. Defaults to empty string, which
   * implies the entire document is printed. The page numbers are quietly capped to actual page
   * count of the document, and ranges beyond the end of the document are ignored. If this results
   * in no pages to print, an error is reported. It is an error to specify a range with start
   * greater than end.
   */
  public String getPageRanges() {
    return pageRanges;
  }

  /**
   * Paper ranges to print, one based, e.g., '1-5, 8, 11-13'. Pages are printed in the document
   * order, not in the order specified, and no more than once. Defaults to empty string, which
   * implies the entire document is printed. The page numbers are quietly capped to actual page
   * count of the document, and ranges beyond the end of the document are ignored. If this results
   * in no pages to print, an error is reported. It is an error to specify a range with start
   * greater than end.
   */
  public PrintToPDFParameters setPageRanges(String pageRanges) {
    this.pageRanges = pageRanges;
    return this;
  }

  /**
   * HTML template for the print header. Should be valid HTML markup with following classes used to
   * inject printing values into them: - `date`: formatted print date - `title`: document title -
   * `url`: document location - `pageNumber`: current page number - `totalPages`: total pages in the
   * document
   *
   * <p>For example, `&lt;span class=title&gt;&lt;/span&gt;` would generate span containing the
   * title.
   */
  public String getHeaderTemplate() {
    return headerTemplate;
  }

  /**
   * HTML template for the print header. Should be valid HTML markup with following classes used to
   * inject printing values into them: - `date`: formatted print date - `title`: document title -
   * `url`: document location - `pageNumber`: current page number - `totalPages`: total pages in the
   * document
   *
   * <p>For example, `&lt;span class=title&gt;&lt;/span&gt;` would generate span containing the
   * title.
   */
  public PrintToPDFParameters setHeaderTemplate(String headerTemplate) {
    this.headerTemplate = headerTemplate;
    return this;
  }

  /** HTML template for the print footer. Should use the same format as the `headerTemplate`. */
  public String getFooterTemplate() {
    return footerTemplate;
  }

  /** HTML template for the print footer. Should use the same format as the `headerTemplate`. */
  public PrintToPDFParameters setFooterTemplate(String footerTemplate) {
    this.footerTemplate = footerTemplate;
    return this;
  }

  /**
   * Whether or not to prefer page size as defined by css. Defaults to false, in which case the
   * content will be scaled to fit the paper size.
   */
  public Boolean getPreferCSSPageSize() {
    return preferCSSPageSize;
  }

  /**
   * Whether or not to prefer page size as defined by css. Defaults to false, in which case the
   * content will be scaled to fit the paper size.
   */
  public PrintToPDFParameters setPreferCSSPageSize(Boolean preferCSSPageSize) {
    this.preferCSSPageSize = preferCSSPageSize;
    return this;
  }

  /** return as stream */
  public PrintToPDFTransferMode getTransferMode() {
    return transferMode;
  }

  /** return as stream */
  public PrintToPDFParameters setTransferMode(PrintToPDFTransferMode transferMode) {
    this.transferMode = transferMode;
    return this;
  }

  /** Whether or not to generate tagged (accessible) PDF. Defaults to embedder choice. */
  public Boolean getGenerateTaggedPDF() {
    return generateTaggedPDF;
  }

  /** Whether or not to generate tagged (accessible) PDF. Defaults to embedder choice. */
  public PrintToPDFParameters setGenerateTaggedPDF(Boolean generateTaggedPDF) {
    this.generateTaggedPDF = generateTaggedPDF;
    return this;
  }

  /** Whether or not to embed the document outline into the PDF. */
  public Boolean getGenerateDocumentOutline() {
    return generateDocumentOutline;
  }

  /** Whether or not to embed the document outline into the PDF. */
  public PrintToPDFParameters setGenerateDocumentOutline(Boolean generateDocumentOutline) {
    this.generateDocumentOutline = generateDocumentOutline;
    return this;
  }
}
