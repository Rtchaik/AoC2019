package advent2019.day06

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val orbitsMap = input.map { it.split(")") }.groupBy { it[0] }.mapValues { it.value.map { value -> value[1] } }
        val part1 = calculateOrbits(orbitsMap, listOf("COM"))

        val youOrbits = allOrbits(orbitsMap, listOf("YOU"))
        val sanOrbits = allOrbits(orbitsMap, listOf("SAN"))
        val baseStar = youOrbits.find { sanOrbits.contains(it) }
        val part2 = youOrbits.indexOf(baseStar) + sanOrbits.indexOf(baseStar) - 2
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun allOrbits(orbitsMap: Map<String, List<String>>, orbits: List<String>): List<String> =
    if (orbits.last() == "COM") orbits else allOrbits(
        orbitsMap,
        orbits + orbitsMap.filterValues { it.contains(orbits.last()) }.keys
    )

private tailrec fun calculateOrbits(
    orbitsMap: Map<String, List<String>>, current: List<String>, level: Int = 0, total: Int = 0
): Int =
    if (current.isEmpty()) total else calculateOrbits(
        orbitsMap, current.flatMap { planet -> orbitsMap.getOrDefault(planet, emptyList()) }, level.inc(),
        level * current.size + total
    )