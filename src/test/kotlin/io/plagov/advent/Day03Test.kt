package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day03Test : ShouldSpec({

  val sampleInput = readInputFile("day03-sample.txt")
  val realInput = readInputFile("day03.txt")
  val day3 = Day03()

  should("return correct number of trees for sample input") {
    day3.numberOfTreesForPlan(sampleInput, stepsToRight = 3, stepsDown = 1) shouldBe 7
  }

  should("return correct number of trees for real input") {
    day3.numberOfTreesForPlan(realInput, stepsToRight = 3, stepsDown = 1) shouldBe 220
  }

  should("return correct multiply of different slopes for sample input") {
    val right1down1 = day3.numberOfTreesForPlan(sampleInput, stepsToRight = 1, stepsDown = 1)
    val right3down1 = day3.numberOfTreesForPlan(sampleInput, stepsToRight = 3, stepsDown = 1)
    val right5down1 = day3.numberOfTreesForPlan(sampleInput, stepsToRight = 5, stepsDown = 1)
    val right7down1 = day3.numberOfTreesForPlan(sampleInput, stepsToRight = 7, stepsDown = 1)
    val right1down2 = day3.numberOfTreesForPlan(sampleInput, stepsToRight = 1, stepsDown = 2)

    right1down1 * right3down1 * right5down1 * right7down1 * right1down2 shouldBe 336
  }

  should("return correct multiply of different slopes for real input") {
    val right1down1 = day3.numberOfTreesForPlan(realInput, stepsToRight = 1, stepsDown = 1)
    val right3down1 = day3.numberOfTreesForPlan(realInput, stepsToRight = 3, stepsDown = 1)
    val right5down1 = day3.numberOfTreesForPlan(realInput, stepsToRight = 5, stepsDown = 1)
    val right7down1 = day3.numberOfTreesForPlan(realInput, stepsToRight = 7, stepsDown = 1)
    val right1down2 = day3.numberOfTreesForPlan(realInput, stepsToRight = 1, stepsDown = 2)

    right1down1 * right3down1 * right5down1 * right7down1 * right1down2 shouldBe 2138320800
  }

})
