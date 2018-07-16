package com.delprks.searcher.analyse

object Finder {
  final val UNSUPPORTED_LETTERS_PATTERN = "[^a-z' ]"

  def find(words: Set[String], file: IndexedSeq[String]): Set[String] = {
    val result: List[String] = file.toParArray.flatMap { line =>
      stringToUniqueWords(line).filter(words)
    }.toList

    result.toSet
  }

  def stringToUniqueWords(input: String): Set[String] = input.toLowerCase.replaceAll(UNSUPPORTED_LETTERS_PATTERN, "").split(" ").toSet
}
