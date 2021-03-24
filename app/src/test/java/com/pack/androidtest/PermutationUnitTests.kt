package com.pack.androidtest

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PermutationUnitTests {

    private fun assertArraysContainEqualPermutations(
        expectedArray: ArrayList<Array<Int>>,
        actualArray: ArrayList<Array<Int>>
    ) {
        val expectedSize: Int = expectedArray.size
        val actualSize: Int = actualArray.size
        assertEquals(expectedSize, actualSize)

        for (expEl in expectedArray) {
            var check = false
            for (actEl in actualArray) {
                if (expEl.contentEquals(actEl)) {
                    check = true
                    break
                }
            }

            if (!check) {
                fail("No expected permutation!")
            }
        }
    }

    private fun arrayProvider(): Array<Pair<Array<Int>, ArrayList<Array<Int>>>> {
        return arrayOf(Pair(arrayOf(0), arrayListOf(arrayOf(0))),
            Pair(arrayOf(-10, 10), arrayListOf(arrayOf(-10, 10), arrayOf(10, -10))),
            Pair(arrayOf(-10, 0, 10),arrayListOf(
                arrayOf(-10, 0, 10), arrayOf(-10, 10, 0), arrayOf(0, -10, 10),
                arrayOf(0, 10, -10), arrayOf(10, 0, -10), arrayOf(10, -10, 0))))
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun arrayTest(input: Pair<Array<Int>, ArrayList<Array<Int>>>) {
        val testArray: ArrayList<Array<Int>> = Permutation().permute(input.first)
        assertArraysContainEqualPermutations(input.second, testArray)
    }
}