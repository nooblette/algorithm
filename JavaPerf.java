public class JavaPerf {
    public static void main(String[] args) {
        Integer[] intElements = new Integer[100000000];

        // 배열 삽입 시간 측정 시작
        long startTimeInsert = System.nanoTime();
        for (int i = 0; i < 100000000 - 1; i++) {
            intElements[i] = 1;
        }
        intElements[100000000 - 1] = 2;
        // 배열 삽입 시간 측정 종료
        long endTimeInsert = System.nanoTime();
        long durationInsert = endTimeInsert - startTimeInsert;
        System.out.println("삽입 시간: " + durationInsert + " 나노초");

        // 배열 찾기 시간 측정 시작
        long startTimeSearch = System.nanoTime();
        int index = 0;
        while (2 != intElements[index]) {
            index++;
        }
        // 배열 찾기 시간 측정 종료
        long endTimeSearch = System.nanoTime();
        long durationSearch = endTimeSearch - startTimeSearch;
        System.out.println("찾기 시간: " + durationSearch + " 나노초");
    }
}

