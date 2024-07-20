fun main() {
    // IntArray 1억개 삽입
    val intElements = arrayOfNulls<Int?>(100000000)  // 배열을 크기 1억으로 초기화
    for (i in 0 until 100000000 - 1) {
        intElements[i] = 1
    }
    intElements[100000000 - 1] = 2

    // IntArray 1억개 중 찾기
    var index = 0
    while (2 != intElements[index]) {
        index++
    }
}
