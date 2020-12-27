package io.plagov.advent

class Day06 {

  fun sumOfYesQuestionsFromAnyone(input: List<String>) =
    answerEntriesForFirstProblem(input).sumOf { it.toSet().size }

  fun sumOfYesAnswersFromAll(input: List<String>) =
    parseInputToAnswersEntries(input)
      .sumOf { entry ->
        entry.joinToString().length.takeIf { entry.size == 1 }
          ?: ('a'..'z').filter { character ->
            entry.all { it.contains(character) }
          }.size
      }

  private fun parseInputToAnswersEntries(input: List<String>) =
    input.joinToString()
      .replace(", , ", "\n")
      .replace(" ", "")
      .split("\n")
      .map { it.split(",") }

  private fun answerEntriesForFirstProblem(input: List<String>) =
    parseInputToAnswersEntries(input)
      .map { entry ->
        entry.joinToString()
          .replace(", ", "")
          .toCharArray()
      }
}
