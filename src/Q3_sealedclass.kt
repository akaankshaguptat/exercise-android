//WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have base class object as an argument and it will return name of the subclass based argument type.
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