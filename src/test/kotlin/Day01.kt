import org.junit.jupiter.api.Test
import java.io.File

class Day01 {

	private val allNumbers = File("src/test/resources/day01/expenses.txt").readLines()

	@Test
	fun test() {
		for (i in allNumbers) {
			for (k in allNumbers.minus(i)) {
				val first = i.toInt()
				val second = k.toInt()
				if (first + second == 2020) {
					println("Numbers are $first and $second")
					println("Multiply is: ${first * second}")
					break
				}
			}
		}
	}
}

