package com.pack.androidtest

class Permutation {
    fun permute(inputArray: Array<Int>): ArrayList<Array<Int>> {
        val inputSize = inputArray.size
        if (inputSize <= 1) {
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
}