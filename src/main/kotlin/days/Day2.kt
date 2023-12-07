package days

class Day2 : Day {
    override fun part1(text: String, vararg args: Any): Any {
        val lines = text.split("\n")
        var sum = 0
        for (game in lines) {
            val sets = game.replace("Game [0-9]*:".toRegex(), "").split(";")
            var gameIsImpossible = false
            for (set in sets) {
                val parts = set.split(",")
                for (part in parts) {
                    gameIsImpossible = getAmount("red", part) > args[0] as Int ||
                            getAmount("green", part) > args[1] as Int ||
                            getAmount("blue", part) > args[2] as Int
                    if (gameIsImpossible) break
                }
                if (gameIsImpossible) break
            }
            if (!gameIsImpossible) sum += game.split(":")[0].split(" ")[1].toInt()
        }
        return sum
    }

    private fun getAmount(color: String, inString: String): Int {
        if (!inString.contains(color)) return 0
        return inString.split(" ")[1].toInt()
    }

    override fun part2(text: String, vararg args: Any): Any {
        val lines = text.split("\n")
        var sum = 0
        for (game in lines) {
            val sets = game.replace("Game [0-9]*:".toRegex(), "").split(";")
            val maxBalls = intArrayOf(0, 0, 0)
            for (set in sets) {
                val parts = set.split(",")
                for (part in parts) {
                    maxBalls[0] = if(maxBalls[0] > getAmount("red", part)) maxBalls[0] else getAmount("red", part)
                    maxBalls[1] = if(maxBalls[1] > getAmount("green", part)) maxBalls[1] else getAmount("green", part)
                    maxBalls[2] = if(maxBalls[2] > getAmount("blue", part)) maxBalls[2] else getAmount("blue", part)
                }
            }
            sum += maxBalls[0] * maxBalls[1] * maxBalls[2]
        }
        return sum
    }
}