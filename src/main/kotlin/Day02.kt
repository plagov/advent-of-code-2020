class Day02 {

  fun numberOfValidPasswordsFor(input: List<String>): Int {
    var counter = 0
    input.forEach { entry ->
      val password = password(entry)
      val mandatoryChar = mandatoryChar(entry)
      val minRepetition = minRepetition(entry)
      val maxRepetition = maxRepetition(entry)

      if (password.contains(mandatoryChar)) {
        val size = password.filter { it == mandatoryChar }.size
        if (size in minRepetition..maxRepetition) {
          counter++
        }
      }
    }
    return counter
  }

  private fun password(entry: String) = entry.substringAfter(":").trim().toCharArray()

  private fun policy(entry: String) = entry.substringBefore(":").trim()

  private fun mandatoryChar(entry: String) = policy(entry).last()

  private fun minRepetition(entry: String): Int {
    val char = policy(entry).first()
    return Character.getNumericValue(char)
  }

  private fun maxRepetition(entry: String) = policy(entry).substringAfter("-").substringBefore(" ").toInt()
}
