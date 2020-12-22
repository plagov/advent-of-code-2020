package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day05Test : ShouldSpec({

  val samplePasses = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")
  val realInput = readInputFile("day05.txt")

  val day5 = Day05()

  should("return highest seat ID for sample boarding passes") {
    day5.highestSeatIdForPasses(samplePasses) shouldBe 820
  }

  should("return correct row number for sample boarding pass") {
    forAll(
      table(
        headers("boarding pass", "row number"),
        row("BFFFBBFRRR", 70),
        row("FFFBBBFRRR", 14),
        row("BBFFBBFRLL", 102)
      )
    ) { boardingPass, rowNumber -> day5.findRowNumberForPass(boardingPass) shouldBe rowNumber }
  }

  should("return correct column number for sample boarding pass") {
    forAll(
      table(
        headers("boarding pass", "column number"),
        row("BFFFBBFRRR", 7),
        row("FFFBBBFRRR", 7),
        row("BBFFBBFRLL", 4)
      )
    ) { boardingPass, columnNumber -> day5.findColumnNumberForPass(boardingPass) shouldBe columnNumber }
  }

  should("return highest seat ID for real boarding passes") {
    day5.highestSeatIdForPasses(realInput) shouldBe 838
  }

})
