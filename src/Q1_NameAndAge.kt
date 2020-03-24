
class Q1_NameAndAge {

    init{
        var firstName="Akaanksha"
        println("First name: $firstName")
        var lastName="Gupta"
        println("Last name: $lastName")
    }
    companion object{
        fun printAge() = println("20")
    }
}
fun main(args:Array<String>){
 var obj=Q1_NameAndAge()
 print(Q1_NameAndAge.printAge())
}
