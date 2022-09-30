class Person(val firstName: String = "Peter", val lastName: String = "Parker") {
    // public (by default) , internal , private (only available in same doc) , protected
    // val firstName: String = _firstName
    // val lastName: String = _lastName

   var nickName: String? = null
        set(value) {
            field = value
            println("The new nickname is $value")
        }
        get() {
            println("The returned value is $field")
            return field
        }

        fun printInfo(){
            val nickNameToPrint = nickName ?: "no nickname"
            println("$firstName ($nickNameToPrint) $lastName")
        }
}