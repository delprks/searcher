package com.delprks.searcher.analyse

object Finder {
  def find(words: Set[String], file: IndexedSeq[String]): Set[String] = {
    val result: IndexedSeq[String] = file.flatMap { line =>
      line.toLowerCase.replaceAll("[^a-z' ]", "").split(" ").toSet.filter(words)
    }

    result.toSet
  }
}
