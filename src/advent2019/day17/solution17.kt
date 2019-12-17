package advent2019.day17

import advent2019.day09.runProgram
import utils.Coordinates
import utils.directions
import utils.turnInDirection
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val scaffoldsRaw =
            runProgram(program.toMutableMap()).second.map { it.toChar() }.joinToString("").split("\n").dropLast(2)
        val scaffoldsMap =
            scaffoldsRaw.mapIndexed { idxRow, s -> s.mapIndexed { idxCol, c -> Coordinates(idxCol, idxRow) to c } }
                .flatten().toMap().withDefault { '.' }
        val part1 = scaffoldsMap.filterValues { it == '#' }.filter { current ->
            directions.map { it + current.key }.filter { scaffoldsMap.getOrDefault(it, '.') == '#' }.size == 4
        }.keys.map { it.row * it.column }.sum()

        val movements = buildFunctions(findPath(scaffoldsMap))
        val videoFeed = "n".map { it.toLong() } + listOf(10L)
        val wakeMode = mapOf(0L to 2L) + program.filter { it.key != 0L }
        val part2 = runProgram(wakeMode.toMutableMap(), (movements[0] + videoFeed).toMutableList()).second.last()

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun findPath(
    scaffoldsMap: Map<Coordinates, Char>, path: String = "",
    currentPos: Coordinates = scaffoldsMap.filter { it.value == '^' }.keys.first(), direction: Int = 2
): String {
    val turn = "LR".mapNotNull {
        val newPos = scaffoldsMap.getValue(currentPos + directions[turnInDirection(direction, it)])
        if (newPos == '#') it else null
    }
    return if (turn.isEmpty()) path else {
        val newDir = turnInDirection(direction, turn.first())
        val (steps, newPos) = findSteps(currentPos, newDir, scaffoldsMap)
        findPath(scaffoldsMap, path + (if (turn.first() == 'R') "L," else "R,") + "$steps,", newPos, newDir)
    }
}

private tailrec fun findSteps(
    currentPos: Coordinates, newDir: Int, scaffoldsMap: Map<Coordinates, Char>,
    steps: Int = 0, nextPos: Coordinates = currentPos + directions[newDir]
): Pair<Int, Coordinates> =
    if (scaffoldsMap.getValue(nextPos) != '#') Pair(steps, currentPos) else {
        findSteps(nextPos, newDir, scaffoldsMap, steps.inc(), nextPos + directions[newDir])
    }

private fun buildFunctions(
    path: String, funNames: String = "ABC", functions: List<Long> = emptyList()
): List<List<Long>> {
    val idxStart = path.indexOfAny(charArrayOf('L', 'R'))
    return if (funNames.isEmpty()) {
        if (idxStart == -1) listOf(path.dropLast(1).map { it.toLong() } + listOf(10L) + functions) else emptyList()
    } else {
        var sections = path.substring(idxStart, if (idxStart + 21 > path.length) path.length else idxStart + 21)
        val ab = sections.indexOfAny(charArrayOf('A', 'B'))
        if (ab != -1) sections = sections.substring(0, ab)
        val currentFun = mutableListOf<String>()
        var idx = 2
        while (idx < sections.length) {
            idx = sections.indexOf(',', idx)
            if (idx == -1) idx = sections.length
            currentFun.add(sections.substring(0, idx))
            idx += 3
        }
        return currentFun.map {
            buildFunctions(
                path.replace(it, funNames[0].toString()), funNames.drop(1),
                functions + it.map { c -> c.toLong() } + listOf(10L))
        }
            .flatten().filter { it.isNotEmpty() }
    }
}