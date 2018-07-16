package com.delprks.searcher.analyse

import com.delprks.searcher.analyse.Finder._
import org.scalatest.FunSuite

class FinderTest extends FunSuite {

  test("find method should return all the words that exist in the iterator") {
    val fileContent = IndexedSeq(
      """
        |To be, or not to be? That is the question—Whether ’tis nobler in the mind to suffer The slings and arrows of outrageous fortune,
        |Or to take arms against a sea of troubles, And, by opposing, end them?
      """.stripMargin
    )

    val words = Set("to", "be", "or", "not", "to", "be")

    assert(find(words, fileContent) == words)
  }

  test("find method should return empty set if none of the words in search query are found") {
    val fileContent = IndexedSeq(
      """
        |To be, or not to be? That is the question—Whether ’tis nobler in the mind to suffer The slings and arrows of outrageous fortune,
        |Or to take arms against a sea of troubles, And, by opposing, end them?
      """.stripMargin
    )

    val words = Set("non", "existent", "search", "query")

    assert(find(words, fileContent).isEmpty)
  }

  test("stringToUniqueWords method should extract unique words from give String") {
    val input = "To be or not to be"

    assert(stringToUniqueWords(input) == Set("to", "be", "or", "not"))
  }

  test("stringToUniqueWords method should include words with apostrophe") {
    val input = "It's to be or not to be"

    assert(stringToUniqueWords(input) == Set("it's", "to", "be", "or", "not"))
  }

}
