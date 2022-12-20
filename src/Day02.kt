// https://adventofcode.com/2022/day/2

private val whoBeatsWho = mapOf("A" to "C", "B" to "A", "C" to "B")
private val pointsForTool = mapOf("X" to 1, "Y" to 2, "Z" to 3)
private val equivalentTools = mapOf("A" to "X", "B" to "Y", "C" to "Z")

fun main() {

    fun getGameResult(tactic: String): Int = when (tactic) {
        "Z" -> 6
        "Y" -> 3
        else -> 0
    }

    fun findYourTool(opponentPlay: String, tactic: String): String? {
        val looser = whoBeatsWho[opponentPlay]
        val winner = whoBeatsWho[looser]
        val tactic = when (tactic) {
            "Y" -> opponentPlay
            "X" -> looser
            else -> winner
        }
        return equivalentTools[tactic]
    }

    fun getTotalScore(input: String): Int {

        return input.lines().sumOf { game ->
            val plays = game.split(" ")
            val gameResult = getGameResult(plays[1])
            val extraPoints = findYourTool(plays[0], plays[1])?.let { pointsForTool[it] } ?: 0
            gameResult.plus(extraPoints)
        }
    }

    val testInput = readInputFile("Day02_test")
    val testResult = getTotalScore(testInput)
    println(testResult)
    check(testResult == 12)

    val input = readInputFile("Day02")
    val result = getTotalScore(input)
    println(result)

}