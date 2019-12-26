package advent2019.day18

import utils.Coordinates
import utils.diagonals
import utils.directions
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val tunnels = input.mapIndexed { idxRow, s -> s.mapIndexed { idxCol, c -> Coordinates(idxCol, idxRow) to c } }
            .flatten().toMap().toMutableMap()
        val allKeys = tunnels.filterValues { it.isLowerCase() || it == '@' }
            .map { it.value to findDistances(tunnels, listOf(it.key)).toMap() }.toMap()
        val allDoors = tunnels.filterValues { it.isUpperCase() }.map { current ->
            current.value to directions.map { it + current.key }.filter { tunnels.getValue(it) != '#' }
                .map { findObjects(tunnels, listOf(it)).filterNot { c -> c == current.value } }
        }.toMap()
        val entranceCoord = tunnels.filterValues { it == '@' }.keys.first()
        val entranceChars = findObjects(tunnels, listOf(entranceCoord)).filter { it.isLowerCase() }
        val part1 = searchKeys(listOf(Nodes('@', 0, emptySet(), entranceChars.toSet())), allKeys, allDoors)

        (listOf(entranceCoord) + directions.map { it + entranceCoord }).forEach { tunnels[it] = '#' }
        val part2 = diagonals.map { entranceCoord + it }.map { findDistances(tunnels, listOf(it)).toMap() }
            .map { vault ->
                vault.map { searchKeys2(it.key, (vault.keys - listOf(it.key)), allKeys, it.value) }.min()!!
            }.sum()

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private data class Nodes(val name: Char, val steps: Int, val path: Set<Char>, val available: Set<Char>)//private

private fun searchKeys2(current: Char, remaining: Set<Char>, allKeys: Map<Char, Map<Char, Int>>, steps: Int): Int =
    if (remaining.isEmpty()) steps else {
        steps + remaining.map { searchKeys2(it, remaining - listOf(it), allKeys, allKeys[current]!![it]!!) }.min()!!
    }

private tailrec fun searchKeys(
    current: List<Nodes>, allKeys: Map<Char, Map<Char, Int>>, allDoors: Map<Char, List<List<Char>>>
): Int =
    if (current[0].available.isEmpty()) current.minBy { it.steps }!!.steps else {
        val new = current.flatMap { node ->
            node.available.map { next ->
                val newKeys = allDoors.getOrDefault(next.toUpperCase(), emptyList()).flatten().toMutableList()
                newKeys += newKeys.filter { it.isUpperCase() }
                    .filter { it.toLowerCase() in node.path }
                    .flatMap { allDoors.getOrDefault(it, emptyList()).flatten() }
                val newKeysFinal =
                    if ((node.available + node.path).intersect(newKeys.toSet()).isNotEmpty()) newKeys.filter { it.isLowerCase() }
                    else emptyList()
                Nodes(
                    next, node.steps + allKeys[node.name]!![next]!!, node.path + listOf(next),
                    node.available + newKeysFinal - listOf(next) - node.path
                )
            }
        }
        val united = new.filterNot { it.available.isEmpty() && it.path.size < allKeys.size - 1 }
            .groupBy { Pair(it.name, (it.path - listOf(it.name)).sorted()) }
            .map { node -> node.value.minBy { it.steps }!! }
        searchKeys(united, allKeys, allDoors)
    }

private fun findObjects(
    tunnels: Map<Coordinates, Char>, current: List<Coordinates>, visited: List<Coordinates> = current
): List<Char> =
    if (current.isEmpty()) visited.map { tunnels.getValue(it) }.filter { it != '.' && it != '@' } else {
        val neighbours =
            current.flatMap { coord ->
                if (tunnels.getValue(coord).isUpperCase()) listOf(coord)
                else directions.map { it + coord }.filter { tunnels.getValue(it) != '#' } - visited
            }.distinct()
        findObjects(tunnels, neighbours.filter { !tunnels.getValue(it).isUpperCase() }, visited + neighbours)
    }

private fun findDistances(
    tunnels: Map<Coordinates, Char>, current: List<Coordinates>, visited: List<Coordinates> = current, steps: Int = 1,
    allKeys: List<Pair<Char, Int>> = emptyList()
): List<Pair<Char, Int>> =
    if (current.isEmpty()) allKeys else {
        val neighbours = current.flatMap { coord ->
            directions.map { it + coord }.filter { tunnels.getValue(it) != '#' } - visited
        }.distinct()
        val checkNewKeys = neighbours.filter { tunnels.getValue(it).isLowerCase() }
        val newKeys =
            if (checkNewKeys.isEmpty()) emptyList() else checkNewKeys.map { Pair(tunnels.getValue(it), steps) }
        findDistances(
            tunnels,
            neighbours,
            visited + neighbours,
            steps.inc(),
            allKeys + newKeys
        )
    }
