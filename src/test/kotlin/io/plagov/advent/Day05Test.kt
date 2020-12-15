package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day05Test : ShouldSpec({

  val samplePasses = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")

  val day5 = Day05()

  should("return highest seat ID for sample boarding passes") {
    day5.highestSeatIdForPasses(samplePasses) shouldBe 820
  }

})
