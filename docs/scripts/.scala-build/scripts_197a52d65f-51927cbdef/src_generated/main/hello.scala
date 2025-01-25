

final class hello$_ {
def args = hello_sc.args$
def scriptPath = """hello.sc"""
/*<script>*/
//> using toolkit typelevel:default

import cats.effect._

object Main extends IOApp.Simple {
  val run = IO.println("Hello, World!")
}
/*</script>*/ /*<generated>*//*</generated>*/
}

object hello_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new hello$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export hello_sc.script as `hello`

