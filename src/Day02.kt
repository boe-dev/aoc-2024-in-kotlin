fun main() {
    fun part1(input: List<String>): Int {
        val resultList = mutableListOf<Int>()
        input.map { it.split(" ") }.let { splitedList ->
            splitedList.forEach { line ->
                val zippedList = line.map { it.toInt() }.zipWithNext()
                val pos = zippedList.all {
                        (a,b) -> (a - b in 1..3)
                }

                val neg = zippedList.all {
                        (a,b) -> (a - b in -3..-1)
                }
                resultList.add(if (pos || neg) 1 else 0)
            }
        }
        return resultList.sum()
    }

    fun part2(input: List<String>): Int {
        val ret = input.map { it.split(" ") }.let { reports ->
            reports.count { report ->
                report.isDampendedReportSafe()
            }
        }

        return ret
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun isReportSafe(levels: List<String>): Boolean {
    val pairs = levels.map { it.toLong() }.zipWithNext()
    val pos = pairs.all { (a,b) ->
        (a - b in 1..3)
    }

    val neg = pairs.all { (a,b) ->
        (a - b in -3..-1)
    }
    return  (pos || neg)
}

fun List<String>.isDampendedReportSafe(): Boolean {
    return indices.any { indexToRemove ->
        val danoened = this.filterIndexed { index, _ -> index != indexToRemove }
        println(danoened)
        isReportSafe(danoened)
    }
}