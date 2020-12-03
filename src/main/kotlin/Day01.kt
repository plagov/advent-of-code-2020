class Day01 {

  fun findMultiplyOfTwoNumbers(input: List<Int>): Int {
    var multiply = 0
    for (i in input) {
      for (k in input.minus(i)) {
        if (i + k == 2020) {
          multiply = i * k
        }
      }
    }
    return multiply
  }

  fun findMultiplyOfThreeNumbers(input: List<Int>): Int {
    var multiply = 0
    for (i in input) {
      val firstFilteredList = input.minus(i)
      for (k in firstFilteredList) {
        val secondFilteredList = firstFilteredList.minus(k)
        for (x in secondFilteredList) {
          if (i + k + x == 2020) {
            multiply = i * k * x
          }
        }
      }
    }
    return multiply
  }

}
