package basket

// Specify Item trait implementations for all permitted items
trait Items {
  val itemsRepository: Map[String, Double]
}

object Items extends Items{
  override val itemsRepository: Map[String, Double] = Map(
    "soup" -> 0.65,
    "bread" -> 0.80,
    "milk" -> 1.30,
    "apples" -> 1.00
  )
}