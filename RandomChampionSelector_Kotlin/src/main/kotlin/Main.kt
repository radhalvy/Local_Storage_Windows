const val TOP = 1
const val MID = 2
const val ADC = 3
const val SUPPORT = 4

fun main() {
    println("1) Top, 2) Mid, 3) ADC, 4) Support")
    print("Choose your desired position: ")
    val userSelectedRole = try { readLine()!!.toInt() }
                           catch (e: NumberFormatException) { println("Option not found.")
                                                              return }
    when (userSelectedRole) {
        TOP -> println(getTop())
        MID -> println(getMid())
        ADC -> println(getADC())
        SUPPORT -> println(getSupport())
        else -> println("Option not found.")
    }
}

fun getSupport(): String {
    val champions = arrayOf("Lux", "Karma", "Lulu", "Janna", "Neeko", "Nami", "Morgana", "Soraka", "Zyra")
    return champions.random()
}

fun getTop(): String {
    val champions = arrayOf("Shen", "Darius", "Mundo", "Fiora", "Garen", "Gwen", "Illaoi", "Malphite", "Ornn", "Sion", "Yorick")
    return champions.random()
}

fun getADC(): String {
    val champions = arrayOf("Ezreal", "Miss Fortune")
    return champions.random()
}

fun getMid(): String {
    val champions = arrayOf("Talon", "Qiyana", "Ryze", "Neeko", "Morgana", "Lux", "Karma", "Akali", "Ezreal", "Ekko")
    return champions.random()
}
