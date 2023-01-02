package hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {

        // 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
        int max = nums.length / 2;

        // 중복 제거
        HashSet<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        // 중복을 제거한 셋의 크기가 max 보다 크면 max, 작으면 numsSet의 size를 리턴한다.
        if (numsSet.size() > max) {
            return max;
        } else {
            return numsSet.size();
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solution(new int[]{3, 1, 2, 3}));
    }
}
