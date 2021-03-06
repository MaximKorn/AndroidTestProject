package com.pack.androidtest

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class PermutationUnitTests {

    private lateinit var oneElementArray: Array<Int>
    private lateinit var twoElementsArray: Array<Int>
    private lateinit var threeElementsArray: Array<Int>

    private lateinit var oneElementExpectedArray: ArrayList<Array<Int>>
    private lateinit var twoElementsExpectedArray: ArrayList<Array<Int>>
    private lateinit var threeElementsExpectedArray: ArrayList<Array<Int>>

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

    @Before
    fun beforeTest() {
        oneElementArray = arrayOf(0)
        twoElementsArray = arrayOf(-10, 10)
        threeElementsArray = arrayOf(-10, 0, 10)

        oneElementExpectedArray = arrayListOf(arrayOf(0))
        twoElementsExpectedArray = arrayListOf(arrayOf(-10, 10), arrayOf(10, -10))
        threeElementsExpectedArray = arrayListOf(
            arrayOf(-10, 0, 10), arrayOf(-10, 10, 0), arrayOf(0, -10, 10),
            arrayOf(0, 10, -10), arrayOf(10, 0, -10), arrayOf(10, -10, 0)
        )
    }

    @Test
    fun oneElementArrayTest() {
        val testArray: ArrayList<Array<Int>> = Permutation().permute(oneElementArray)
        assertArraysContainEqualPermutations(oneElementExpectedArray, testArray)
    }

    @Test
    fun twoElementsArrayTest() {
        val testArray: ArrayList<Array<Int>> = Permutation().permute(twoElementsArray)
        assertArraysContainEqualPermutations(twoElementsExpectedArray, testArray)
    }

    @Test
    fun threeElementsArrayTest() {
        val testArray: ArrayList<Array<Int>> = Permutation().permute(threeElementsArray)
        assertArraysContainEqualPermutations(threeElementsExpectedArray, testArray)
    }
}