package advent2019.day09

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val part1 = runProgram(program.toMutableMap(), mutableListOf(1L)).second.last()
        val part2 = runProgram(program.toMutableMap(), mutableListOf(2L)).second.last()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

fun runProgram(
    program: MutableMap<Long, Long>,
    inputs: MutableList<Long> = mutableListOf(0L),
    startPos: Pair<Long, Long> = Pair(0L, 0L)
): Triple<Map<Long, Long>, List<Long>, Pair<Long, Long>> {
    var idx = startPos.first
    var relBase = startPos.second
    val output = mutableListOf<Long>()
    while (program[idx] != 99L) {
        val instruction = program[idx].toString().padStart(5, '0')
        val modes = instruction.take(3).reversed()
        val params =
            (0 until 3).map { program.getOrDefault(idx + it + 1, 0L) + if (modes[it] == '2') relBase else 0L }
        when (val opcode = instruction.takeLast(2)) {
            "01", "02" -> {
                val (p1, p2) = listOf(0, 1).map { getValue(program, modes[it], params[it]) }
                program[params[2]] = if (opcode == "01") p1 + p2 else p1 * p2
                idx += 4
            }
            "03" -> {
                if (inputs.isEmpty()) return Triple(program, output, Pair(idx, relBase))
                else {
                    program[params[0]] = inputs.first(); inputs.removeAt(0);idx += 2
                }
            }
            "04" -> {
                output.add(getValue(program, modes[0], params[0])); idx += 2
            }
            "05", "06" -> {
                val (p1, p2) = listOf(0, 1).map { getValue(program, modes[it], params[it]) }
                if ((p1 != 0L && opcode == "05") || (p1 == 0L && opcode == "06")) idx = p2 else idx += 3
            }
            "07", "08" -> {
                val (p1, p2) = listOf(0, 1).map { getValue(program, modes[it], params[it]) }
                program[params[2]] = if ((p1 < p2 && opcode == "07") || (p1 == p2 && opcode == "08")) 1L else 0L
                idx += 4
            }
            "09" -> {
                relBase += getValue(program, modes[0], params[0]); idx += 2
            }
            else -> throw IllegalStateException("wrong code ${program[idx]} at position $idx")
        }
    }
    return Triple(program, output, Pair(idx, relBase))
}

private fun getValue(program: Map<Long, Long>, mode: Char, param: Long): Long =
    when (mode) {
        '0', '2' -> program.getOrDefault(param, 0)
        '1' -> param
        else -> throw java.lang.IllegalStateException("wrong mode value")
    }