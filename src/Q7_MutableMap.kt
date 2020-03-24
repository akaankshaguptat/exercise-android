//Write a program to create mutable map. print all the value and key of map.

fun main(args:Array<String>){
    var mutableMap1: MutableMap<Int, String> = mutableMapOf<Int, String>()
    mutableMap1.put(1,"a")
    mutableMap1.put(2,"b")
    mutableMap1.put(3,"c")
    print(mutableMap1)
}