package cesi_utiles

import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.image.Image
import scalafx.scene.layout._
import scalafx.stage.FileChooser.ExtensionFilter
import scalafx.stage.{FileChooser, Stage}
import java.io.File

import cesi_utiles.TipoCurso._

class CsvToXml {

  def open(cesiIcon: Image): Unit = {

    val converter = new Converter
    var file: File = new File("")
    var tipoCurso: TipoCurso = Organizadora
    var isOnline: Boolean = false

    val btnSelect = new Button("Selecciona...")
    val btnConv = new Button("Convertir")
    btnConv.disable = true
    val textField = new TextField
    textField.disable = true

    implicit val logArea: TextArea = new TextArea

    val checkBox = new CheckBox("Curso online")
    checkBox.onAction = handle {
      isOnline = checkBox.selected()
      if (isOnline) {
        logger("Seleccionado curso online")
      }
      else {
        logger("No es un curso online")
      }
    }


    val tog = new ToggleGroup

    val buttons = new VBox(10, btnSelect, btnConv)

    val fileTypeSelector: VBox = new VBox {
      spacing = 10
      children = List(
        new RadioButton {
          text = "Organizadora"
          toggleGroup = tog
          selected = true
          onAction = handle {
            tipoCurso = Organizadora
            logger(s"Tipo: ${tipoCurso.toString}")
          }
        },
        new RadioButton {
          text = "Grupo Empresa"
          toggleGroup = tog
          onAction = handle {
            tipoCurso = GrupoEmpresa
            logger(s"Tipo: ${tipoCurso.toString}")
          }
        },
        new RadioButton {
          text = "Bonificada"
          toggleGroup = tog
          onAction = handle {
            tipoCurso = Bonificada
            logger(s"Tipo: ${tipoCurso.toString}")
          }
        }
      )
    }

    val centerRegion = new HBox(20, buttons, fileTypeSelector, checkBox)
    centerRegion.padding = Insets(10)

    val newWindow = new Stage {
      scene = new Scene(500, 500) {
        root = new BorderPane {
          padding = Insets(25)
          center = centerRegion
          top = textField
          bottom = logArea
        }
      }
    }

    btnSelect.onAction = handle {
      val fileChooser = new FileChooser
      fileChooser.getExtensionFilters.add(new ExtensionFilter("Ficheros CSV (*.csv)", "*.csv"))
      file = fileChooser.showOpenDialog(newWindow)
      textField.text = file.toString
      logger(s"Seleccionado: $file")
      btnConv.disable = false
    }

    btnConv.onAction = handle {
      logger(converter.run(file.getAbsolutePath))
    }

    newWindow.getIcons.add(cesiIcon)
    newWindow.show()
  }

  def logger(message: String)(implicit log: TextArea): Unit = {
    log.text() += s"$message\n"
    log.scrollTop = Double.MaxValue
  }
}
