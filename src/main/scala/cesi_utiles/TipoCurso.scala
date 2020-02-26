package cesi_utiles

sealed trait TipoCurso

object TipoCurso {
  case object Organizadora extends TipoCurso {
    override def toString: String = "Organizadora"
  }
  case object GrupoEmpresa extends TipoCurso {
    override def toString: String = "Grupo Empresa"
  }
  case object Bonificada extends TipoCurso {
    override def toString: String = "Bonificada"
  }
}
