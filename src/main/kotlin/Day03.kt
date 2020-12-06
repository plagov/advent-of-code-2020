class Day03 {

  companion object {
    private const val STEPS_TO_RIGHT_AT_ONCE = 3
  }

  fun numberOfTreesForPlan(sampleInput: List<String>): Int {
    val newInput = extendPattern(sampleInput)
    println(newInput)
    return 0
  }

  private fun extendPattern(initialPattern: List<String>): List<String> {
    val totalNumberOfRows = initialPattern.size
    val initialWidthOfRow = initialPattern.first().length
    val numberToRepeatPatternToRight = (totalNumberOfRows * STEPS_TO_RIGHT_AT_ONCE) / initialWidthOfRow

    return initialPattern.map { it.repeat(numberToRepeatPatternToRight) }
  }

}
