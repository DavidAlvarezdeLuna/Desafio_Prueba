import kotlin.random.Random

fun main(){

    var capi:Capitolio = Capitolio()

    //Preparar items del capitolio
    for(i in 0..99){
        var itemAzar:Int = Random.nextInt(0,3) //0:Arma, 1:Medicina, 2:Trampa
        var potencia:Int = Random.nextInt(50,101)

        when(itemAzar){
            0 -> {
                //var a:Arma = Arma("Objeto que hace daño",potencia)
                var a = Factoria.generarArma("Objeto que hace daño",potencia)
                capi.llenarItem(a)
            }
            1 -> {
                //var m:Medicina = Medicina("Objeto que cura",potencia)
                var m = Factoria.generarMedicina("Objeto que cura",potencia)
                capi.llenarItem(m)
            }
            2 -> {
                //var tr:Trampa = Trampa("Pisarla es morir")
                var tr = Factoria.generarTrampa("Objeto que hace daño")
                capi.llenarItem(tr)
            }
        }
    }

    //Preparar tablero
    val F:Int = 5
    val C:Int = 5
    var tab = Array(F){Array<Any?>(C){null} }

    var tablero:Tablero = Tablero(tab,F,C)


    //llenar tablero con 10 items
    for(i in 0..9){
        tablero.rellenarTableroItem(tab,capi,F,C)
    }

    //Generar y colocar los 10 tributos en el tablero
    var vidaAzar:Int
    var fuerzaAzar:Int

    for(i in 1..5){ //Los tributos pertenecen a los distritos 1, 2, 3, 4 y 5
        for(j in 0..1){
            vidaAzar = Random.nextInt(5,11)
            fuerzaAzar = Random.nextInt(5,11)
            var t:Tributo = Factoria.generarTributo(i,vidaAzar,fuerzaAzar)
            tablero.rellenarTableroTributo(t,tab,F,C)
        }
    }

    println("Tablero preparado")
    tablero.pintarTablero(tab,F,C)

    println("COMIENZAN LOS JUEGOS DEL HAMBRE!!")

    var minuto:Int = 0
    var muertos:Int = 0

    do{
        println("Minuto "+minuto)
        if(minuto%2==0){

            for(i in 0..F-1){
                for(j in 0..C-1){
                    if(tablero.tablero[i][j] is Tributo){

                        if(capi.listaMuertos.size!=9){ //evitamos que el ultimo superviviente muera al caer en una trampa
                            (tablero.tablero[i][j] as Tributo).desplazamiento(tab,i,j,capi)
                        }
                    }
                }
            }
            println("Muertos: "+capi.listaMuertos.size)
        }

        if(minuto%5==0){
            println("El capitolio libera cuatro objetos nuevos")
            for(i in 0..3){
                tablero.rellenarTableroItem(tab,capi,F,C)
            }
            tablero.pintarTablero(tab,F,C)
        }

        minuto++

        Thread.sleep(500)

    }while(capi.listaMuertos.size<9)


    println("FINAL DEL JUEGOOOO!!")

    tablero.pintarTablero(tab,F,C)

    for(i in 0..F-1){
        for(j in 0..C-1){
            if(tablero.tablero[i][j] is Tributo){
                println("GANADOR: LUCHADOR DEL DISTRITO "+(tab[i][j] as Tributo).distrito+", CON VIDA "+(tab[i][j] as Tributo).vida+" Y FUERZA "+(tab[i][j] as Tributo).fuerza)
            }
        }
    }



}