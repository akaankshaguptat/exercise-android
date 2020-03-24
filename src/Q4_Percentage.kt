//Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String.
fun main(args: Array<String>) {
    print("enter string")
    var str = readLine()!!
    var lo = 0
    var up = 0
    var di = 0
    var sp = 0
    for (i in 0 until str.length) {
        if (str[i].isLowerCase())
            lo++
        else if (str[i].isUpperCase())
            up++
        else if (str[i].isDigit())
            di++
        else
            sp++
    }
    var len = str.length.toFloat();

    var lo1 = (lo / len) * 100;
    var up1 = (up / len) * 100;
    var di1 = (di / len) * 100;
    var sp1 = (sp / len) * 100;
    println("lower case percentage " + lo1);
    println("upper case percentage " + up1);
    println("digit percentage " + di1);
    println("special char percentage " + sp1);

}