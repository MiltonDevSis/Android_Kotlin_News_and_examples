class Also {
}

fun main() {

    /*   Scope function 'ALSO'             'ALSO PERFORM THE FOLLOWING THE EXTRA OPERATION'
    *    propriedade 1: referece ao contexto do objeto usando 'it'
    *    propriedade 2: o valor de retorno é 'contexto do objeto'
    * */

    val listaNumeros: MutableList<Int> = mutableListOf(1, 2, 3)

    // algum outro codigo pode ser uma chamada a uma função ou um programa para somar dois numeros.

    // operações em listaNumeros

    val listaDuplicada = listaNumeros.also {
        println("Os elementos da lista são $it")
        it.add(4)
        println("Depois de adicionar um elemento a lista fica: $it")
        it.remove(2)
        println("Depois de remover um elemento a lista fica: $it")
    }

    println("Lista original $listaNumeros")
    println("Lista duplicada $listaDuplicada")



}