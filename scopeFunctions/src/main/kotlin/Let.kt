class PessoaLet {
}

fun main() {

    /*   Scope function 'LET'
    *    propriedade 1: referece ao contexto do objeto usando 'it'
    *    propriedade 2: o valor de retorno é 'expressao lambda'
    * */

    // use função let para evitar nullPointerException
    val nome: String? = "Milton"

    val tamanhoNome = nome?.let {
        println(it.reversed())
        println(it.capitalize())
        it.length
    }

    println(tamanhoNome)
}