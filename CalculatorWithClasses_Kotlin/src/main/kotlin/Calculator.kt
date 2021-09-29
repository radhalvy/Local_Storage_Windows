class Calculator {
    private fun getFirstNumber(): Double? {
        print("Enter your first number: ")
        return readLine()!!.toDoubleOrNull()
    }
    private fun getSecondNumber(): Double? {
        print("Enter your second number: ")
        return readLine()!!.toDoubleOrNull()
    }
    private val firstNumber = getFirstNumber()
    private val secondNumber = getSecondNumber()


    private fun areNumbersValid(): Boolean {
        return ((firstNumber !== null) && (secondNumber !== null)) && ((firstNumber >= 0) && (secondNumber >= 0))
    }

    fun performAddition(): String {
        return if (areNumbersValid()) (firstNumber?.plus(secondNumber!!)).toString()
        else "One of the numbers entered is not valid. Try again with a different one."
    }

    fun performSubtraction(): String {
        return if (areNumbersValid()) (firstNumber?.minus(secondNumber!!)).toString()
        else "One of the numbers you entered is not valid. Try again with a different number. (Note: negative numbers are not valid.)"
    }

    fun performMultiplication(): String {
        return if (areNumbersValid()) (firstNumber?.times(secondNumber!!)).toString()
        else "One of the numbers you entered is not valid. Try again with a different number. (Note: negative numbers are not valid.)"
    }

    fun performDivision(): String {
        return if (areNumbersValid()) (firstNumber?.div(secondNumber!!)).toString()
        else "One of the numbers you entered is not valid. Try again with a different number. (Note: negative numbers are not valid.)"
    }


    private fun getPercentByNumber(): Double? {
        print("Enter percentage that you want to get: ")
        return readLine()!!.toDoubleOrNull()
    }
    private fun getPercentNumber(): Double? {
        print("Enter the number you want to know the percentage: ")
        return readLine()!!.toDoubleOrNull()
    }

    fun calculatePercentage(): String {
        val percentageByNumber = getPercentByNumber()
        val percentageNumber = getPercentNumber()
        return if (areNumbersValid()) ((percentageByNumber?.times(percentageNumber!!))?.div(100)).toString()
        else "One of the numbers you entered is not valid. Try again with a different number. (Note: negative numbers are not valid.)"
    }
}