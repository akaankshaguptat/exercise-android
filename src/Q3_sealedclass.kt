sealed class A{
    class B:A(){}
    class C:A(){}
    class D:A(){}
}
fun display(a:A){
    when(a){
        is A.B-> println("class B")
        is A.C-> println("class C")
        is A.D-> println("class D")
    }
}
fun main(args:Array<String>){
    val b=A.B()
    val c=A.C()
    val d=A.D()
    display(b)
    display(c)
    display(d)

}