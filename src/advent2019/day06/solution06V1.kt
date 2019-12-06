package advent2019.day06

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val orbitsMap = input.map { it.split(")") }.groupBy { it[0] }.mapValues { it.value.map { value -> value[1] } }
        val part1 = calculateOrbits(orbitsMap, listOf("COM"))
        val part2 = findSanta(orbitsMap, listOf("YOU"))
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun findSanta(
    orbitsMap: Map<String, List<String>>, current: List<String>,
    previous: List<String> = emptyList(), steps: Int = -2
): Int =
    if (current.contains("SAN")) steps else findSanta(orbitsMap, current.flatMap { planet ->
        orbitsMap.getOrDefault(planet, emptyList()) + orbitsMap.filterValues { it.contains(planet) }.keys
    } - previous, current, steps.inc())

private tailrec fun calculateOrbits(
    orbitsMap: Map<String, List<String>>, current: List<String>, level: Int = 0, total: Int = 0
): Int =
    if (current.isEmpty()) total else calculateOrbits(
        orbitsMap, current.flatMap { planet -> orbitsMap.getOrDefault(planet, emptyList()) }, level.inc(),
        level * current.size + total
    )