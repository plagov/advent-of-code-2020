package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day06Test : ShouldSpec({

  val sampleInput = readInputFile("day06-sample.txt")

  val day6 = Day06()

  should("return correct sum of questions with answer 'yes' for sample input") {
    day6.sumForYesQuestions(sampleInput) shouldBe 11
  }

})
