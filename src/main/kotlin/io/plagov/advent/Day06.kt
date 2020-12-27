package io.plagov.advent

class Day06 {

  fun sumForYesQuestions(input: List<String>) =
    parseInputToAnswersEntries(input)
      .sumOf { entry -> entry.toCharArray().toSet().size }

  private fun parseInputToAnswersEntries(input: List<String>) =
    input.joinToString()
      .replace(", , ", "\n")
      .replace(", ", "")
      .split("\n")
}
