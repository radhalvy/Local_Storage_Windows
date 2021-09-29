const val ROCK = "rock"
const val PAPER = "paper"
const val SCISSORS = "scissors"

fun main() {
    val possibleHands = arrayOf(ROCK, PAPER, SCISSORS)
    println("IT'S TIME TO PLAY A GAME!")
    do {
        println("Rock, paper or scissors?")
        val userHand = readStringLower()
        val randomHand = possibleHands.random()

        if (userHand == randomHand) println("It's a tie.")
        else {
            if (userHand in possibleHands) {
                when (doesUserWins(userHand, randomHand)) {
                    true -> println("You win!")
                    false -> println("The computer wins!")
                }
            }
            else println("You entered a non valid hand. Try again.")
        }
    } while (userHand == randomHand)
}

private fun readStringLower(): String = readLine()!!.lowercase()

fun doesUserWins(userHand: String, randomHand: String): Boolean {
    return ((userHand == ROCK && randomHand == SCISSORS) || (userHand == PAPER && randomHand == ROCK)
            || (userHand == SCISSORS && randomHand == PAPER))
}