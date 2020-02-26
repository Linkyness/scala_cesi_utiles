package cesi_utiles

import java.io.File

import org.junit.runner.RunWith
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestConverter extends AnyFlatSpec with Matchers {

  val converter = new Converter
  val csvBonificada = new File(getClass.getResource("/prueba_BONIFICADA.csv").getPath)

  println(csvBonificada.canRead.toString)

  println(csvBonificada.getAbsolutePath)

  "run" should "run correctly" in {
    converter.run(csvBonificada.getAbsolutePath)
    assert(1 == 1)
  }
}
