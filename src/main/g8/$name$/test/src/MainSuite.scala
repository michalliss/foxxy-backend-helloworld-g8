package $name$

import zio.*
import zio.test.*
import foxxy.testing.*
import foxxy.backend.*
import sttp.tapir.DecodeResult.Value


object MainSuite extends ZIOSpecDefault {
    val spec = suite("Simple end to end test")(
        test("Endpoint test"){
            for {
                response <- TestClient.send(Main.endpointDescription, ())
            } yield assert(response)(Assertion.isRight(Assertion.equalTo("Hello, World!")))
        }
    ).provide(
        TestClient.startOnFreePort(
            port => Main.logic.provide(Backend.live, BackendConfig.withPort(port)),
            client => client.send(Main.endpointDescription, ()).unit
        )
    ) @@ TestAspect.withLiveClock @@ TestAspect.sequential @@ TestAspect.silentLogging
}
