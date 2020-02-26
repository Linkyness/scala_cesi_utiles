package cesi_utiles

import java.io.File

class Converter {
  def run(file: String): String = {

    val bufferedSource = io.Source.fromFile(file)
    for (line <- bufferedSource.getLines) {
      val cols = line.split(";").map(_.trim)
      // do whatever you want with the columns here
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    println("HELLO THERE!")





    "OMG, conversor seleccionado"
  }
}
