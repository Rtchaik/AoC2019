package advent2019.day01

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val part1 = input.map { it.toInt() / 3 - 2 }
        val part2 = part1.map { moduleFuel(it) }.sum()
        println("Part 1: ${part1.sum()}\nPart 2: $part2")

        val part2V2 = part1.map { item -> generateSequence(item) { x -> (x / 3 - 2).takeIf { it > 0 } }.sum() }.sum()
        println("Part 2V2: $part2V2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun moduleFuel(current: Int, total: Int = 0): Int =
    if (current <= 0) total else moduleFuel(current / 3 - 2, total + current)