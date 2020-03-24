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