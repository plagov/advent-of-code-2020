package io.plagov.advent

class Day02 {

  fun numberOfValidPasswordsByRepetitionFor(input: List<String>): Int {
    var counter = 0
    input.forEach { entry ->
      val password = password(entry)
      val mandatoryChar = mandatoryChar(entry)
      val minRepetition = firstPosition(entry)
      val maxRepetition = secondPosition(entry)

      if (password.contains(mandatoryChar)) {
        val size = password.filter { it == mandatoryChar }.size
        if (size in minRepetition..maxRepetition) {
          counter++
        }
      }
    }
    return counter
  }

  fun numberOfValidPasswordsByPositionsFor(input: List<String>): Int {
    return input.filter { entry ->
      val password = password(entry)
      val mandatoryChar = mandatoryChar(entry)
      val firstPosition = firstPosition(entry) - 1
      val secondPosition = secondPosition(entry) - 1

      (password[firstPosition] == mandatoryChar || password[secondPosition] == mandatoryChar)
        && !(password[firstPosition] == mandatoryChar && password[secondPosition] == mandatoryChar)
    }.count()
  }

  private fun password(entry: String) = entry.substringAfter(":").trim().toCharArray()

  private fun policy(entry: String) = entry.substringBefore(":").trim()

  private fun mandatoryChar(entry: String) = policy(entry).last()

  private fun firstPosition(entry: String) = policy(entry).substringBefore("-").toInt()

  private fun secondPosition(entry: String) = policy(entry).substringAfter("-")
    .substringBefore(" ").toInt()
}
