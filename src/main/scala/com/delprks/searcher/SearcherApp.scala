package com.delprks.searcher

import scala.io.StdIn.readLine
import Finder._
import Analyser._
import Formatter._

object SearcherApp extends App {
  if (args.length == 0) {
    throw new IllegalArgumentException("No​ ​directory​ ​given​ ​to​ ​index.")
  }

  val fileHandler = new FileHandler
  val dir = args(0)
  val listOfFiles = fileHandler.files(dir)
  val numOfFiles = listOfFiles.size

  if (numOfFiles > 0) {
    println(s"$numOfFiles files read in directory $dir")
    val loadedFiles = fileHandler.load(listOfFiles)

    while (true) {
      print("search> ")

      val userInput = readLine()

      userInput match {
        case ":quit" => System.exit(0)
        case searchTerm =>
          val searchSet: Set[String] = searchTerm.toLowerCase.split(" ").toSet

          val results: List[Result] = loadedFiles map { file =>
            val foundWords = find(searchSet, file.content)
            val foundPercentage = percentage(searchSet, foundWords)

            Result(file.name, foundPercentage)
          }

          subsetOfResults(results, 3) foreach { res =>
            println(format(res.filename, res.percentage))
          }
      }
    }
  } else {
    println(s"Did not find any files in $dir, exiting.")
  }
}
