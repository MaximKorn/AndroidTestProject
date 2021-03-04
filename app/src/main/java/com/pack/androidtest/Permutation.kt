package com.pack.androidtest

class Permutation {
    fun permute (inputArray: Array<Int>): ArrayList<Array<Int>> {
        val inputSize = inputArray.size
        if (inputSize <=1) {
            return arrayListOf(inputArray)
        }

        var resArray: ArrayList<Array<Int>> = arrayListOf()
        for (i in inputArray.indices) {
            var t = arrayListOf<Int>().apply { addAll(inputArray) }
            t.removeAt(i)
            var res = permute(t.toTypedArray())

            for (j in res.indices) {
                var tt = arrayListOf<Int>().apply { addAll(res[j]) }
                tt.add(inputArray[i])
                resArray.add(tt.toTypedArray())
            }
        }

        return resArray
    }

//    fun solve1(input: ArrayList<Int>, output: ArrayList<ArrayList<Int>> = arrayListOf(), i: Int = 0): ArrayList<ArrayList<Int>> {
//        return solve1(input, arrayListOf<Int>().apply { addAll(input) }, output, i)
//    }
//
//    private fun solve1(input: ArrayList<Int>, result: ArrayList<Int>, output: ArrayList<ArrayList<Int>>, i: Int): ArrayList<ArrayList<Int>> {
//        if (i == result.size) {
//            output.add(result);
//            return output;
//        }
//
//        for ((index, value) in input.withIndex()) {
//            val t = arrayListOf<Int>().apply { addAll(result) }
//            t[i] = input[index]
//            val tt: ArrayList<Int> = arrayListOf<Int>().apply { addAll(input) }
//            tt.removeAt(index)
//            solve1(tt, t, output, i + 1)
//        }
//        return output;
//    }
}