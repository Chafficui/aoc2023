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
        val cards = text.lineSequence().toMutableList()
        var cardId = 0
        var num = 0
        while (cardId < cards.size) {
            var cardScore = 0
            val card = cards[cardId].replace("Card *[0-9]*: ".toRegex(), "")
            val cardNumber = extractCardNumbers(cards[cardId])
            val numbers = card.split(" | ")
            val winnerNumbers = numbers[0].split(" ").filter { it.isNotEmpty() }
            val elveNumbers = numbers[1].split(" ").filter { it.isNotEmpty() }

            for (number in winnerNumbers) {
                if (elveNumbers.contains(number))
                    cardScore++
            }
            num += cardScore
            if (cardScore > 0) {
                for (i in 0..<cardScore) {
                    cards.add(cards[cardNumber + i])
                }
            }
            cardId++
        }

        println(num)
        return cards.size
    }

    fun extractCardNumbers(card: String): Int {
        return card.split(":")[0].replace("Card *".toRegex(), "").toInt()
    }
}