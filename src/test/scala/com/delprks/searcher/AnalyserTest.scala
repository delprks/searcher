package com.delprks.searcher

import org.scalatest.FunSuite
import Analyser._

class AnalyserTest extends FunSuite {

  test("100(%) is returned if all the words are found") {
    val words = Set("to", "be", "or", "not", "to", "be") // sets are unique, duplicates don't matter.
    val result = Set("be", "to", "or", "not") // order is not important.

    assert(percentage(words, result) == 100)
  }

  test("50(%) is returned if only half of the words are found") {
    val words = Set("to", "be", "or", "not")
    val result = Set("be", "to")

    assert(percentage(words, result) == 50)
  }

  test("0(%) is returned if no words are found") {
    val words = Set("to", "be", "or", "not")
    val result = Set.empty[String]

    assert(percentage(words, result) == 0)
  }

  test("top (specified) number of results are returned in the correct order") {
    val results = List(
      Result("file1.txt", 40),
      Result("file2.txt", 10),
      Result("file3.txt", 90),
      Result("file4.txt", 20),
      Result("file5.txt", 0)
    )

    val expected = List(
      Result("file3.txt", 90),
      Result("file1.txt", 40),
      Result("file4.txt", 20)
    )

    assert(subsetOfResults(results, 3) == expected)
  }

}
