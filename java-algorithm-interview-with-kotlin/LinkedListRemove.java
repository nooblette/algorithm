import java.util.List;
import java.util.LinkedList;

public class LinkedListRemove {
    public static void main(String[] args) {
        List<Integer> list1  = new LinkedList<>();

        // 배열 삽입
        for (int i = 0; i < 100000000; i++) {
            list1.add(1);
        }

	// 배열 삭제 시간 측정 시작
	long startTimeRemove = System.nanoTime();

	// ArrayList<Intger> 1000000번째 인덱스 100개 삭제
	for(int i = 0; i < 100; i++){
		list1.remove(1000000);
	}

	// 배열 삭제 시간 측정 종료
        long endTimeRemove = System.nanoTime();
        long durationRemove = endTimeRemove - startTimeRemove;
        System.out.println("삭제 시간: " + durationRemove + " 나노초");
   }
}
