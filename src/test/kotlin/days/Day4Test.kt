package days

import org.junit.jupiter.api.Assertions.*
import utils.readFileFromTestResources

class Day4Test {
    private val index = "4"
    private val day = Day4()

    @org.junit.jupiter.api.Test
    fun part1Example() {
        assertEquals(13, day.part1(readFileFromTestResources("day${index}Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part1Input() {
        assertEquals(25183, day.part1(readFileFromTestResources("day${index}Input.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part2Example() {
        assertEquals(30, day.part2(readFileFromTestResources("day${index}Example.txt"), 2))
    }

    @org.junit.jupiter.api.Test
    fun part2Input() {
        assertEquals(5667240, day.part2(readFileFromTestResources("day${index}Input.txt"), 2))
    }

    @org.junit.jupiter.api.Test
    fun testExtractCardNumber() {
        assertEquals(1, day.extractCardNumbers("Card 1: 9 2 | 10 1"))
        assertEquals(2, day.extractCardNumbers("Card      2: 9 2 | 10 1"))
        assertEquals(3, day.extractCardNumbers("Card      3: 9 2 | 10 1"))
        assertEquals(23, day.extractCardNumbers("Card      23: 9 2 | 10 1"))
        assertEquals(333, day.extractCardNumbers("Card    333: 9 2 | 10 1"))
        assertEquals(3, day.extractCardNumbers("Card 3: 9 2 | 10 1"))
    }
}