class Capitolio {

    var listaItems:ArrayList<Item> = ArrayList<Item>(100)
    var listaMuertos:ArrayList<Tributo> = ArrayList<Tributo>(0)


    constructor(){

    }

    fun llenarItem(it:Item){
        this.listaItems.add(it)
    }

    fun recogerMuerto(t:Tributo){
        this.listaMuertos.add(t)
    }

}