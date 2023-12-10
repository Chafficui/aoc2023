package days

import org.junit.jupiter.api.Assertions.*
import utils.readFileFromTestResources

class Day3Test {
    private val index = "3"
    private val day = Day3()

    @org.junit.jupiter.api.Test
    fun part1Example() {
        assertEquals(4361, day.part1(readFileFromTestResources("day${index}part1Example.txt")))
    }

    @org.junit.jupiter.api.Test
    fun part1Input() {
        assertEquals(535078, day.part1(readFileFromTestResources("day${index}Input.txt")))
    }

    @org.junit.jupiter.api.Test
    fun testPart1() {
        val day3 = Day3()
        val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent()

        val result = day3.part1(input)
        assertEquals(4361, result) // adjust with your expected result
    }


    @org.junit.jupiter.api.Test
    fun testPart1_singleDigitParts() {
        val input = """
            .1*..2..
            ...*....
            ....3#..
            .*......
            .....+4.
            ..5.....
            ......6.
            ...$....
            .7......
            ..8.....
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(8, result) // Each part should be counted once, sum = 1+2+3+4+5+6+7+8 = 36
    }


    @org.junit.jupiter.api.Test
    fun testPart1_multiDigitParts() {
        val input = """
            .10*..20..
            ...*......
            ....30#..
            .*........
            .....+40.
            ..50.....
            ......60.
            ...$.....
            .70......
            ..80.....
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(150, result) // Each multi-digit part should be counted once, sum = 10+20+30+40+50+60+70+80 = 360
    }


    @org.junit.jupiter.api.Test
    fun testPart1_noParts() {
        val input = """
            100...
            .....
            .....
            .....
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(0, result) // There are no parts adjacent to a symbol, sum = 0
    }

    @org.junit.jupiter.api.Test
    fun testPart1_symbolsSurroundedBySameNumber() {
        val input = """
            ..2..
            .*$*.
            ..2..
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(4, result)
    }

    @org.junit.jupiter.api.Test
    fun testPart1_sharedDigitsBetweenSymbols() {
        val input = """
            ......
            .*23*.
            ......
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(23, result)
    }

    @org.junit.jupiter.api.Test
    fun testPart1_numbersCloseToSymbols() {
        val input = """
            ..123..
            ...#...
            .......
        """.trimIndent()

        val result = day.part1(input)
        assertEquals(123, result)
    }
}