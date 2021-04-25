class PessoaRun {

    var nome: String = "Milton"
    var idade: Int = 31
}

fun main(){

    /*   Scope function 'RUN'
    *    propriedade 1: referece ao contexto do objeto usando 'this'
    *    propriedade 2: o valor de retorno é 'expressao lambda'
    *
    *    Run é uma combinação de 'WITH' e 'LET'
    *
    *  se vc quer fazer uma operação com um objeto nulo e evitar nullPointerException então use 'RUN'
    * */

    val pessoa: PessoaRun? = PessoaRun()

    val bio = pessoa?.run {
        println(nome)
        println(idade)
        idade + 5
        "Essa pessoa é apaixonada por tecnologia!"
    }

    println(bio)

}