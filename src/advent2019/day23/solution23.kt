package advent2019.day23

import advent2019.day09.runProgram
import java.util.*
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val instructions = ArrayDeque<List<Long>>()
        val computers = mutableMapOf<Long, Pair<Map<Long, Long>, Pair<Long, Long>>>()
        var nat = emptyList<Long>()
        val natY = mutableListOf<Long>()

        (0L..49L).forEach { comp ->
            val boot = runProgram(program.toMutableMap(), mutableListOf(comp, -1L))
            computers[comp] = Pair(boot.first, boot.third)
            if (boot.second.isNotEmpty()) boot.second.chunked(3).forEach { instructions.offer(it) }
        }

        while (natY.isEmpty() || natY.size < 2 || natY.takeLast(2).distinct().size == 2) {
            if (instructions.isEmpty()) {
                instructions.offer(nat)
                natY.add(nat.last())
            }
            val packet = instructions.poll()
            val current = runProgram(
                computers[packet[0]]!!.first.toMutableMap(),
                packet.drop(1).toMutableList(),
                computers[packet[0]]!!.second
            )
            computers[packet[0]] = Pair(current.first, current.third)
            if (current.second.isNotEmpty())
                if (current.second[0] != 255L) current.second.chunked(3).forEach { instructions.offer(it) }
                else nat = listOf(0L) + current.second.drop(1)

        }

        val part1 = natY.first()
        val part2 = natY.last()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}