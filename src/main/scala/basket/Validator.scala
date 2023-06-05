package basket

class Validator {
  def validateBasket(usersBasket: Array[String]): Boolean = {
    val itemNames = Items.itemsRepository.keySet
    usersBasket.forall(itemNames.contains)
  }
}
