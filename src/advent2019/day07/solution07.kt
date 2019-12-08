package advent2019.day07

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").map { it.toInt() }
        val part1 = findHighestSignal(phasePositions(listOf("01234")), program)
        val part2 = findHighestSignal(phasePositions(listOf("98765")), program)
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun findHighestSignal(phases: List<String>, program: List<Int>): Int? {
    return phases.map { s ->
        val programs = s.map { Triple(program, listOf(it.toString().toInt()), 0) }.toMutableList()
        programs[0] = Triple(programs[0].first, programs[0].second + listOf(0), programs[0].third)
        var idx = 0
        while (programs.last().first[programs.last().third] != 99) {
            val result = runProgram(
                programs[idx].first.toIntArray(),
                programs[idx].second.toMutableList(),
                programs[idx].third
            )
            programs[idx] = Triple(result.first, emptyList(), result.third)
            programs[(idx + 1) % 5] = Triple(
                programs[(idx + 1) % 5].first,
                programs[(idx + 1) % 5].second + result.second,
                programs[(idx + 1) % 5].third
            )
            idx += if (idx == 4) -4 else 1
        }
        programs[0].second.last()
    }.max()
}

private fun phasePositions(phases: List<String>): List<String> =
    phases[0].flatMap { x -> if (phases[0].length == 1) listOf(x.toString()) else phasePositions(listOf(phases[0].filter { it != x })).map { x + it } }


private fun runProgram(program: IntArray, inputs: MutableList<Int>, index: Int = 0): Triple<List<Int>, List<Int>, Int> {
    var idx = index
    val output = mutableListOf<Int>()
    while (program[idx] != 99) {
        val instruction = program[idx].toString().padStart(5, '0')
        val (param1, param2, param3) = if (idx + 3 < program.size) program.slice(idx + 1..idx + 3)
        else (program + arrayListOf(0, 0, 0)).slice(idx + 1..idx + 3)
        val modes = instruction.take(3).reversed()
        when (instruction.takeLast(2)) {
            "01" -> {
                program[param3] = getValue(program, modes[0], param1) + getValue(program, modes[1], param2); idx += 4
            }
            "02" -> {
                program[param3] = getValue(program, modes[0], param1) * getValue(program, modes[1], param2); idx += 4
            }
            "03" -> {
                if (inputs.isEmpty()) return Triple(program.toList(), output, idx)
                else {
                    program[param1] = inputs.first(); inputs.removeAt(0);idx += 2
                }
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
    return Triple(program.toList(), output, idx)
}

private fun getValue(program: IntArray, mode: Char, param: Int) = if (mode == '0') program[param] else param