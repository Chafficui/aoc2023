package days

import org.junit.jupiter.api.Assertions.*
import utils.readFileFromTestResources

class Day2Test {
    private val day = Day2()

    @org.junit.jupiter.api.Test
    fun part1Example() {
        assertEquals(8, day.part1(readFileFromTestResources("day2part1Example.txt"), 12, 13, 14))
    }

    @org.junit.jupiter.api.Test
    fun part1Input() {
        assertEquals(3099, day.part1(readFileFromTestResources("day2Input.txt"), 12, 13, 14))
    }

    @org.junit.jupiter.api.Test
    fun part2Example() {
        assertEquals(281, day.part2(readFileFromTestResources("day2part2Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part2Input() {
        assertEquals(54078, day.part2(readFileFromTestResources("day2Input.txt")))
    }
}