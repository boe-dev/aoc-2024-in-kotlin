fun main() {
    fun part1(input: String): Int {
        var result = 0
        val regex = Regex("mul\\((\\d+),(\\d+)\\)")
        regex.findAll(input).forEach { matchResult ->
            val (num1, num2) = matchResult.destructured
            result += (num1.toInt() * num2.toInt())
        }
        return result
    }

    fun part2(input: String): Int {
        val regex = Regex("""don't\(\).*?do\(\)|(don't\(\).*)""")
        val shortString = input.replace(regex, "")
        return part1(shortString)
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day03_test.txt` file:
    val testInput = readInput("Day03_test").joinToString("")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03").joinToString("")
    part1(input).println()
    part2(input).println()
}
