package advent2019.day11

import advent2019.day09.runProgram
import utils.Coordinates
import utils.directions
import utils.turnInDirection
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val part1 = activateRobot(program).size
        println("Part 1: $part1")
        val painting = activateRobot(program, 1L)
        val columns = painting.keys.map { it.column }.toSet()
        val totalCol = columns.max()!! - columns.min()!!
        painting.toList().groupBy { it.first.row }.toSortedMap().values.reversed().forEach { row ->
            val line = (0..totalCol).map { ' ' }.toCharArray()
            row.forEach { if (it.second == 1L) line[it.first.column - columns.min()!!] = '#' }
            println(line.joinToString(""))
        }
    }
    println("Execution Time = $executionTime ms")
}

private fun activateRobot(program: Map<Long, Long>, color: Long = 0L) =
    paintRobot(Triple(program, listOf(0L), Pair(0L, 0L)), mutableMapOf(Coordinates(0, 0) to color))

private tailrec fun paintRobot(
    oldState: Triple<Map<Long, Long>, List<Long>, Pair<Long, Long>>, panels: MutableMap<Coordinates, Long>,
    currentPos: Coordinates = Coordinates(0, 0), direction: Int = 0
): Map<Coordinates, Long> {
    val curState = runProgram(
        oldState.first.toMutableMap(), mutableListOf(panels.getOrDefault(currentPos, 0L)), oldState.third
    )
    return if (curState.second.isEmpty()) panels else {
        panels[currentPos] = curState.second[0]
        val newDirection = turnInDirection(direction, if (curState.second[1] == 0L) 'L' else 'R')
        paintRobot(curState, panels, currentPos + directions[newDirection], newDirection)
    }
}
