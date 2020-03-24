//Find common elements between two arrays.
import java.util.*

fun main(args: Array<String>) {
    println("enter length of first array")
    var l1: Int = readLine()!!.toInt()
    println("enter ellements of first array")
    var arrayint1 = Array<Int>(l1) { readLine()!!.toInt() }
    println("enter length of second array")
    var l2 = readLine()!!.toInt()
    println("enter ellements of second array")
    var arrayint2 = Array<Int>(l2) { readLine()!!.toInt() }

    println("common elements")
    val iArray = arrayint1.intersect(arrayint2.toList()).toIntArray()
    println(Arrays.toString(iArray))


}