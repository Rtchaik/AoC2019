package advent2019.day04

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val range = input.split("-").map { it.toInt() }
        val passwords = (range[0]..range[1]).filter { password ->
            val pairs = password.toString().zipWithNext()
            pairs.none { it.first > it.second } && pairs.any { it.first == it.second }
        }
        val part1 = passwords.size
        val part2 = passwords.filter { password ->
            password.toString().zipWithNext().groupBy { it }.any { it.key.first == it.key.second && it.value.size == 1 }
        }.size
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}