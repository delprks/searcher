package com.delprks.searcher

import scala.io.StdIn.readLine
import com.delprks.searcher.analyse.Finder._
import com.delprks.searcher.analyse.Analyser._
import com.delprks.searcher.output.Formatter._
import com.delprks.searcher.file.{FileHandler, LoadedFile}
import com.delprks.searcher.output.Result

import scala.collection.parallel.ParSeq

object SearcherApp extends App {
  if (args.length == 0) {
    throw new IllegalArgumentException("No​ ​directory​ ​given​ ​to​ ​index.")
  }

  final val RESULTS_TO_RETURN = 10

  val fileHandler = new FileHandler
  val directory = args(0)
  val listOfFiles = fileHandler.files(directory)
  val numOfFiles = listOfFiles.size

  if (numOfFiles > 0) {
    println(s"$numOfFiles files read in directory $directory")
    val loadedFiles: ParSeq[LoadedFile] = fileHandler.load(listOfFiles)

    while (true) {
      print("search> ")

      val userInput = readLine()

      userInput match {
        case ":quit" =>
          println("Exiting.")
          System.exit(0)

        case searchTerm =>
          val searchQuery: Set[String] = stringToUniqueWords(searchTerm)

          val results: ParSeq[Result] = loadedFiles map { file =>
            val foundWords = find(searchQuery, file.content)
            val foundPercentage = percentage(searchQuery, foundWords)

            Result(file.name, foundPercentage)
          }

          subsetOfResults(results.toList, RESULTS_TO_RETURN) foreach { result =>
            println(format(result))
          }
      }
    }
  } else {
    println(s"Did not find any files in $directory, exiting.")
  }
}
