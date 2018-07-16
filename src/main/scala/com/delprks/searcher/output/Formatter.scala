package com.delprks.searcher.output

object Formatter {
  def format(result: Result): String = s"${result.filename} : ${result.percentage}%"
}
