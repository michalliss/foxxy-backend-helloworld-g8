package $name$

import foxxy.backend.*
import zio.*
import sttp.tapir.json.zio.*
import sttp.tapir.ztapir.*

object Main extends ZIOAppDefault {

  val endpointDescription = endpoint.get
    .in("hello")
    .out(jsonBody[String])

  val endpointHandler: FoxxyServerEndpoint =
    endpointDescription.zServerLogic(_ => ZIO.succeed("Hello, World!"))

  val logic = for {
    backend <- ZIO.service[Backend]
    _ <- backend.serve(List(endpointHandler))
  } yield ()

  def run = logic.provide(Backend.live, BackendConfig.withPort(9999))
}
