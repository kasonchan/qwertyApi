import sbt.Keys._

lazy val buildSettings = Seq(
  name := Settings.name,
  organization := Settings.organization,
  version := Settings.version,
  scalaVersion := Settings.versions.scala
)

lazy val compilerOptions = Settings.scalacOptions

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % Settings.versions.scalaTest,
  "org.scalacheck" %% "scalacheck" % Settings.versions.scalaCheck
)

val baseSettings = Seq(
  libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-http-core" % Settings.versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http" % Settings.versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % Settings.versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % Settings.versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-jackson" % Settings.versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % Settings.versions.akkaHttp
  ) ++ testDependencies.map(_ % "test"),
  scalacOptions in(Compile, console) := compilerOptions
)

lazy val noPublishSettings = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)

lazy val allSettings = baseSettings ++ buildSettings ++ noPublishSettings

lazy val qwertyApi = project.in(file("."))
  .settings(moduleName := Settings.name)
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
