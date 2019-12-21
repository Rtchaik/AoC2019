package advent2019.day21

import advent2019.day09.runProgram
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val commands1 = listOf(
            """NOT A J""",
            """NOT B T""",
            """OR T J""",
            """NOT C T""",
            """OR T J""",
            """AND D J""",
            """WALK"""
        )
        val script1 = commands1.flatMap { it.map { c -> c.toLong() } + listOf(10L) }
//        to see video feed:
//        println(runProgram(program.toMutableMap(),script1.toMutableList()).second.map { it.toChar() })
        val part1 = runProgram(program.toMutableMap(), script1.toMutableList()).second.last()

        val commands2 = listOf(
            """NOT A J""",
            """NOT B T""",
            """OR T J""",
            """NOT C T""",
            """OR T J""",
            """AND D J""",
            """NOT D T""",
            """OR E T""",
            """OR H T""",
            """AND T J""",
            """RUN"""
        )
        val script2 = commands2.flatMap { it.map { c -> c.toLong() } + listOf(10L) }
        val part2 = runProgram(program.toMutableMap(), script2.toMutableList()).second.last()

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}