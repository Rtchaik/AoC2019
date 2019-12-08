package advent2019.day08

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val layers = input.chunked(wide * tall)
        val min0 = layers.minBy { layer -> layer.count { it == '0' } }!!.groupBy { it }
        val part1 = min0['1']!!.size * min0['2']!!.size
        println("Part 1: $part1")
        val image =
            layers.reduce { acc, s -> acc.zip(s).map { if (it.first == '2') it.second else it.first }.joinToString("") }
                .replace('0', ' ').chunked(wide)
        for (line in image) println(line)
    }
    println("Execution Time = $executionTime ms")
}