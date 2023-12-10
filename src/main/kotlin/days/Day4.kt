package days

class Day4: Day {
    override fun part1(text: String, vararg args: Any): Any {
        val cards = text.replace("Card *[0-9]*: ".toRegex(), "").lineSequence().toList()
        var score = 0
        for (card in cards) {
            var cardScore = 0
            val numbers = card.split(" | ")
            val winnerNumbers = numbers[0].split(" ").filter { it.isNotEmpty() }
            val elveNumbers = numbers[1].split(" ").filter { it.isNotEmpty() }

            for (number in winnerNumbers) {
                if (elveNumbers.contains(number)) {
                    cardScore *= 2
                    if (cardScore == 0) cardScore = 1
                }
            }
            score += cardScore
        }

        return score
    }

    override fun part2(text: String, vararg args: Any): Any {
        TODO("Not yet implemented")
    }
}