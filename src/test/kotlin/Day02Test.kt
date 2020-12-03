import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day02Test : ShouldSpec({

  val sampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
  val realInput = this::class.java.getResourceAsStream("inputs/day02.txt").bufferedReader().readLines()

  val day2 = Day02()

  should("return correct number of valid passwords for sample input") {
    day2.numberOfValidPasswordsByRepetitionFor(sampleInput) shouldBe 2
  }

  should("return correct number for valid passwords for real input") {
    day2.numberOfValidPasswordsByRepetitionFor(realInput) shouldBe 556
  }

  should("return correct number for valid passwords by positions for sample input") {
    val sample = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
    day2.numberOfValidPasswordsByPositionsFor(sample) shouldBe 1
  }

  should("return correct number for valid passwords by positions for real input") {
    day2.numberOfValidPasswordsByPositionsFor(realInput) shouldBe 605
  }

})
