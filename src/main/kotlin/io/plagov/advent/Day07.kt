package io.plagov.advent

class Day07 {

  fun shinyGoldBagHolders(input: List<String>): Int {
    val directHolders = parseRules(input).filter { rule ->
      rule.holders.any { holder -> holder.containsKey("shiny gold") }
    }

    val inDirectHolders = parseRules(input).minus(directHolders).filter { rule ->
      rule.holders.flatMap { it.keys }.any { insideBag ->
        insideBag in directHolders.map { directHolder -> directHolder.bagName }
      }
    }

    return directHolders.size + inDirectHolders.size
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
