package days

import org.junit.jupiter.api.Assertions.*
import utils.readFileFromTestResources

class Day4Test {
    private val index = "4"
    private val day = Day4()

    @org.junit.jupiter.api.Test
    fun part1Example() {
        assertEquals(13, day.part1(readFileFromTestResources("day${index}part1Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part1Input() {
        assertEquals(25183, day.part1(readFileFromTestResources("day${index}Input.txt")))
    }
}