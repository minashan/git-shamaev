const val ZERO = 0
const val ONE = 1
const val TWO = 2
const val THREE = 3
const val FOUR = 4
const val FIVE = 5
const val SIX = 6
const val SEVEN = 7
const val EIGHT = 8
const val TEN = 10
fun main() {
    val str = readLine()!!.toCharArray()
    var x: Int
    var y: Int
    val list = mutableListOf(
        mutableListOf<Char>(str[ZERO], str[ONE], str[TWO]),
        mutableListOf<Char>(str[THREE], str[FOUR], str[FIVE]),
        mutableListOf<Char>(str[SIX], str[SEVEN], str[EIGHT])
    )

    fun gridPrinting() {
        println("---------")
        println("| ${list[ZERO].joinToString(" ")} |")
        println("| ${list[ONE].joinToString(" ")} |")
        println("| ${list[TWO].joinToString(" ")} |")
        println("---------")
    }
    gridPrinting()

    for (i in ZERO..TEN) {
        print("Enter the coordinates: ")
        var coordinates = readLine()!!.toCharArray()
        if (!coordinates[ZERO].isDigit() || !coordinates[TWO].isDigit()) {
            println("You should enter numbers!")
            continue
        }
        coordinates.toString()
        x = coordinates[ZERO].toString().toInt()
        y = coordinates[TWO].toString().toInt()

        if (x > THREE || y > THREE) {
            println("Coordinates should be from 1 to 3!")
            continue
        }

        if (list[x - ONE][y - ONE] == 'X' || list[x - ONE][y - ONE] == 'O') {
            println("This cell is occupied! Choose another one!")
            continue
        }

        if (list[x - ONE][y - ONE] == '_') {
            list[x - ONE][y - ONE] = 'X'
            gridPrinting()
            break
        }
    }
}

//    var countWinX = ZERO
//    var countWinO = ZERO
//    var countX = ZERO
//    var countO = ZERO
//    var countSpace = ZERO
//    var diff = ZERO
//
//    for (i in list) {
//        when (i) {
//            'X' -> {
//                countX++
//            }
//            'O' -> {
//                countO++
//            }
//            '_' -> {
//                countSpace++
//            }
//        }
//    }
//
//    if (countX > countO) {
//        diff = countX - countO
//    } else if (countO > countX) {
//        diff = countO - countX
//    }
//
//    for (i in list) {
//        if (list[0] == 'X' && list[1] == 'X' && list[2] == 'X' ||
//            list[3] == 'X' && list[4] == 'X' && list[5] == 'X' ||
//            list[6] == 'X' && list[7] == 'X' && list[8] == 'X' ||
//            list[0] == 'X' && list[3] == 'X' && list[6] == 'X' ||
//            list[1] == 'X' && list[4] == 'X' && list[7] == 'X' ||
//            list[2] == 'X' && list[5] == 'X' && list[8] == 'X' ||
//            list[0] == 'X' && list[4] == 'X' && list[8] == 'X' ||
//            list[2] == 'X' && list[4] == 'X' && list[6] == 'X'
//        ) {
//            countWinX++
//        }
//        if (list[0] == 'O' && list[1] == 'O' && list[2] == 'O' ||
//            list[3] == 'O' && list[4] == 'O' && list[5] == 'O' ||
//            list[6] == 'O' && list[7] == 'O' && list[8] == 'O' ||
//            list[0] == 'O' && list[3] == 'O' && list[6] == 'O' ||
//            list[1] == 'O' && list[4] == 'O' && list[7] == 'O' ||
//            list[2] == 'O' && list[5] == 'O' && list[8] == 'O' ||
//            list[0] == 'O' && list[4] == 'O' && list[8] == 'O' ||
//            list[2] == 'O' && list[4] == 'O' && list[6] == 'O'
//        ) {
//            countWinO++
//        }
//    }
//
//    if (diff >= TWO || countWinX + countWinO == 18) {
//        println("Impossible")
//    }
//    if (countWinX > countWinO) {
//        println("X wins")
//    }
//    if (countWinO > countWinX) {
//        println("O wins")
//    }
//    if (countWinO == ZERO && countWinX == ZERO && countSpace == ZERO) {
//        println("Draw")
//    }
//    if (diff < TWO && countWinO + countWinX == ZERO && countSpace > ZERO) {
//        println("Game not finished")
//    }
//}


