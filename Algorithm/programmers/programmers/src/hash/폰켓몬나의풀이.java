package hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class 폰켓몬나의풀이 {
    public int solution(int[] nums) {

        // 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
        int pickPoncket = nums.length / 2;

        // HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        if (set.size() > pickPoncket) {
            return pickPoncket;
        } else {
            return set.size();
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solution(new int[]{3, 1, 2, 3}));
    }
}
