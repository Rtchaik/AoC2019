package advent2019.day02

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val initialState = input.split(",").map { it.toInt() }
        val part1 = runUpdatedProgram(initialState.toIntArray(), 12, 2)[0]
        var part2 = 0
        loop@ for (noun in 0..99) {
            for (verb in 0..99) {
                val result = runUpdatedProgram(initialState.toIntArray(), noun, verb)[0]
                if (result == 19690720) {
                    part2 = 100 * noun + verb
                    break@loop
                }
            }
        }

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun runUpdatedProgram(program: IntArray, noun: Int = program[1], verb: Int = program[2]): List<Int> {
    program[1] = noun
    program[2] = verb
    return runProgram(program)
}

private fun runProgram(program: IntArray): List<Int> {
    var idx = 0
    while (program[idx] != 99) {
        when (program[idx]) {
            1 -> program[program[idx + 3]] = program[program[idx + 1]] + program[program[idx + 2]]
            2 -> program[program[idx + 3]] = program[program[idx + 1]] * program[program[idx + 2]]
            else -> throw IllegalStateException("wrong code ${program[idx]} at position $idx")
        }
        idx += 4
    }
    return program.toList()
}