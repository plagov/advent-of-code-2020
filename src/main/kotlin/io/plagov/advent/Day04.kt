package io.plagov.advent

class Day04 {
  fun numberOfValidPasswords(input: List<String>): Int {
    val passports = parseInputToPassportEntries(input)
    return 1
  }

  private fun parseInputToPassportEntries(input: List<String>) =
    input.joinToString().replace(",", "").split("  ")

}
