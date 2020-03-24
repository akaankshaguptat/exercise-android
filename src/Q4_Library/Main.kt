package Q4_Library

class Library:Book,Student(){
    override fun addBook() {
        println("add book")
    }

    override fun addStudent() {
        println("add student")
         }

    override fun deleteStudent() {
        println("delete student")
        }

    override fun modifyStudentDetails() {
        println("modify student details")
    }

    override fun deleteBook() {
        println("delete book")
        }

}
fun main(args:Array<String>){
    var library=Library()
    library.getBookDetails()
    library.addStudent()
    library.addBook()
    library.deleteBook()
    library.deleteStudent()
    library.modifyStudentDetails()
    library.getBookDetails()

}