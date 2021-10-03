import kotlin.random.Random

class Tablero {

    var F:Int = 5
    var C:Int = 5
    var tablero = Array(F){Array<Any?>(C){null} }

    constructor(tab:Array<Array<Any?>>,fil:Int,col:Int){
        this.F=fil
        this.C=col
        this.tablero=tab
    }

    fun rellenarTableroItem(tablero:Array<Array<Any?>>,capi:Capitolio,F:Int,C:Int){

        //distribuir 1 item

        var horizontal:Int = 0
        var vertical:Int = 0
        var posItem:Int = 0

        var ocupado:Boolean = true

        for(i in 0..F-1){
            for(j in 0..C-1){
                if(tablero[i][j]==null){
                    ocupado=false
                }
            }
        }

        if(!ocupado && capi.listaItems.size>0){
            do{
                horizontal= Random.nextInt(0,C)
                vertical= Random.nextInt(0,F)
            }while(tablero[horizontal][vertical] is Arma || tablero[horizontal][vertical] is Medicina || tablero[horizontal][vertical] is Trampa || tablero[horizontal][vertical] is Tributo)

            posItem= Random.nextInt(0,capi.listaItems.size-1)


            tablero[horizontal][vertical]=capi.listaItems.get(posItem)


            capi.listaItems.removeAt(posItem)
        }



    }

    fun rellenarTableroTributo(t:Tributo, tablero:Array<Array<Any?>>,F:Int,C:Int){

        //distribuir 1 Tributo

        var horizontal:Int
        var vertical:Int

        var ocupado:Boolean = true

        for(i in 0..F-1){
            for(j in 0..C-1){
                if(tablero[i][j]==null){
                    ocupado=false
                }
            }
        }

        if(ocupado==false){

            do{
                horizontal= Random.nextInt(0,C)
                vertical= Random.nextInt(0,F)
            }while(tablero[horizontal][vertical] is Arma || tablero[horizontal][vertical] is Medicina || tablero[horizontal][vertical] is Trampa || tablero[horizontal][vertical] is Tributo)

            tablero[horizontal][vertical] = t
        }

    }


    fun pintarTablero(tablero:Array<Array<Any?>>,F:Int,C:Int){
        println("")
        for(i in 0..F-1){
            for(j in 0..C-1){
                print(tablero[i][j].toString())
                print(" ")
            }

            println(" ")
        }
        println(" ")
    }



}