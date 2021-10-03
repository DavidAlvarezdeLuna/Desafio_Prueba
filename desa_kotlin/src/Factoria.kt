object Factoria {

    fun generarTributo(distrito:Int, vida:Int, fuerza:Int):Tributo{
        var t:Tributo = Tributo.Builder(distrito,vida,fuerza).distrito(distrito).vida(vida).fuerza(fuerza).build()
        return t
    }

    fun generarArma(descripcion:String, potencia:Int):Arma{
        var a:Arma = Arma.Builder(descripcion,potencia).descripcion(descripcion).potencia(potencia).build()
        return a
    }

    fun generarMedicina(descripcion:String, potencia:Int):Medicina{
        var m:Medicina = Medicina.Builder(descripcion,potencia).descripcion(descripcion).potencia(potencia).build()
        return m
    }

    fun generarTrampa(descripcion:String):Trampa{
        var tr:Trampa = Trampa.Builder(descripcion).descripcion(descripcion).build()
        return tr
    }


}