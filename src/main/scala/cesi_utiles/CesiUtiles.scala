package cesi_utiles

import javafx.scene.image.{Image, ImageView}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.BorderPane

object CesiUtiles extends JFXApp {

  val csvToXml = new CsvToXml

  val cesiIcon = new Image("cesi.jpg")
  val cesiImage = new ImageView(cesiIcon)
  val label = new Label
  label.graphic = cesiImage

  val xmlIcon = new Image("xml.jpeg")
  val xmlImage = new ImageView(xmlIcon)
  xmlImage.fitHeight = 100
  xmlImage.fitWidth = 100
  val button = new Button
  button.graphic = xmlImage
  button.onAction = handle {csvToXml.open(cesiIcon)}

  stage = new PrimaryStage {
    scene = new Scene(500, 500) {
      root = new BorderPane {
        padding = Insets(25)
        top = label
        center = button
      }
    }
  }
  stage.getIcons.add(cesiIcon)
}