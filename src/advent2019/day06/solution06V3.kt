package advent2019.day06

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val orbitsMap = input.map { it.split(")") }.associate { it[1] to it[0] }
        val stars = orbitsMap.mapValues { entry -> generateSequence(entry.key) { orbitsMap[it] }.drop(1).toList() }
        val part1 = stars.values.sumBy { it.size }
        val baseStar = stars["YOU"]!!.find { stars["SAN"]!!.contains(it) }
        val part2 = stars["YOU"]!!.indexOf(baseStar) + stars["SAN"]!!.indexOf(baseStar)
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}