package com.delprks.searcher

import org.scalatest.FunSuite
import Formatter._

class FormatterTest extends FunSuite {

  test("percentage is formatted correctly") {
    assert(format("file1.txt", 40) == "file1.txt : 40%")
  }

}
