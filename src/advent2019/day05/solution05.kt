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
        val (param1, param2, param3) = program.slice(idx + 1..idx + 3)
        val modes = instruction.take(3).reversed()
        when (instruction.takeLast(2)) {
            "01" -> {
                program[param3] = getValue(program, modes[0], param1) + getValue(program, modes[1], param2); idx += 4
            }
            "02" -> {
                program[param3] = getValue(program, modes[0], param1) * getValue(program, modes[1], param2); idx += 4
            }
            "03" -> {
                program[param1] = input; idx += 2
            }
            "04" -> {
                output.add(getValue(program, modes[0], param1)); idx += 2
            }
            "05" -> {
                if (getValue(program, modes[0], param1) != 0) idx = getValue(program, modes[1], param2) else idx += 3
            }
            "06" -> {
                if (getValue(program, modes[0], param1) == 0) idx = getValue(program, modes[1], param2) else idx += 3
            }
            "07" -> {
                if (getValue(program, modes[0], param1) < getValue(program, modes[1], param2)) program[param3] = 1
                else program[param3] = 0; idx += 4
            }
            "08" -> {
                if (getValue(program, modes[0], param1) == getValue(program, modes[1], param2)) program[param3] = 1
                else program[param3] = 0; idx += 4
            }
            else -> throw IllegalStateException("wrong code ${program[idx]} at position $idx")
        }
    }
    return Pair(program.toList(), output)
}

private fun getValue(program: IntArray, mode: Char, param: Int) = if (mode == '0') program[param] else param