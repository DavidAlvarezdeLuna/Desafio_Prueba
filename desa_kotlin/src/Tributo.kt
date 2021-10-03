import kotlin.random.Random

class Tributo(var distrito:Int, var vida:Int, var fuerza:Int) {

    override fun toString(): String{
        return "TRI"+this.distrito
    }

    open class Builder(var distrito:Int, var vida:Int, var fuerza:Int){
        fun distrito(distrito:Int):Builder{
            this.distrito = distrito
            return this
        }
        fun vida(vida:Int):Builder{
            this.vida = vida
            return this
        }
        fun fuerza(fuerza:Int):Builder{
            this.fuerza = fuerza
            return this
        }
        fun build():Tributo{
            return Tributo(distrito,vida,fuerza)
        }

    }

    fun desplazamiento(t:Array<Array<Any?>>,i:Int,j:Int,capi:Capitolio){

        var direccion:Int = -1
        var movido:Boolean = false
        var resultado:Boolean

        do{
            direccion=Random.nextInt(0,4) //0:Arriba, 1:Derecha, 2:Abajo, 3:Izquierda

            when(direccion){
                0->{
                    if(i+1 < t.size){
                        movido = true
                        if(t[i+1][j] is Tributo){
                            resultado=this.partir_cara(t[i+1][j] as Tributo)

                            if(resultado){
                                capi.listaMuertos.add(t[i+1][j] as Tributo)
                                println("GANA EL ATACANTE")
                                t[i+1][j] = t[i][j]
                                t[i][j] = null
                            }else{
                                capi.listaMuertos.add(t[i][j] as Tributo)
                                println("GANA EL DEFENSOR")
                                t[i][j] = t[i+1][j]
                                t[i+1][j] = null
                            }

                        }else{
                            if(t[i+1][j] is Arma){
                                println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA ARMA!")
                                this.fuerza=ganaFuerza(t[i+1][j] as Arma)
                                t[i+1][j] = t[i][j]
                                t[i][j] = null
                            }else{
                                if(t[i+1][j] is Medicina) {
                                    println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA MEDICINA!")
                                    this.vida = ganaVida(t[i+1][j] as Medicina)
                                    t[i+1][j] = t[i][j]
                                    t[i][j] = null
                                }else {
                                    if (t[i+1][j] is Trampa) {
                                        println("TRIBUTO DEL DISTRITO "+this.distrito+" MUERTO EN UNA TRAMPA!!")
                                        capi.listaMuertos.add(t[i][j] as Tributo)
                                        t[i+1][j] = null
                                        t[i][j] = null
                                    }
                                }
                            }
                        }
                    }
                }
                1->{
                    if(j+1 < t.size){
                        movido = true
                        if(t[i][j+1] is Tributo){
                            resultado=this.partir_cara(t[i][j+1] as Tributo)

                            if(resultado){
                                capi.listaMuertos.add(t[i][j+1] as Tributo)
                                println("GANA EL ATACANTE")
                                t[i][j+1] = t[i][j]
                                t[i][j] = null
                            }else {
                                capi.listaMuertos.add(t[i][j] as Tributo)
                                println("GANA EL DEFENSOR")
                                t[i][j] = t[i][j+1]
                                t[i][j+1] = null
                            }
                        }else{
                            if(t[i][j+1] is Arma) {
                                println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA ARMA!")
                                this.fuerza = ganaFuerza(t[i][j+1] as Arma)
                                t[i][j+1] = t[i][j]
                                t[i][j] = null
                            }else {
                                if (t[i][j+1] is Medicina) {
                                    println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA MEDICINA!")
                                    this.vida = ganaVida(t[i][j+1] as Medicina)
                                    t[i][j+1] = t[i][j]
                                    t[i][j] = null
                                }else {
                                    if (t[i][j+1] is Trampa) {
                                        println("TRIBUTO DEL DISTRITO "+this.distrito+" MUERTO EN UNA TRAMPA!!")
                                        capi.listaMuertos.add(t[i][j] as Tributo)
                                        t[i][j+1] = null
                                        t[i][j] = null
                                    }
                                }
                            }
                        }
                    }
                }
                2->{
                    if(i-1 >= 0){
                        movido = true
                        if(t[i-1][j] is Tributo){
                            resultado=this.partir_cara(t[i-1][j] as Tributo)

                            if(resultado){
                                capi.listaMuertos.add(t[i-1][j] as Tributo)
                                println("GANA EL ATACANTE")
                                t[i-1][j] = t[i][j]
                                t[i][j] = null
                            }else{
                                capi.listaMuertos.add(t[i][j] as Tributo)
                                println("GANA EL DEFENSOR")
                                t[i][j] = t[i-1][j]
                                t[i-1][j] = null
                            }
                        }else{
                            if(t[i-1][j] is Arma){
                                println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA ARMA!")
                                this.fuerza=ganaFuerza(t[i-1][j] as Arma)
                                t[i-1][j] = t[i][j]
                                t[i][j] = null
                            }else {
                                if (t[i-1][j] is Medicina) {
                                    println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA MEDICINA!")
                                    this.vida = ganaVida(t[i-1][j] as Medicina)
                                    t[i-1][j] = t[i][j]
                                    t[i][j] = null
                                }else{
                                    if(t[i-1][j] is Trampa){
                                        println("TRIBUTO DEL DISTRITO "+this.distrito+" MUERTO EN UNA TRAMPA!!")
                                        capi.listaMuertos.add(t[i][j] as Tributo)
                                        t[i-1][j] = null
                                        t[i][j] = null
                                    }
                                }
                            }
                        }
                    }
                }
                3->{
                    if(j-1 >= 0){
                        movido = true
                        if(t[i][j-1] is Tributo){
                            resultado=this.partir_cara(t[i][j-1] as Tributo)

                            if(resultado){
                                capi.listaMuertos.add(t[i][j-1] as Tributo)
                                println("GANA EL ATACANTE")
                                t[i][j-1] = t[i][j]
                                t[i][j] = null
                            }else {
                                capi.listaMuertos.add(t[i][j] as Tributo)
                                println("GANA EL DEFENSOR")
                                t[i][j] = t[i][j-1]
                                t[i][j-1] = null
                            }
                        }else{
                            if(t[i][j-1] is Arma){
                                println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA ARMA!")
                                this.fuerza=ganaFuerza(t[i][j-1] as Arma)
                                t[i][j-1] = t[i][j]
                                t[i][j] = null
                            }else {
                                if (t[i][j-1] is Medicina) {
                                    println("TRIBUTO DEL DISTRITO "+this.distrito+" ENCUENTRA MEDICINA!")
                                    this.vida = ganaVida(t[i][j-1] as Medicina)
                                    t[i][j-1] = t[i][j]
                                    t[i][j] = null
                                }else {
                                    if (t[i][j-1] is Trampa) {
                                        println("TRIBUTO DEL DISTRITO "+this.distrito+" MUERTO EN UNA TRAMPA!!")
                                        capi.listaMuertos.add(t[i][j] as Tributo)
                                        t[i][j-1] = null
                                        t[i][j] = null
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }while(!movido)


    }

    fun partir_cara(t2:Tributo):Boolean{
        var gana1:Boolean
        var azar:Int
        println("PELEA ENTRE EL ATACANTE DEL DISTRITO "+this.distrito+" Y DEFENSOR DEL "+t2.distrito)
        if(this.fuerza>t2.fuerza){
            gana1=true
        }else{
            if(this.fuerza==t2.fuerza){

                if(this.vida>t2.vida){
                    gana1=true
                }else{
                    if(this.vida<t2.vida){
                        gana1=false
                    }else{
                        azar = Random.nextInt(0,2)
                        if(azar==0){
                            gana1=true
                        }else{
                            gana1=false
                        }
                    }
                }

            }else{
                gana1=false
            }
        }

        return gana1
    }


    fun ganaFuerza(a:Arma):Int{
        return this.fuerza+a.potencia
    }

    fun ganaVida(m:Medicina):Int{
        return this.vida+m.potencia
    }


}