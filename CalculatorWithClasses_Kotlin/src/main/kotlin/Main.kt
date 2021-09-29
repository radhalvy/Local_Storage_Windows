const val ADDITION = 1
const val SUBTRACTION = 2
const val MULTIPLICATION = 3
const val DIVISION = 4
const val PERCENTAGE = 5

fun main() {
    println("1) Addition, 2) Subtraction, 3) Multiplication, 4) Division, 5) Percentage")
    val selectedOperation = try {readLine()!!.toInt()} catch (e: NumberFormatException) {
        println("Operation not found.")
        return
    }
    when (selectedOperation) {
        ADDITION -> println(Calculator().performAddition())
        SUBTRACTION -> println(Calculator().performSubtraction())
        MULTIPLICATION -> println(Calculator().performMultiplication())
        DIVISION -> println(Calculator().performDivision())
        PERCENTAGE -> println(Calculator().calculatePercentage())
        else -> println("Operation not found.")
    }
}