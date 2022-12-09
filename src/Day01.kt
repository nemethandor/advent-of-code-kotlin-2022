// https://adventofcode.com/2022/day/1

fun main() {
    fun part1(input: List<String>): Int {
        var sum: Int = 0
        var elfCounter = 1
        val elfsCalories = mutableMapOf<Int, Int>()
        for (text in input) {
            if (text.isEmpty()) {
                elfsCalories.put(elfCounter, sum)
                elfCounter++
                sum = 0
            } else {
                sum += text.toInt()
            }
        }
        return elfsCalories.maxOf { (_, calories) -> calories }
    }

    fun part2(input: List<String>): Int {
        var sum: Int = 0
        var elfCounter = 1
        val elfsCalories = mutableMapOf<Int, Int>()
        for (text in input) {
            if (text.isEmpty()) {
                elfsCalories.put(elfCounter, sum)
                elfCounter++
                sum = 0
            } else {
                sum += text.toInt()
            }
        }
        return elfsCalories.toList().sortedByDescending { (_, calories) -> calories }.take(3).sumOf { it.second }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
