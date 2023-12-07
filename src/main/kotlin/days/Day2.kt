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
        TODO("Not yet implemented")
    }
}