import mill._
import mill.scalalib._

object $name$ extends ScalaModule {

  def scalaVersion = "3.5.0"

  override def ivyDeps = Agg(ivy"io.github.michalliss::foxxy-backend:0.0.2")

  object test extends ScalaTests with TestModule.ZioTest {
    def ivyDeps = Agg(
      ivy"io.github.michalliss::foxxy-testing:0.0.2",
      ivy"dev.zio::zio-test:2.1.7",
      ivy"dev.zio::zio-test-sbt:2.1.7",
      ivy"dev.zio::zio-test-magnolia:2.1.7"
    )
  }
}
