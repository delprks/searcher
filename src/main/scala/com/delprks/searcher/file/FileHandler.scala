package com.delprks.searcher.file

import java.io.File

import scala.collection.parallel.ParSeq
import scala.io.Source.fromFile

class FileHandler {

  def files(dir: String): List[File] = {
    val directory = new File(dir)

    if (directory.exists && directory.isDirectory) {
      directory.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def load(files: List[File]): ParSeq[LoadedFile] = {
    files.toParArray.map { file =>
      LoadedFile(file.getName, fromFile(file.getAbsolutePath, "ISO-8859-1").getLines().toIndexedSeq)
    }
  }
}
