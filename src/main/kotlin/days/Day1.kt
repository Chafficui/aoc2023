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
        val lines = text.split("\n")
        var sum = 0
        for (line in lines) {
            val (firstDigit, lastDigit) = getFirstAndLastDigits2(line)
            val number = "$firstDigit$lastDigit".toInt()
            println("$firstDigit + $lastDigit = $number")
            sum += number
        }
        return sum
    }

    private val numbers = mapOf(
        "one" to "o1e",
        "two" to "t2o",
        "three" to "t3e",
        "four" to "4",
        "five" to "5e",
        "six" to "6",
        "seven" to "7n",
        "eight" to "e8t",
        "nine" to "n9e",
    )

    private fun getFirstAndLastDigits2(text: String): Pair<Int, Int> {
        val foldedLine = numbers.entries.fold(text) { acc, entry ->
            acc.replace(entry.key, entry.value)
        }
        println(foldedLine)
        return getFirstAndLastDigits(foldedLine)
    }
}