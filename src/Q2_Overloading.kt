fun main(args:Array<String>){
    add(1,2)
    add(100.5,100.5)
    multiply(1,2)
    concate("a","b")
    concate("a","b","c")
}
fun add(num1:Int,num2:Int){
    println(num1+num2)
}
fun add(num1:Double,num2:Double){
    println(num1+num2)
}
fun multiply(num1:Int,num2:Int){
    println(num1*num2)
}
fun concate(s1:String,s2:String){
    println(s1+s2)
}
fun concate(s1:String,s2:String,s3:String){
    println(s1+s2+s3)
}