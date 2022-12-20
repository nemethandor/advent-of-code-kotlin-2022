// https://adventofcode.com/2022/day/2

private val whoBeatsWho = mapOf("X" to "C", "Y" to "A", "Z" to "B")
private val pointsForTool = mapOf("X" to 1, "Y" to 2, "Z" to 3)
private val equivalentTools = mapOf("A" to "X", "B" to "Y", "C" to "Z")

fun main() {

    fun isWinner(opponentPlay: String, yourPlay: String): Boolean = opponentPlay == whoBeatsWho[yourPlay]

    fun isDraw(opponentPlay: String, yourPlay: String): Boolean = yourPlay == equivalentTools[opponentPlay]

    fun getGameResult(opponentPlay: String, yourPlay: String): Int = when {
        isWinner(opponentPlay, yourPlay) -> 6
        isDraw(opponentPlay, yourPlay) -> 3
        else -> 0
    }

    fun getTotalScore(input: String): Int {

        return input.lines().sumOf { game ->
            val plays = game.split(" ")
            val gameResult = getGameResult(plays[0], plays[1])
            val extraPoints = plays[1]?.let { pointsForTool[it] } ?: 0
            gameResult.plus(extraPoints)
        }
    }

    val testInput = readInputFile("Day02_test")
    val testResult = getTotalScore(testInput)
    println(testResult)
    check(testResult == 15)

    val input = readInputFile("Day02")
    val result = getTotalScore(input)
    println(result)

}