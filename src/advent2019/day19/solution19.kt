package advent2019.day19

import advent2019.day09.runProgram
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val area = 50
        val shipSize = 100
        var startX = 0L
        var endX = 0L
        var currentY = -1L
        var part1 = 0L
        do {
            currentY++
            if (runProgram(program.toMutableMap(), mutableListOf(startX, currentY)).second.first() == 0L) startX++
            if (runProgram(program.toMutableMap(), mutableListOf(endX, currentY)).second.first() == 1L) endX++
            else if (endX < startX) endX = startX
            if (currentY < area) part1 += endX - startX
        } while (!(endX - startX > shipSize &&
                    runProgram(program.toMutableMap(), mutableListOf(endX - shipSize, currentY + shipSize - 1))
                        .second.first() == 1L)
        )

        val part2 = (endX - shipSize) * 10000 + currentY
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}