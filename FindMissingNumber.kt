class SearchMissingNumber {

    fun searchMissingNumber(list: List<Int>): Int {

        if (list.isEmpty()) return -1

        if(list[0] + list.size - 1 == list[list.size - 1]) return -1

        val listSize = list.size

        var low = 0
        var high = listSize - 1

        while (low <= high) {

            val mid = low + (high - low)/ 2

            if (list[mid] - list[0] == mid) {
                low = mid + 1
            } else {
                high = mid -1
            }
        }

        return list[0] + low
    }

}


fun main() {
    val result = SearchMissingNumber().searchMissingNumber(
        listOf(1, 3, 4, 5, 6, 7, 8, 9, 10)
    )
    val result2 = SearchMissingNumber().searchMissingNumber(
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    )
    println(result)
}