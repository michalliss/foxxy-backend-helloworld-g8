import mill._
import mill.scalalib._

import $ivy.`com.goyeau::mill-scalafix::0.4.0`
import com.goyeau.mill.scalafix.ScalafixModule

object $name$ extends ScalaModule with ScalafixModule {

  def scalaVersion = "3.5.0"

  override def ivyDeps = Agg(ivy"io.github.michalliss::foxxy-backend:0.0.3")

  object test extends ScalaTests with TestModule.ZioTest {
    def ivyDeps = Agg(
      ivy"io.github.michalliss::foxxy-testing:0.0.3",
      ivy"dev.zio::zio-test:2.1.7",
      ivy"dev.zio::zio-test-sbt:2.1.7",
      ivy"dev.zio::zio-test-magnolia:2.1.7"
    )
  }
}
