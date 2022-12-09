import java.io.File

// https://adventofcode.com/2022/day/1

fun main() {

    fun parseInput(input: String) = input.split("\r\n\r\n").map { elf ->
        elf.lines().sumOf { it.toInt() }
    }

    fun getNElvesCalories(input: String, n: Int) = parseInput(input)
        .sortedByDescending { it }
        .take(n)
        .sum()

    fun part1(input: String): Int = getNElvesCalories(input, 1)

    fun part2(input: String): Int = getNElvesCalories(input, 3)

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day01_test.txt").readText()
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = File("src/Day01.txt").readText()
    println(part1(input))
    println(part2(input))
}
