package advent2019.day12

import utils.divisorsList
import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val pos = input.map { it -> """-?\d+""".toRegex().findAll(it).map { it.groupValues[0].toInt() }.toList() }
        val axis = (0..2).map { axis -> (0..3).map { pos[it][axis] } }
        val vel = (0..2).map { (0..3).map { 0 } }
        val simulations = generateSequence(Pair(axis, vel)) { spaceTurn(it.first, it.second) }.take(1001).last()
        val part1 = (0..3).map { planet ->
            (0..2).map { abs(simulations.first[it][planet]) }.sum() *
                    (0..2).map { abs(simulations.second[it][planet]) }.sum()
        }.sum()

        val history = (0..2).map { cycle(axis[it] + vel[it], axis, vel, it) }
        val divisors = history.map { divisorsList(it).toSet() }.reduce { acc, list -> acc.intersect(list) }
            .reduce { acc, i -> acc * i }

        val part2 = history.fold(1L) { acc, i -> acc * (i / divisors) }

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun cycle(start: List<Int>, positions1: List<List<Int>>, velocity1: List<List<Int>>, planetIdx: Int): Int {
    var idx1 = 0
    var positions = positions1
    var velocity = velocity1
    var new = emptyList<Int>()
    while (!(new == start)) {
        val aa = spaceTurn(positions, velocity)
        positions = aa.first
        velocity = aa.second
        new = positions[planetIdx] + velocity[planetIdx]
        idx1++
    }
    return idx1
}

private fun spaceTurn(axis: List<List<Int>>, vel: List<List<Int>>): Pair<List<List<Int>>, List<List<Int>>> {
    val gravity = axis.map { ax ->
        ax.map { planet ->
            (ax - planet).map {
                when {
                    planet > it -> -1
                    planet < it -> +1
                    else -> 0
                }
            }.sum()
        }
    }
    val newVel = (0..2).map { vel[it].zip(gravity[it]).map { it.toList().sum() } }
    return (0..2).map { axis[it].zip(newVel[it]).map { it.toList().sum() } } to newVel
}