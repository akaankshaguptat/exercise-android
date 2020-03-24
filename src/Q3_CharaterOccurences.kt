//Write a program to find the number of occurrences of a character in a string without using loop.
fun main(args: Array<String>) {
    print("enter string: ")
    var str1 = readLine()!!
    print("enter character:")
    var str2 = readLine()!!
    var count = str1.length - str1.replace(str2, "", ignoreCase = false).length;
    print(count)


}