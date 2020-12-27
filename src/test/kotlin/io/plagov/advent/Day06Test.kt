package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.readInputFile

class Day06Test : ShouldSpec({

  val sampleInput = readInputFile("day06-sample.txt")
  val realInput = readInputFile("day06.txt")

  val day6 = Day06()

  should("return correct sum of questions with answer 'yes' for sample input from anyone") {
    day6.sumOfYesQuestionsFromAnyone(sampleInput) shouldBe 11
  }

  should("return correct sum of questions with answer 'yes' for real input from anyone") {
    day6.sumOfYesQuestionsFromAnyone(realInput) shouldBe 6748
  }

  should("return correct sum of question with answer 'yes' for sample input from all") {
    day6.sumOfYesAnswersFromAll(sampleInput) shouldBe 6
  }

})
