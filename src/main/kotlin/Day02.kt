class Day02 {

  fun numberOfValidPasswordsFor(input: List<String>): Int {
    var counter = 0
    input.forEach { entry ->
      if (entry.password().contains(entry.mandatoryChar())) {
        val size = entry.password().filter { it == entry.mandatoryChar() }.size
        if (size in entry.minRepetition()..entry.maxRepetition()) {
          counter++
        }
      }
    }
    return counter
  }

  private fun String.password() = this.substringAfter(":").trim().toCharArray()

  private fun policy(entry: String) = entry.substringBefore(":").trim()

  private fun String.mandatoryChar() = policy(this).last()

  private fun String.minRepetition(): Int {
    val char = policy(this).first()
    return Character.getNumericValue(char)
  }

  private fun String.maxRepetition() = policy(this).substringAfter("-").substringBefore(" ").toInt()
}
