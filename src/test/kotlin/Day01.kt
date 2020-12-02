import org.junit.jupiter.api.Test
import java.io.File

class Day01 {

  private val allNumbers = File("src/test/resources/day01/expenses.txt").readLines()

  @Test
  fun findTwoNumbersThatSumTo2020() {
    outerLoop@ for (i in allNumbers) {
      for (k in allNumbers.minus(i)) {
        val first = i.toInt()
        val second = k.toInt()
        if (first + second == 2020) {
          println("Numbers are $first and $second")
          println("Multiply is: ${first * second}")
          break@outerLoop
        }
      }
    }
  }

  @Test
  fun findThreeNumbersThatSumTo2020() {
    outerLoop@ for (i in allNumbers) {
      val firstFilteredList = allNumbers.minus(i)
      for (k in firstFilteredList) {
        val secondFilteredList = firstFilteredList.minus(k)
        for (x in secondFilteredList) {
          val first = i.toInt()
          val second = k.toInt()
          val third = x.toInt()
          if (first + second + third == 2020) {
            println("Numbers are $first, $second and $third")
            println("Multiply is: ${first * second * third}")
            break@outerLoop
          }
        }
      }
    }
  }
}

