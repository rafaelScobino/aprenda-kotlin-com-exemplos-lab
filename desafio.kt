enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
var contNivel:String = ""

class Usuario(val matricula:Int, val nome:String )

fun setDuration(nivel:String):Int{
    return when(nivel){
            "BASICO" -> 35 
            "INTERMEDIARIO" -> 50
            "AVANCADO" ->  120
        	else -> 0}}

data class ConteudoEducacional(val nome: String, var nivel:String, var duracao: Int = 60)
var formacoes = mutableListOf<Formacao>()

	fun printForms(formacao:Formacao?=null){
        if(formacao == null){
            for(form in formacoes){
                println(form.name)
                	for(cont in form.conteudos){
				println(cont)}
                    for(i in form.inscritos){
                        println("${i.matricula}: ${i.nome}")
                    }
            }
        }else{
            println(formacao.name)
            for(cont in formacao.conteudos){
				println(cont)}
            for(i in formacao.inscritos){
				println("${i.matricula}: ${i.nome}")}
        }
    }
    
    fun addForms(formacao: Formacao){
        formacoes.add(formacao)}
    
    fun remForms(){
        formacoes.removeAt(formacoes.lastIndex )}
    
data class Formacao(val name: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)}}

fun main() {
    contNivel = Nivel.BASICO.toString()
    	var contB1 = ConteudoEducacional("HTML",contNivel,setDuration(contNivel))
    contNivel = Nivel.INTERMEDIARIO.toString()
    	var contI1 = ConteudoEducacional("JavaScript",contNivel,setDuration(contNivel))
        var contI2 = ConteudoEducacional("CSS",contNivel,setDuration(contNivel))
    var form1Conts = listOf(contB1,contI1,contI2)
	var form1 = Formacao("Front-End",form1Conts)
    	addForms(form1)
    var user1 = Usuario(123546,"Rafael")
    	form1.matricular(user1)
        
	contNivel = Nivel.BASICO.toString()
    	var contBb1 = ConteudoEducacional("Angular",contNivel,setDuration(contNivel))
    contNivel = Nivel.INTERMEDIARIO.toString()
    	var contIi1 = ConteudoEducacional("TypeScript",contNivel,setDuration(contNivel))
        var contIi2 = ConteudoEducacional("CSS",contNivel,setDuration(contNivel))
    var form2Conts = listOf(contBb1,contIi1,contIi2)
	var form2 = Formacao("Angular",form2Conts)
    	addForms(form2)
    var user2 = Usuario(12234,"Pedro")
    	form2.matricular(user1)
        form2.matricular(user2)
        
	printForms(form2)
        
}
