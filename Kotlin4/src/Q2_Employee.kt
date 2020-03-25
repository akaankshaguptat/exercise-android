fun main(args:Array<String>){
    var employee:MutableMap<String,Int> = mutableMapOf()
    employee.put("akaanksha",20)
    employee.put("abc",45)
    employee.put("sfs",66)
    employee.put("sty",77)
    val filtered = employee.filterValues{ it >30 }
    println(filtered)
}