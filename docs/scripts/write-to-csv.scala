//> using toolkit typelevel:0.1.29

import fs2.data.csv.*
import fs2.data.csv.generic.semiauto.*
import fs2.io.file.{Files, Path}
import cats.effect.{IO, IOApp}
import fs2.{Pipe, Stream}

def writeCaseClassToCsv[A](
    path: Path
)(using CsvRowEncoder[A, String]): Pipe[IO, A, Nothing] =
  _.through(encodeUsingFirstHeaders(fullRows = true))
    .through(fs2.text.utf8.encode)
    .through(Files[IO].writeAll(path))


object WriteBooksToCsv extends IOApp.Simple:
  case class Book(id: Long, name: String, isbn: String)
  given CsvRowEncoder[Book, String] = deriveCsvRowEncoder

  val input = Seq(
    Book(1, "Programming in Scala", "9780997148008"),
    Book(2, "Hands-on Scala Programming", "9798387677205"),
    Book(3, "Functional Programming in Scala", "9781617299582")
  )

  def run: IO[Unit] =
    Stream
      .emits(input)
      .through(writeCaseClassToCsv(Path("books.csv")))
      .compile
      .drain *> IO.println("Finished writing books to books.csv.")