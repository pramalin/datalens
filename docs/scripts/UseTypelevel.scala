import cats.effect.*
import fs2.io.file.Files

object Hello extends IOApp.Simple {
  def run = Files[IO].currentWorkingDirectory.flatMap { cwd =>
    IO.println(cwd.toString)
  }
}