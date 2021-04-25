class PessoaWith{

    var nome: String = "Milton"
    var idade: Int = 31

}

fun main() {

    /*   Scope function 'WITH'
    *    propriedade 1: referece ao contexto do objeto usando 'this'
    *    propriedade 2: o valor de retorno é 'resultado lambda'
    * */

    val pessoa = PessoaWith()

    println("--- exemplo ruim ---") // a palavra pessoa repete muitas vezes.
    println(pessoa.nome)
    println(pessoa.idade)


    println("\n--- Exemplo 1 ---")
    with(pessoa){
        println(nome)
        println(idade)
    }

    println("\n--- Exemplo 2 ---")
    val idadeDepoisDe5Anos: Int = with(pessoa){
        println(nome)
        println(idade)
        idade + 5
    }

    println("A idade depois de 5 anos é de: $idadeDepoisDe5Anos anos")

    println("\n--- Exemplo 3 ---")
    val bio: String = with(pessoa){
        println(nome)
        println(idade)
        idade + 5
        "Essa pessoa ama tecnologia!"
    }

    println(bio)
}