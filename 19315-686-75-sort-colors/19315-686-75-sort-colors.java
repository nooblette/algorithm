class Solution {
    private static final int MID = 1;
    
    public void sortColors(int[] nums) {
        
        // red와 blue는 양쪽 끝 포인터 (각각 0과 2), white(중앙 값 1)는 중앙에서 움직인다.
        int red = 0;
        int white = red;
        int blue = nums.length;
        
        // white blue가 역전될 때까지 반복
        while(white < blue) {
            // white 포인터가 중앙 값보다 작다면 그 값은 red 포인터가 가리키는 값에 해당한다.
            if(nums[white] < MID) {
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;
                
                // 다음 인덱스 탐색을 위해 각각 한 칸씩 우측으로 이동한다.
                red++;
                white++;
            } else if(nums[white] > MID) {
                // white 포인터가 중앙 값보다 크다면 그 값은 blue 포인터가 가리키는 값에 해당한다.
                blue--;
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
            } else {
                // white 포인터가 중앙 값과 같다면 올바른 포인터, 다음 인덱스 탐색을 위해 white만 한 칸 우측으로 이동한다.
                white++;
            }
        }
    }
}