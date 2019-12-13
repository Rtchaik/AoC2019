package advent2019.day13

import advent2019.day09.runProgram
import utils.Coordinates
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val part1 = runProgram(program.toMutableMap()).second.chunked(3).count { it[2] == 2L }
        val freeMode = mapOf(0L to 2L) + program.filter { it.key != 0L }
        val part2 = runGame(freeMode.toMutableMap())
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun runGame(
    program: MutableMap<Long, Long>, inputs: MutableList<Long> = mutableListOf(0L),
    startPos: Pair<Long, Long> = Pair(0L, 0L), outputs: MutableMap<Coordinates, Int> = mutableMapOf()
): Int {
    val turn = runProgram(program, inputs, startPos)
    val changes = turn.second.map { it.toInt() }.chunked(3).map { Coordinates(it[0], it[1]) to it[2] }
    changes.forEach { outputs[it.first] = it.second }
    val ball = changes.find { it.second == 4 } ?: outputs.filterValues { it == 4 }.entries.first().toPair()
    val paddle = changes.find { it.second == 3 } ?: outputs.filterValues { it == 3 }.entries.first().toPair()
    val action = when {
        ball.first.column < paddle.first.column -> -1
        ball.first.column > paddle.first.column -> 1
        else -> 0
    }
    return if (outputs.none { it.value == 2 }) outputs[Coordinates(-1, 0)]!! else runGame(
        turn.first.toMutableMap(), mutableListOf(action.toLong()), turn.third, outputs
    )
}

