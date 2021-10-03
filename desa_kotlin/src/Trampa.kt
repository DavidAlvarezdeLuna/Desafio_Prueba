class Trampa (override var descripcion:String):Item(descripcion){

    override fun toString(): String{
        return "tram"
    }

    open class Builder(var descripcion:String){

        fun descripcion(descripcion:String):Builder{
            this.descripcion = descripcion
            return this
        }

        fun build():Trampa{
            return Trampa(descripcion)
        }
    }

    fun matarTrampa(t:Tributo){
        println("Tributo del distrito "+t.distrito+" cae en una trampa y muere!!")
        //poner la posicion donde esta el tributo a null y ponerlo en el capitolio
    }
}