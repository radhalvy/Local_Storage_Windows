import java.io.File

const val LOGIN = 1
const val CREATE_NEW_ACCOUNT = 2
const val DEPOSIT = 1
const val WITHDRAWAL = 2
const val GET_BALANCE = 3
const val HISTORY = 4

fun main() {
    println("1) Log in, 2) Create a new account")
    val loginOrCreateOperation = try {readLine()!!.toInt()} catch (e: NumberFormatException) {null}
    when (loginOrCreateOperation) {

        LOGIN -> {
            print("Enter your account: ")
                                                                        // Changes whitespaces to underscores
            val filePath = "src/main/textFiles/${readStringLower()}.txt".replace("\\s".toRegex(), "_")

            if (doesExist(filePath)) {
                println("1) Make a deposit, 2) Make a withdrawal, 3) Check account's total balance, 4) See account's history")
                val bankingOperation = try {readLine()!!.toInt()} catch (e: NumberFormatException) {null}

                when (bankingOperation) {

                    DEPOSIT -> {
                        try { makeDeposit(filePath) }
                        catch (e: NumberFormatException) { println("Amount must be a number.") }
                    }

                    WITHDRAWAL -> {
                        try { makeWithdrawal(filePath) }
                        catch (e: NumberFormatException) { println("Amount must be a number.") }
                    }

                    GET_BALANCE -> println("$%,d".format(getBalance(filePath)))

                    HISTORY -> println(getHistory(filePath))

                    else -> println("Invalid option. Try again.")
                }
            }
            else {
                println("This account doesn't exist. Do you want to create it?")
                val doContinue = readStringLower()

                if (doContinue == "yes" || doContinue == "y") createFile(filePath)
                else println("All right. Closing program...")
            }
        }

        CREATE_NEW_ACCOUNT -> {
            print("Enter the name of your future account: ")
                                                                        // Changes whitespaces to underscores
            val newAccount = "src/main/textFiles/${readStringLower()}.txt".replace("\\s".toRegex(), "_")
            createFile(newAccount)
        }

        else -> println("Invalid option. Try again.")
    }
}

fun createFile(filePath: String) {
    val file = File(filePath)
    file.createNewFile()
    println("Account created.")
}

fun makeDeposit(filePath: String) {
    print("Amount to deposit: ")
    val amount = readLine()!!.toLong()
    val file = File(filePath)
    if (amount > 0) {
        print("Enter a note for this transaction: ")
        file.appendText("+ $amount >>>> ${readLine()}\n")
    }
    else println("Amount cannot be zero nor negative.")
}

fun makeWithdrawal(filePath: String) {
    print("Amount to withdraw: ")
    val amount = readLine()!!.toLong()
    val accountBalance = getBalance(filePath)
    val file = File(filePath)
    if (amount <= 0) println("Amount cannot be zero nor negative.")
    else if (amount > accountBalance) println("There's not enough money in the account to complete the withdrawal.")
    else {
        print("Enter a note for this transaction: ")
        file.appendText("- $amount >>>> ${readLine()}\n")
    }
}

fun getBalance(filePath: String): Long {
    val file = File(filePath)
    val upAmounts: MutableList<Long> = mutableListOf()
    val downAmounts: MutableList<Long> = mutableListOf()
    file.forEachLine {
        // Checks if it's a deposit or a withdrawal,
        // makes a slice of the amount and adds it to the corresponding list
        if (it[0] == '+') upAmounts.add(it.slice(2..it.indexOf(">") - 2).toLong())
        else downAmounts.add(it.slice(2..it.indexOf(">") - 2).toLong())
    }
    return upAmounts.sum() - downAmounts.sum()
}

fun getHistory(filePath: String): String {
    val file = File(filePath)
    return file.readText()
}

fun doesExist(name: String): Boolean {
    val file = File(name)
    return file.exists()
}

private fun readStringLower(): String = readLine()!!.lowercase()