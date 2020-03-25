//WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
fun main(args:Array<String>){
    Class.forName("org.myPackage.Base")
}