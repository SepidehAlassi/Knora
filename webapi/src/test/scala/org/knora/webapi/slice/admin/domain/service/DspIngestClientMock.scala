/*
 * Copyright © 2021 - 2023 Swiss National Data and Service Center for the Humanities and/or DaSCH Service Platform contributors.
 * SPDX-License-Identifier: Apache-2.0
 */

package org.knora.webapi.slice.admin.domain.service

import zio.Scope
import zio.Task
import zio.ZIO
import zio.ZLayer
import zio.nio.file.Path

import org.knora.webapi.slice.admin.domain.model.KnoraProject

object DspIngestClientMock {
  final case class MockDspIngestClient() extends DspIngestClient {
    override def exportProject(shortcode: KnoraProject.Shortcode): ZIO[Scope, Throwable, Path] =
      ZIO.succeed(Path("/tmp/test.zip"))
    override def importProject(shortcode: KnoraProject.Shortcode, fileToImport: Path): Task[Path] =
      ZIO.succeed(Path("/tmp/test.zip"))
  }
  val layer = ZLayer.fromFunction(MockDspIngestClient.apply _)
}
