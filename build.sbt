ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "pfps-shopping-cart",
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.7.0",
      "org.typelevel" %% "cats-effect" % "3.3.12",
      "com.github.cb372" %% "cats-retry" % "3.1.0",

      "io.circe" %% "circe-core" % "0.14.2",
      "io.circe" %% "circe-generic" % "0.14.2",
      "io.circe" %% "circe-parser" % "0.14.2",
      "io.circe" %% "circe-refined" % "0.14.2",

      "is.cir" %% "ciris" % "2.3.2",
      "is.cir" %% "ciris-refined" % "2.3.2",
      "is.cir" %% "ciris-enumeratum" % "2.3.2",

      "org.manatki" %% "derevo-core" % "0.11.6",
      "org.manatki" %% "derevo-cats" % "0.11.6",
      "org.manatki" %% "derevo-circe-magnolia" % "0.11.6",

      "org.http4s" %% "http4s-dsl" % "0.23.1",
      "org.http4s" %% "http4s-ember-server" % "0.23.1",
      "org.http4s" %% "http4s-ember-client" % "0.23.1",
      "org.http4s" %% "http4s-circe" % "0.23.1",

      "dev.profunktor" %% "http4s-jwt-auth" % "1.0.0",

      "dev.optics" %% "monocle-core" % "3.1.0",

      "eu.timepit" %% "refined" % "0.9.29",
      "eu.timepit" %% "refined-cats" % "0.9.29",

      "org.typelevel" %% "log4cats-slf4j" % "2.3.1",
      "io.estatico" %% "newtype" % "0.4.4",
//
      "javax.xml.crypto" % "jsr105-api" % "1.0.1",
//
      "dev.profunktor" %% "redis4cats-effects" % "1.1.1",
      "dev.profunktor" %% "redis4cats-log4cats" % "1.1.1",
//
      "org.tpolecat" %% "skunk-core" % "0.3.1",
      "org.tpolecat" %% "skunk-circe" % "0.3.1",
//
//      // Runtime
      "ch.qos.logback" % "logback-classic" % "1.2.11"
    )

  )
