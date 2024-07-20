import java.util.ArrayList;
import java.util.List;

public class ArrayListPerfDefaultSize {
    public static void main(String[] args) {
	// 1억개의 크기 미리 지정
        List<Integer> list1 = new ArrayList<>(100000000);

        // 배열 삽입 시간 측정 시작
        long startTimeInsert = System.nanoTime();
        for (int i = 0; i < 100000000 - 1; i++) {
            list1.add(1);
        }
	list1.add(2);

        // 배열 삽입 시간 측정 종료
        long endTimeInsert = System.nanoTime();
        long durationInsert = endTimeInsert - startTimeInsert;
        System.out.println("삽입 시간: " + durationInsert + " 나노초");

        // 배열 찾기 시간 측정 시작
        long startTimeSearch = System.nanoTime();
        int index = 0;
        while (2 != list1.get(index)) {
            index++;
        }
        // 배열 찾기 시간 측정 종료
        long endTimeSearch = System.nanoTime();
        long durationSearch = endTimeSearch - startTimeSearch;
        System.out.println("찾기 시간: " + durationSearch + " 나노초");
    }
}
