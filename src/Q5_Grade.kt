/*
5. Write a function which take marks as an argument and return the the grade as follows:
marks between 50 to 60 , return “Good”
marks between 60 to 70, return “Very Good”
marks between 70 to  80, return “Excellent”
marks between  80 to 100, return “Rockstar”

 */
fun grade(marks:Int):String{
    if(marks in 50..60){
        return "Good"
    }
    else if(marks in 61..70){
        return " Very Good"
    }
    else if (marks in 71..80){
        return "Excellent"
    }
    else{return "Rockstar"}
}

fun main(args:Array<String>){
    println("enter marks above 50")
    var marks= readLine()!!.toInt()
    var grading=grade(marks)
    println(grading)
}