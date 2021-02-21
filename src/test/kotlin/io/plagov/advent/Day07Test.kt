package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day07Test : ShouldSpec({

  val sampleInput = readInputFile("day07-sample.txt")
  val realInput = readInputFile("day07.txt")

  val day7 = Day07()

  should("return correct number of bags that can hold 'shiny gold' from sample input") {
    day7.shinyGoldBagHolders(sampleInput) shouldBe 4
  }

  should("return correct number of bags that can hold 'shiny gold' from real input") {
    day7.shinyGoldBagHolders(realInput) shouldBe 274
  }

})
