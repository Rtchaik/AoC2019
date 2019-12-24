package advent2019.day24

import utils.Coordinates
import utils.directions
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        var bugs1 = (input.indices).flatMap { row ->
            (input[0].indices).map { col -> Coordinates(col, row) to input[row][col] }
        }.toMap()
        var bugs2 = bugs1.filter { it.key != Coordinates(2, 2) }.mapKeys { it.key to 0 }

        val states = mutableListOf<String>()
        while (states.distinct().size == states.size) {
            states.add(bugs1.values.joinToString(""))
            bugs1 = nextMinute(bugs1)
        }
        val part1 = generateSequence(1) { it * 2 }.take(25)
            .mapIndexedNotNull { idx, i -> if (states.last()[idx] == '#') i else null }.sum()

        repeat(200) { bugs2 = nextMinute2(bugs2) }
        val part2 = bugs2.values.count { it == '#' }

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun nextMinute2(
    remaining: Map<Pair<Coordinates, Int>, Char>, bugs: Map<Pair<Coordinates, Int>, Char> = remaining
): Map<Pair<Coordinates, Int>, Char> {
    val newBugs = mutableMapOf<Pair<Coordinates, Int>, Char>()
    val newCells = mutableMapOf<Pair<Coordinates, Int>, Char>()
    remaining.forEach { cell ->
        val neighbours = directions.map { it + cell.key.first }.flatMap {
            val valid = mutableListOf<Pair<Coordinates, Int>>()
            when {
                it.row !in (0..4) || it.column !in (0..4) -> valid.add(
                    (if (it.row !in (0..4)) Coordinates(2, 2 + it.row % 4)
                    else Coordinates(2 + it.column % 4, 2)) to cell.key.second.inc()
                )
                it == Coordinates(2, 2) -> (0..4).map { i ->
                    if (cell.key.first.row != 2) Coordinates(i, cell.key.first.row * 2 - 2)
                    else Coordinates(cell.key.first.column * 2 - 2, i)
                }.forEach { coord -> valid.add(coord to cell.key.second.dec()) }
                else -> valid.add(it to cell.key.second)
            }
            valid
        }
        if (cell.value == '#') neighbours.filter { bugs[it] == null }.forEach { newCells[it] = '.' }
        val adjacentBugs = neighbours.count { bugs.getOrDefault(it, '.') == '#' }
        newBugs[cell.key] = newState(cell.value, adjacentBugs)
    }
    return if (newCells.isEmpty()) newBugs else newBugs + nextMinute2(newCells, bugs + newCells)
}

private fun nextMinute(bugs: Map<Coordinates, Char>): Map<Coordinates, Char> {
    val newBugs = mutableMapOf<Coordinates, Char>()
    bugs.forEach { cell ->
        val neighbours = directions.map { it + cell.key }.count { bugs.getOrDefault(it, '.') == '#' }
        newBugs[cell.key] = newState(cell.value, neighbours)
    }
    return newBugs
}

private fun newState(current: Char, neighbours: Int) = when {
    current == '#' && neighbours != 1 -> '.'
    current == '.' && neighbours in (1..2) -> '#'
    else -> current
}