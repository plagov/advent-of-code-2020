package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day01Test : ShouldSpec({

  val allNumbers = readInputFile("day01.txt").map { it.toInt() }
  val day1 = Day01()

  should("find two numbers that sum to 2020") {
    day1.findMultiplyOfTwoNumbers(allNumbers) shouldBe 1020084
  }

  should("find three numbers that sum to 2020") {
    day1.findMultiplyOfThreeNumbers(allNumbers) shouldBe 295086480
  }
})
