import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {

        val test = input.map {
            it.split("   ")
        }.let { splitedList ->
            val left = splitedList.map { it[0].toInt() }.sorted()
            val right = splitedList.map { it[1].toInt() }.sorted()
            left.zip(right) { a, b -> abs(a - b)}.sum()
        }

        println(test)

        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        input.forEach {
            val split = it.split("   ")
            left.add(split[0].toInt())
            right.add(split[1].toInt())
        }

        left.sort()
        right.sort()

        val distanceList = left.zip(right) { a, b -> abs(a - b)}
        return distanceList.sum()
    }

    fun part2(input: List<String>): Int {

        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        input.forEach {
            val split = it.split("   ")
            list1.add(split[0].toInt())
            list2.add(split[1].toInt())
        }

        val calculatedList = mutableListOf<Int>()
        list1.forEach { location ->
            val amount = list2.count { it == location }
            calculatedList.add(location * amount)
        }

        return calculatedList.sum()
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
