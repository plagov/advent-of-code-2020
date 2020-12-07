package io.plagov

fun readInputFile(fileName: String): List<String> {
  return Thread.currentThread().contextClassLoader
    .getResourceAsStream("inputs/$fileName")?.bufferedReader()?.readLines()
    ?: throw IllegalStateException("Cannot find file inputs/$fileName under test resources")
}
