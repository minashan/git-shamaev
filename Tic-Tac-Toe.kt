const val ZERO = 0
const val ONE = 1
const val TWO = 2
const val THREE = 3
const val ONE_HUNDRED = 100
fun main() {
    var x: Int
    var y: Int
    var count = ONE
    val list = mutableListOf(
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' ')
    )

    fun gridPrinting() {
        println("---------")
        println("| ${list[ZERO].joinToString(" ")} |")
        println("| ${list[ONE].joinToString(" ")} |")
        println("| ${list[TWO].joinToString(" ")} |")
        println("---------")
    }
    gridPrinting()

    for (i in ONE..ONE_HUNDRED) {
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

        if (list[x - ONE][y - ONE] == ' ') {
            if (count % 2 != 0) {
                list[x - ONE][y - ONE] = 'X'
                gridPrinting()
                count++
            } else {
                list[x - ONE][y - ONE] = 'O'
                gridPrinting()
                count++
            }
        }

        val list2 = mutableListOf<Char>()
        list2.addAll(list[ZERO])
        list2.addAll(list[ONE])
        list2.addAll(list[TWO])
        var countWinX = ZERO
        var countWinO = ZERO
        var countX = ZERO
        var countO = ZERO
        var countSpace = ZERO

        for (i in list2) {
            when (i) {
                'X' -> countX++
                'O' -> countO++
                ' ' -> countSpace++
            }
        }
        for (i in list2) {
            if (list2[0] == 'X' && list2[1] == 'X' && list2[2] == 'X' ||
                list2[3] == 'X' && list2[4] == 'X' && list2[5] == 'X' ||
                list2[6] == 'X' && list2[7] == 'X' && list2[8] == 'X' ||
                list2[0] == 'X' && list2[3] == 'X' && list2[6] == 'X' ||
                list2[1] == 'X' && list2[4] == 'X' && list2[7] == 'X' ||
                list2[2] == 'X' && list2[5] == 'X' && list2[8] == 'X' ||
                list2[0] == 'X' && list2[4] == 'X' && list2[8] == 'X' ||
                list2[2] == 'X' && list2[4] == 'X' && list2[6] == 'X'
            ) {
                countWinX++
            }
            if (list2[0] == 'O' && list2[1] == 'O' && list2[2] == 'O' ||
                list2[3] == 'O' && list2[4] == 'O' && list2[5] == 'O' ||
                list2[6] == 'O' && list2[7] == 'O' && list2[8] == 'O' ||
                list2[0] == 'O' && list2[3] == 'O' && list2[6] == 'O' ||
                list2[1] == 'O' && list2[4] == 'O' && list2[7] == 'O' ||
                list2[2] == 'O' && list2[5] == 'O' && list2[8] == 'O' ||
                list2[0] == 'O' && list2[4] == 'O' && list2[8] == 'O' ||
                list2[2] == 'O' && list2[4] == 'O' && list2[6] == 'O'
            ) {
                countWinO++
            }
        }

        if (countWinX > countWinO) {
            println("X wins")
            break
        }
        if (countWinO > countWinX) {
            println("O wins")
            break
        }
        if (countWinO == ZERO && countWinX == ZERO && countSpace == ZERO) {
            println("Draw")
        }
    }
}


