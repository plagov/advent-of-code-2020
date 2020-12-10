package io.plagov.advent

class Day04 {

  companion object {
    private val MANDATORY_FIELDS = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt",)
  }

  fun numberOfValidPasswords(input: List<String>) =
    parseInputToPassportEntries(input).filter { passport ->
        MANDATORY_FIELDS.all { field -> passport.containsKey(field) }
    }.size

  private fun parseInputToPassportEntries(input: List<String>) =
    input.joinToString().replace(",", "").split("  ")
      .map { entry ->
        entry.split(" ")
          .map { field ->
            field.substringBefore(":") to field.substringAfter(":")
          }.toMap()
      }

}
