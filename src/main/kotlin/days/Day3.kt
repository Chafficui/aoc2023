package days

class Day3: Day {
    override fun part1(text: String, vararg args: Any): Any {
        val lines = text.lineSequence().toList()
        var sum = 0

        for ((i, line) in lines.withIndex()) {
            var j = 0
            while (j < line.length) {
                if (line[j].isDigit()) {
                    val wholeNumberResult = wholeNumber(lines, i, j)
                    val partNumber = wholeNumberResult.number
                    val lastIndex = wholeNumberResult.lastIndex
                    if (hasAdjacentSymbol(lines, i, j, lastIndex)) {
                        sum += partNumber
                    }
                    j = lastIndex
                }
                j++
            }
        }

        return sum
    }

    private fun hasAdjacentSymbol(lines: List<String>, i: Int, start: Int, end: Int): Boolean {
        val deltas = listOf(-1, 0, 1)
        for (x in start..end) {
            for (dx in deltas) {
                for (dy in deltas) {
                    val nx = i + dx
                    val ny = x + dy
                    if ((dx != 0 || dy != 0) && nx in lines.indices && ny in lines[nx].indices)
                        if (lines[nx][ny] != '.' && !lines[nx][ny].isDigit()) {
                            return true
                        }
                }
            }
        }
        return false
    }

    private fun wholeNumber(lines: List<String>, i: Int, j: Int): WholeNumberResult {
        var right = j
        while (right < lines[i].length - 1 && lines[i][right + 1].isDigit()) {
            right++
        }
        val number = lines[i].substring(j, right + 1).toInt()
        return WholeNumberResult(number, right)
    }

    data class WholeNumberResult(val number: Int, val lastIndex: Int)

    override fun part2(text: String, vararg args: Any): Any {
        TODO("Not yet implemented")
    }
}