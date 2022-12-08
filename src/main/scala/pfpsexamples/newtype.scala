package pfpsexamples

import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.collection.Contains
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

object newtype1 {


  @newtype case class Username(value: String)
  @newtype case class Email(value: String)
  case class User(username: Username, email: Email)
  Email("Foo")


}

object refinement {
  @newtype case class Username(value: String)
  @newtype case class Email(value: String)

  case class User(username: Username, email: Email)

  def lookup[F[_]](username: NonEmptyString): F[Option[User]] = ???

  type Username1 = String Refined Contains['g']

  @newtype case class Brand(value: NonEmptyString)
  @newtype case class Category(value: NonEmptyString)
  val brand: Brand = Brand("foo")
}
