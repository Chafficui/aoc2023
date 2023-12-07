package days

import org.junit.jupiter.api.Assertions.*
import utils.readFileFromTestResources

class Day1Test {
    private val day1 = Day1()

    @org.junit.jupiter.api.Test
    fun part1Example() {
        assertEquals(142, day1.part1(readFileFromTestResources("day1part1Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part1Input() {
        assertEquals(54601, day1.part1(readFileFromTestResources("day1Input.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part2Example() {
        assertEquals(281, day1.part2(readFileFromTestResources("day1part2Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part2Input() {
        assertEquals(54078, day1.part2(readFileFromTestResources("day1Input.txt")))
    }
}