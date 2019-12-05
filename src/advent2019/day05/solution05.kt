package advent2019.day05

import kotlin.IllegalStateException
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").map { it.toInt() }
        val part1 = runProgram(program.toIntArray(), 1).second.last()
        val part2 = runProgram(program.toIntArray(), 5).second.last()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun runProgram(program: IntArray, input: Int = 0): Pair<List<Int>, List<Int>> {
    var idx = 0
    val output = mutableListOf<Int>()
    while (program[idx] != 99) {
        val instruction = program[idx].toString().padStart(5, '0')
        val modes = instruction.take(3).reversed()
        when (instruction.takeLast(2)) {
            "01" -> {
                program[program[idx + 3]] =
                    getValue(program, idx, modes, 1) + getValue(program, idx, modes, 2); idx += 4
            }
            "02" -> {
                program[program[idx + 3]] =
                    getValue(program, idx, modes, 1) * getValue(program, idx, modes, 2); idx += 4
            }
            "03" -> {
                program[program[idx + 1]] = input; idx += 2
            }
            "04" -> {
                output.add(getValue(program, idx, modes, 1)); idx += 2
            }
            "05" -> {
                if (getValue(program, idx, modes, 1) != 0) idx = getValue(program, idx, modes, 2) else idx += 3
            }
            "06" -> {
                if (getValue(program, idx, modes, 1) == 0) idx = getValue(program, idx, modes, 2) else idx += 3
            }
            "07" -> {
                if (getValue(program, idx, modes, 1) < getValue(program, idx, modes, 2)) program[program[idx + 3]] = 1
                else program[program[idx + 3]] = 0; idx += 4
            }
            "08" -> {
                if (getValue(program, idx, modes, 1) == getValue(program, idx, modes, 2)) program[program[idx + 3]] = 1
                else program[program[idx + 3]] = 0; idx += 4
            }
            else -> throw IllegalStateException("wrong code ${program[idx]} at position $idx")
        }
    }
    return Pair(program.toList(), output)
}

private fun getValue(program: IntArray, index: Int, modes: String, param: Int) =
    if (modes[param - 1] == '0') program[program[index + param]] else program[index + param]