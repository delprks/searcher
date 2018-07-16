package com.delprks.searcher.analyse

import scala.collection.mutable
import util.control.Breaks._

object Finder {
  final val UNSUPPORTED_LETTERS_PATTERN = "[^a-z' ]"

  // to speed up the search, this method will stop looking or keywords (break out of the loop) as soon as all of them have been found
  def find(words: Set[String], lines: IndexedSeq[String]): Set[String] = {
    val resultContainer = new mutable.HashMap[String, Boolean]()

    words.map(word => resultContainer += (word -> false))

    breakable {
      lines.toParArray.foreach { line =>
        // only search for words that haven't been found yet
        val wordsToSearchFor = resultContainer.filter(_._2 == false).keys.toSet

        if (wordsToSearchFor.isEmpty) {
          break
        }

        val foundWords = stringToUniqueWords(line).filter(wordsToSearchFor)

        foundWords.foreach(word => resultContainer(word) = true)
      }
    }

    resultContainer.filter(_._2 == true).keys.toSet
  }

  def stringToUniqueWords(input: String): Set[String] = input.toLowerCase.replaceAll(UNSUPPORTED_LETTERS_PATTERN, "").split(" ").toSet
}
