// Write a program to create mutable list of Integer. replace the second item in the list with new value. Print the list value.
fun main(args:Array<String>){
    val mutableListA = mutableListOf<Int>( 1 , 2 , 3 , 4 , 3)
    mutableListA[1]=7
    println(mutableListA)
}