package io.plagov.advent

import kotlin.math.ceil

class Day03 {

  companion object {
    private const val STEPS_TO_RIGHT_AT_ONCE = 3
  }

  fun numberOfTreesForPlan(sampleInput: List<String>): Int {
    val newInput = extendPattern(sampleInput)
    var step = 1
    var counter = 0
    newInput.drop(1).forEach { row ->
      if (row[STEPS_TO_RIGHT_AT_ONCE * step] == '#') {
        counter++
      }
      step++
    }
    return counter
  }

  private fun extendPattern(initialPattern: List<String>): List<String> {
    val totalNumberOfRows = initialPattern.size
    val initialWidthOfRow = initialPattern.first().length
    val numberToRepeatPatternToRight = (totalNumberOfRows * STEPS_TO_RIGHT_AT_ONCE) / initialWidthOfRow.toDouble()

    return initialPattern.map { it.repeat(ceil(numberToRepeatPatternToRight).toInt()) }
  }

}
