package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day04Test : ShouldSpec ({

  val part1SampleInput = readInputFile("day04-part1-sample.txt")
  val part2SampleInput = readInputFile("day04-part2-sample.txt")
  val realInput = readInputFile("day04.txt")
  val day4 = Day04()

  should("return correct number of valid passports for sample input") {
    day4.passportsWithValidFieldsOnly(part1SampleInput).size shouldBe 2
  }

  should("return correct number of valid passports for real input") {
    day4.passportsWithValidFieldsOnly(realInput).size shouldBe 206
  }

  should("return correct number of valid passports with valid values for sample input") {
    day4.passportsWithValidFieldsAndValues(part2SampleInput).size shouldBe 4
  }

  should("return correct number of valid passports with valid values for real input") {
    day4.passportsWithValidFieldsAndValues(realInput).size shouldBe 123
  }

})
