class Arma (override var descripcion:String, var potencia:Int):Item(descripcion){

    override fun toString(): String{
        return "arma"
    }

    open class Builder(var descripcion:String, var potencia:Int){

        fun descripcion(descripcion:String):Builder{
            this.descripcion = descripcion
            return this
        }

        fun potencia(potencia:Int):Builder{
            this.potencia = potencia
            return this
        }

        fun build():Arma{
            return Arma(descripcion,potencia)
        }
    }


}