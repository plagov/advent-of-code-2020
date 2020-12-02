class Day02 {

  fun numberOfValidPasswordsFor(input: List<String>): Int {
    var counter = 0
    input.forEach { entry ->
      val mandatoryChar = entry.policy().last()
      val minRepetition = entry.policy().first().toString().toInt()
      val maxRepetition = entry.policy().substringAfter("-").substringBefore(" ").toInt()

      if (entry.password().contains(mandatoryChar)) {
        val size = entry.password().filter { it == mandatoryChar }.size
        if (size in minRepetition..maxRepetition) {
          counter++
        }
      }
    }
    return counter
  }

  private fun String.policy() = this.substringBefore(":").trim()

  private fun String.password() = this.substringAfter(":").trim().toCharArray()
}
