class PessoaApply {

    var nome: String = ""
    var idade: Int = 0
}

fun main(){

    /*   Scope function 'APPLY'
   *    propriedade 1: referece ao contexto do objeto usando 'this'
   *    propriedade 2: o valor de retorno é 'contexto do objeto'
   * */

//    val pessoa = PessoaApply()        nesse trecho de codigo a a repetição da palavra pessoa
//    pessoa.nome = "Milton Pimentel"
//    pessoa.idade = 31

    val pessoa = PessoaApply().apply {
        nome = "Milton Pimentel"
        idade = 31
    }

    with(pessoa){
        println(nome)
        println(idade)
    }

    pessoa.also {
        it.nome = "joãozinho sei lá"
        println("O novo nome é: ${it.nome}")
    }
}