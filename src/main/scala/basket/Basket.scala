package basket

class Basket(processedItemsList: Array[String]) {
  val itemList: List[Item] = processedItemsList.flatMap { itemName =>
    Items.itemsRepository.get(itemName).map(price => Item(itemName, price))
  }.toList
}
