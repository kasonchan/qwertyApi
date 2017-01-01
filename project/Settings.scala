/**
  * @author kasonchan
  * @since Jan-2017
  */
object Settings {

  val name = "qwerty-api"

  val version = "0.1.0"

  val organization = "com.kasonchan"

  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature",
    "utf-8"
  )

  object versions {
    val scala = "2.11.8"
    val scalaCheck = "1.13.4"
    val scalaTest = "3.0.1"

    val akka = "2.4.16"
    val akkaHttp = "10.0.1"
  }

}