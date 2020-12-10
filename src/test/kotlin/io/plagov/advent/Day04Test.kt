package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day04Test : ShouldSpec ({

  val sampleInput = readInputFile("day04-sample.txt")
  val realInput = readInputFile("day04.txt")
  val day4 = Day04()

  should("return correct number of valid passports for sample input") {
    day4.numberOfValidPasswords(sampleInput) shouldBe 2
  }

  should("return correct number of valid passports for real input") {
    day4.numberOfValidPasswords(realInput) shouldBe 206
  }

})
