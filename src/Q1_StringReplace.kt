//Write a program to replace a substring inside a string with another string.

fun main(args: Array<String>) {
    print("enter string 1:")
    var str1 = readLine()!!
    print("enter old substring:")
    var oldstr = readLine()!!
    print("enter new substring:")
    var newstr = readLine()!!
    print("replaced string is: ")
    var output = str1.replace(oldstr, newstr, ignoreCase = false)
    print(output)

}