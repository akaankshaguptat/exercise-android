//Write a program to create HasSet. print all the value.
fun main(args: Array<String>){
    var hashSet = HashSet<Int>(6)
    hashSet.add(2)
    hashSet.add(13)
    hashSet.add(6)
    hashSet.add(5)
    hashSet.add(2)
    hashSet.add(8)
    println("hash set values")
    for (i in hashSet){
        println(i)
    }
}