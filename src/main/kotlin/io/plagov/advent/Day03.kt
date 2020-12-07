package io.plagov.advent

import kotlin.math.ceil

class Day03 {

  fun numberOfTreesForPlan(input: List<String>, stepsToRight: Int, stepsDown: Int): Long {
    val newInput = extendPattern(input, stepsToRight).drop(stepsDown)
    var move = 1
    var treesCounter = 0L
    for (i in newInput.indices step stepsDown) {
      val row = newInput[i]
      if (row[stepsToRight * move] == '#') {
        treesCounter++
      }
      move++
    }
    return treesCounter
  }

  private fun extendPattern(input: List<String>, stepsToRight: Int): List<String> {
    val totalNumberOfRows = input.size
    val initialWidthOfRow = input.first().length
    val numberToRepeatPatternToRight = (totalNumberOfRows * stepsToRight) / initialWidthOfRow.toDouble()

    return input.map { it.repeat(ceil(numberToRepeatPatternToRight).toInt()) }
  }

}
