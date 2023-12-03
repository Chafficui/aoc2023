package days

class Day1: Day {
    override fun part1(text: String): Any {
        val lines = text.split("\n")
        var sum = 0
        for (line in lines) {
            val (firstDigit, lastDigit) = getFirstAndLastDigits(line)
            val number = "$firstDigit$lastDigit".toInt()
            println("$firstDigit + $lastDigit = $number")
            sum += number
        }
        return sum
    }

    private fun getFirstAndLastDigits(text: String): Pair<Int, Int> {
        var firstDigit = Int.MIN_VALUE
        var lastDigit = Int.MIN_VALUE
        for (i in text.indices) {
            if (isDigit(text[i])) {
                if (firstDigit == Int.MIN_VALUE) firstDigit = text[i].digitToInt()
                lastDigit = text[i].digitToInt()
            }
        }
        return Pair(firstDigit, lastDigit)
    }

    private fun isDigit(char: Char): Boolean {
        return char in '0'..'9'
    }

    override fun part2(text: String): Any {
        TODO("Not yet implemented")
    }
}