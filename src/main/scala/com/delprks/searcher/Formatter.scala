package com.delprks.searcher

object Formatter {
  def format(result: Result): String = s"${result.filename} : ${result.percentage}%"
}
