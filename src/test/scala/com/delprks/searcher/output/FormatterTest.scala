package com.delprks.searcher.output

import com.delprks.searcher.output.Formatter._
import org.scalatest.FunSuite

class FormatterTest extends FunSuite {

  test("percentage is formatted correctly") {
    assert(format(Result("file1.txt", 40)) == "file1.txt : 40%")
  }

}
