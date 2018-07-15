package com.delprks.searcher

object Analyser {
  def percentage(words: Set[String], result: Set[String]): Int = {
    if (words == result) {
      100
    } else {
      result.size * 100 / words.size
    }
  }

  def subsetOfResults(results: List[Result], subset: Int = 10): List[Result] = {
    results.sortBy(- _.percentage).slice(0, subset)
  }
}
