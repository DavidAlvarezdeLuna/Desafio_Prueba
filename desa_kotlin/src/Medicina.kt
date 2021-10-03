class Medicina (override var descripcion:String, var potencia:Int):Item(descripcion){

    override fun toString(): String{
        return "medi"
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

        fun build():Medicina{
            return Medicina(descripcion,potencia)
        }
    }

    fun sumarVida(t:Tributo):Int{
        println("Tributo del distrito "+t.distrito+" recupera "+this.potencia+"puntos de vida")
        var vidaTotal=t.vida+this.potencia
        return vidaTotal
    }

}