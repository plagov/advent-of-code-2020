package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day03Test : ShouldSpec({

  val sampleInput = readInputFile("day03-sample.txt")
  val realInput = readInputFile("day03.txt")
  val day3 = Day03()

  should("return correct number of trees for sample input") {
    day3.numberOfTreesForPlan(sampleInput) shouldBe 7
  }

  should("return correct number of trees for real input") {
    day3.numberOfTreesForPlan(realInput) shouldBe 220
  }

})
