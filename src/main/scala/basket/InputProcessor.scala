package basket

class InputProcessor {
  def processInput(userInput: String): Array[String] = {
    val processedInput = userInput.toLowerCase().trim.split("\\s+")
    processedInput
  }
}