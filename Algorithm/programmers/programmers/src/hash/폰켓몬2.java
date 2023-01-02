package hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class 폰켓몬2 {
    public int solution(int[] nums) {

        int answer = 0;
        // 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
        int max = nums.length / 2;

        // 중복 제거
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        if (max >= numsSet.size()) answer = numsSet.size();
        else answer = max;

        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solution(new int[]{3, 1, 2, 3}));
    }
}
