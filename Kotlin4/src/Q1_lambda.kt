//WAP using Lambda function to calculate the Simple Interest.
fun main(args:Array<String>){
    var simpleInterest={p:Double,t:Double,r:Double->(p*t*r)/100}
    var result=simpleInterest(100.4,2.4,5.6)
    print(result)
}