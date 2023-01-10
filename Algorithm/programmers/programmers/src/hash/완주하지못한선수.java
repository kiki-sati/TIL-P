package hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        /**
         * participant - 참여자
         * completion - 완주한 선수
         * completion의 길이는 participant의 길이보다 1 작다.
         * 참가자 중에는 동명이인이 있을 수 있다.
         */

        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // participant 배열의 요소를 받아서 map에 put 해준다.
        for (String player : participant) {

            // player가 map에 없으면 0을 value로 새로운 entry를 추가,
            // 있으면 기존 entry의 value + 1 증가시킨다.
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // completion 배열이 요소를 map에 저장한다.
        for (String player : completion) {
            int count = map.get(player);
            if (count > 1) {
                map.put(player, count - 1);
            } else {
                map.remove(player);
            }
        }

        return map.keySet().iterator().next();
    }

    @Test
    public void test() {
        Assert.assertEquals("vinko", solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
    }

}

