//> using toolkit typelevel:default

import cats.effect._

object Main extends IOApp.Simple {
  val run = IO.println("Hello, World!")
}