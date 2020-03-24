//Check letter in string which do not have pair.
fun main(args: Array<String>) {
    println("enter string")
    var str = readLine()!!.toString()
    val charArray = str.toCharArray()

    for (i in 0 until str.length) {
        for (j in i + 1 until str.length) {
            if (charArray[i] == charArray[j]) {
                charArray[i] = '#'
                charArray[j] = '#'
            }
        }
    }
    for (i in 0 until charArray.size) {
        if (charArray[i] != '#') {
            println(charArray[i])
        }
    }

}