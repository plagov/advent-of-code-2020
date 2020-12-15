package io.plagov.advent

class Day05 {

  companion object {
    private val RANGE_OF_ROWS = (0..127).toList()
    private const val ROW_PART_BITS = 7
  }

  fun highestSeatIdForPasses(passes: List<String>): Int {
    return 1
  }

  fun findRowNumberForPass(pass: String): Int {
    return pass.take(ROW_PART_BITS).toCharArray().fold(RANGE_OF_ROWS, { accumulator, next ->
      val middlePosition = accumulator.size / 2
      if (next == 'F') {
        accumulator.slice(0 until middlePosition)
      } else {
        accumulator.slice(middlePosition until accumulator.size)
      }
    }).single()
  }

}
