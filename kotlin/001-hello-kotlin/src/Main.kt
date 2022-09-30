val name: String = "Labamba " // top level variables
var greeting: String? = null;

fun getGreeting(param: String, param2: Int): String {
    return "Hello $param you are number $param2";
}

fun singleReturn(): String = "Hello, this is the single expression function" // single expression function

fun toimiiko(param: Int) = "First param is $param";

val interestingThings = arrayOf("Programming", "Music", "Workout", "Something", "Magic");

fun main() {
    var mood: String? = "Fantastic ";
    println(mood + greeting + name);

    greeting = "dobry";

    when(greeting) {
        null -> println("Hi");
        "dobry" -> println("Dzien Dobry");
        else -> println("Heeellooo");
    }

    val realName = if(name == "Labamba") name else "Not the real name";
    println(realName)

    println(getGreeting(param = "Johny", param2 = 5))
    println(singleReturn());
    println(toimiiko(param = 123));

    /* for (thing in interestingThings) {
        val firstChar: String = thing[0].toString()
        if (firstChar == "M") {
            println(thing)
        } else {
            println("classified")
        }

    }
     */

    // interestingThings.forEach {thing ->
    //    println(thing)
    // }

    interestingThings.forEachIndexed { index, it ->
        println("$it is at index $index")
    }

    // MUTABLE list of ETC!

    val map = mapOf(1 to "a", 2 to "b", 3 to "c") // key to value
    map.forEach { (key, value) -> println("$key -> $value") }

    fun sayHello(greet:String, vararg itemsToGreet:String){
        for (thing in itemsToGreet) {
            println("$greet $thing")
        }
    }

    sayHello("HELLO! ", *interestingThings)

    fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")

    greetPerson(name = "Baracuda")

}