import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] number = s.split(" ");
        int[] numberIntList = Arrays.stream(number)
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(numberIntList);
        
        return numberIntList[0] + " " + numberIntList[number.length-1];
    }
}