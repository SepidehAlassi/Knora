/*
 * Copyright © 2021 - 2023 Swiss National Data and Service Center for the Humanities and/or DaSCH Service Platform contributors.
 * SPDX-License-Identifier: Apache-2.0
 */

package org.knora.webapi.http.version

import org.apache.pekko
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import pekko.http.scaladsl.model.headers.Server

/**
 * This spec is used to test 'ServerVersion'.
 */
class ServerVersionSpec extends AnyWordSpecLike with Matchers {
  "The server version header" should {
    "contain the necessary information" in {
      val header: Server = ServerVersion.serverVersionHeader
      header.toString() should include("webapi/")
      header.toString() should include("pekko-http/")
    }
  }
}
