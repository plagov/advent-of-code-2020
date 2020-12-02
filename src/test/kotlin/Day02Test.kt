import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

private val sampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

private val day2 = Day02()

class Day02Test : ShouldSpec({
  should("return correct number of valid passwords for sample input") {
    day2.numberOfValidPasswordsFor(sampleInput) shouldBe 2
  }
})
