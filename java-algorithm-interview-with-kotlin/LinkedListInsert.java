import java.util.List;
import java.util.LinkedList;

public class LinkedListInsert {
    public static void main(String[] args) {
        List<Integer> list1  = new LinkedList<>();;

        // 배열 삽입 시간 측정 시작
        long startTimeInsert = System.nanoTime();
        for (int i = 0; i < 100000000; i++) {
            list1.add(1);
        }
        // 배열 삽입 시간 측정 종료
        long endTimeInsert = System.nanoTime();
        long durationInsert = endTimeInsert - startTimeInsert;
        System.out.println("삽입 시간: " + durationInsert + " 나노초");
   }
}

