import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.io.File

private val sampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
private val realInput = File("src/test/resources/inputs/day02.txt").readLines()

private val day2 = Day02()

class Day02Test : ShouldSpec({

  should("return correct number of valid passwords for sample input") {
    day2.numberOfValidPasswordsFor(sampleInput) shouldBe 2
  }

  should("return correct number for valid passwords for real input") {
    day2.numberOfValidPasswordsFor(realInput) shouldBe 556
  }
})
