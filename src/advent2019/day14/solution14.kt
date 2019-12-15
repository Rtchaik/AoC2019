package advent2019.day14

import kotlin.math.ceil
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val reactions = input.map { item ->
            """\d+\s\w+""".toRegex().findAll(item).toList().flatMap { it.groupValues }.reversed()
                .map { resource -> resource.split(" ") }.map { it[1] to it[0].toInt() }
        }
        val part1 = findOre(reactions).toLong()
        val part2 = (oreLimit / findOre(reactions, false)).toLong()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun findOre(
    reactions: List<List<Pair<String, Int>>>, mode: Boolean = true,
    needed: MutableMap<String, Double> = mutableMapOf("FUEL" to 1.0).withDefault { 0.0 }
): Double = if (reactions.isEmpty()) needed.getValue("ORE") else {
    val current =
        needed.keys.first { key -> reactions.map { reaction -> reaction.count { it.first == key } }.sum() == 1 }
    val formula = reactions.find { it[0].first == current }!!
    val quantity = needed.getValue(current) / formula[0].second
    val quantityFinal = if (mode) ceil(quantity) else quantity
    needed.remove(current)
    formula.drop(1).forEach { needed[it.first] = needed.getValue(it.first) + it.second * quantityFinal }
    findOre(reactions - listOf(formula), mode, needed)
}