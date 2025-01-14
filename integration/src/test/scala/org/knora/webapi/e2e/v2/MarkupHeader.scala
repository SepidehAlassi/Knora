/*
 * Copyright © 2021 - 2023 Swiss National Data and Service Center for the Humanities and/or DaSCH Service Platform contributors.
 * SPDX-License-Identifier: Apache-2.0
 */

package org.knora.webapi.e2e.v2

import org.apache.pekko

import scala.util.Try

import org.knora.webapi.routing.RouteUtilV2

import pekko.http.scaladsl.model.headers.ModeledCustomHeader
import pekko.http.scaladsl.model.headers.ModeledCustomHeaderCompanion

/**
 * A custom Pekko HTTP header representing [[RouteUtilV2.MARKUP_HEADER]], which a client can send to specify
 * how text markup should be returned in an API response.
 *
 * The definition follows [[https://doc.pekko.io/docs/pekko-http/current/common/http-model.html#custom-headers]].
 */
final class MarkupHeader(token: String) extends ModeledCustomHeader[MarkupHeader] {
  override def renderInRequests             = true
  override def renderInResponses            = true
  override val companion: MarkupHeader.type = MarkupHeader
  override def value: String                = token
}

object MarkupHeader extends ModeledCustomHeaderCompanion[MarkupHeader] {
  override val name: String         = RouteUtilV2.MARKUP_HEADER
  override def parse(value: String) = Try(new MarkupHeader(value))
}
