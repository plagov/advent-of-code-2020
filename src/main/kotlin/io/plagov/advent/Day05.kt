package io.plagov.advent

class Day05 {

  companion object {
    private val RANGE_OF_ROWS = (0..127).toList()
    private val RANGE_OF_COLUMNS = (0..7).toList()
    private const val ROW_PART_BITS = 7
    private const val COLUMN_PART_BITS = 3
  }

  fun seatIdsForPasses(passes: List<String>) =
    passes.map { pass ->
      val rowId = findRowNumberForPass(pass)
      val columnId = findColumnNumberForPass(pass)
      rowId * 8 + columnId
    }

  fun findMissingSeatIdFromPasses(passes: List<String>): Int {
    val allSeatIds = seatIdsForPasses(passes)
    return allSeatIds.sorted().drop(RANGE_OF_COLUMNS.size).dropLast(RANGE_OF_COLUMNS.size)
      .filter { seat -> seat + 1 !in allSeatIds }
      .map { it + 1 }
      .single()
  }

  fun findRowNumberForPass(pass: String) =
    pass.take(ROW_PART_BITS).toCharArray().fold(RANGE_OF_ROWS, { accumulator, bit ->
      val middlePosition = accumulator.size / 2
      accumulator.slice(0 until middlePosition).takeIf { bit == 'F' }
        ?: accumulator.slice(middlePosition until accumulator.size)
    }).single()

  fun findColumnNumberForPass(pass: String) =
    pass.takeLast(COLUMN_PART_BITS).toCharArray().fold(RANGE_OF_COLUMNS, { accumulator, bit ->
      val middlePosition = accumulator.size / 2
      accumulator.slice(0 until middlePosition).takeIf { bit == 'L' }
        ?: accumulator.slice(middlePosition until accumulator.size)
    }).single()

}
