import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day03Test : ShouldSpec({

  val sampleInput = this::class.java.getResourceAsStream("inputs/day03-sample.txt")
    .bufferedReader().readLines()

  val realInput = this::class.java.getResourceAsStream("inputs/day03.txt")
    .bufferedReader().readLines()

  val day3 = Day03()

  should("return correct number of trees for sample input") {
    day3.numberOfTreesForPlan(sampleInput) shouldBe 7
  }

  should("return correct number of trees for real input") {
    day3.numberOfTreesForPlan(realInput) shouldBe 220
  }

})
