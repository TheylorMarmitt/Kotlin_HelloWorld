package ReadCSV.Functions

import ReadCSV.Model.Cancelamento
import ReadCSV.Model.CancelamentoMotivo

fun contandoCancelamentosMotivo(lista: ArrayList<Cancelamento>){

    var cancelamentoPorMotivo = ArrayList<CancelamentoMotivo>()
    val filtrada = lista.distinctBy { it.motivo }

    filtrada.forEach {
        val motivo = it.motivo
        var count = 0
        lista.forEach{
            if (it.motivo == motivo){
                count += 1
            }
        }
        cancelamentoPorMotivo.add(CancelamentoMotivo(total = count, motivo = motivo))
    }

    val nova = cancelamentoPorMotivo.sortedByDescending { it.total }
    nova.forEach {
        print(it.total)
        print(" - ")
        println(it.motivo)
    }

}