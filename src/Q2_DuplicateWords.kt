//Write a program to find the number of occurrences of the duplicate words in a string and print them

fun main(args: Array<String>) {
    print("enter sentence: ")
    var str1 = readLine()!!
    var words = str1.split(" ").toTypedArray()
    var count = 0
    for (i in 0 until words.size) {
        count = 1
        for (j in i + 1 until words.size) {
            if (words[i].equals(words[j])) {
                count++;
                words[j] = "#"
            }
        }
        if (count > 1 && (words[i] != "#")) {
            println(words[i] + ":" + count);
        }
    }

}