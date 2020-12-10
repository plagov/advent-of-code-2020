package io.plagov.advent

class Day04 {

  companion object {
    private val MANDATORY_FIELDS = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")
  }

  fun passportsWithValidFieldsOnly(input: List<String>) =
    parseInputToPassportEntries(input)
      .filter { passport -> MANDATORY_FIELDS.all { field -> passport.containsKey(field) } }

  fun passportsWithValidFieldsAndValues(input: List<String>) =
    passportsWithValidFieldsOnly(input)
      .filter { passport -> MANDATORY_FIELDS.all { field -> validateFieldForPassport(passport, field) } }

  private fun parseInputToPassportEntries(input: List<String>) =
    input.joinToString().replace(",", "").split("  ")
      .map { entry ->
        entry.split(" ")
          .map { field ->
            field.substringBefore(":") to field.substringAfter(":")
          }.toMap()
      }

  private fun validateFieldForPassport(passport: Map<String, String>, field: String): Boolean {
    val value = passport[field] ?: throw IllegalStateException("No entry with field $field")
    return when (field) {
      "byr" -> value.length == 4 && value.toInt() in 1920..2002
      "iyr" -> value.length == 4 && value.toInt() in 2010..2020
      "eyr" -> value.length == 4 && value.toInt() in 2020..2030
      "hgt" -> {
        listOf("cm", "in").any { value.endsWith(it) }
        if (value.endsWith("cm")) {
          value.substringBefore("cm").toInt() in 150..193
        } else {
          value.substringBefore("in").toInt() in 59..76
        }
      }
      "hcl" -> value.startsWith("#") && value.matches(Regex("#[0-9a-f]{6}"))
      "ecl" -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").any { value == it }
      "pid" -> value.matches(Regex("^\\d{9}$"))
      else -> throw IllegalStateException("Unknown key $field")
    }
  }

}
