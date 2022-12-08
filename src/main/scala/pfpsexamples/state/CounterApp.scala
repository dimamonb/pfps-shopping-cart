package pfpsexamples.state

import cats.data.State
import cats.effect.{Ref, Sync}
import cats.implicits.toFunctorOps

object CounterApp {

}

trait Counter[F[_]]{
  def incr: F[Unit]
  def get: F[Int]
}

class LiveCounter[F[_]] private(
  ref: Ref[F, Int]
) extends Counter[F] {
  override def incr: F[Unit] = ref.update(_ + 1)

  override def get: F[Int] = ref.get
}

object LiveCounter {
  def make[F[_]: Sync]: F[Counter[F]] =
    Ref.of[F, Int](0).map(new LiveCounter(_))
}

object LiveCounter1 {
  def make[F[_]: Sync]: F[Counter[F]] = Ref.of[F, Int](0).map{ ref =>
    new Counter[F] {
      override def incr: F[Unit] = ref.update(_ + 1)

      override def get: F[Int] = ref.get
    }
  }
}

object StateApp extends App{

  val nextInt: State[Int, Int] =
    State(s => (s + 1, s * 2))
  def seq: State[Int, Int] =
    for {
      n1 <- nextInt
      n2 <- nextInt
      n3 <- nextInt
    } yield n1 + n2 + n3

  println(seq.runA(5).value)
}
