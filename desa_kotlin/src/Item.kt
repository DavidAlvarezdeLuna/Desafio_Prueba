open class Item(open var descripcion:String){

    open class Builder(var descripcion:String){
        fun descripcion(descripcion:String):Builder{
            this.descripcion = descripcion
            return this
        }

        fun build():Item{
            return Item(descripcion)
        }
    }

}