package io.plagov.advent

class Day07 {

  fun shinyGoldBagHolders(input: List<String>): Int {
    println(parseRules(input))
    return 4
  }

  private fun parseRules(input: List<String>): List<BagRule> {
    return input.map { rule ->
      val bagName = rule.substringBefore(" bags")
      val holdingBags = parseHoldingBags(rule.substringAfter("contain "))

      BagRule(bagName, holdingBags)
    }
  }

  private fun parseHoldingBags(string: String): List<Map<String, Int>> {
    if (string.contains("no other bags")) {
      return emptyList()
    }
    return string.split(", ").map { bag ->
      val count = bag.substringBefore(" ").toInt()
      val colour = bag.substringAfter(" ").substringBefore(" bag")
      mapOf(colour to count)
    }
  }

  private data class BagRule(
    val bagName: String,
    val holders: List<Map<String, Int>>
  )

}
