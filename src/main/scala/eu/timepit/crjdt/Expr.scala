package eu.timepit.crjdt

sealed trait Expr extends Product with Serializable

object Expr {

  /** Selects the root of the JSON document tree. */
  case object Doc extends Expr

  /** Selects a variable that was previously defined in a let command. */
  final case class Var(name: String) extends Expr

  /** Selects a key within a map. */
  final case class DownField(expr: Expr, key: String) extends Expr

  /** Starts iterating over an ordered list. */
  final case class Iter(expr: Expr) extends Expr

  /** Moves to the next element in an ordered list. */
  final case class Next(expr: Expr) extends Expr

  /** Returns the set of keys in the map at the current cursor. */
  final case class Keys(expr: Expr) extends Expr

  /** Returns the contents of the multi-value register at the current cursor. */
  final case class Values(expr: Expr) extends Expr
}