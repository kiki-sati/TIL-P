package step01;

import java.util.Calendar;

public class Solution {
	public int solution(int angle) {
		if (angle <= 0 || angle >= 90) {
			if (angle == 90) {
				return 2;
			} else if (angle > 90 && angle < 180){
				return 3;
			} else {
				return 4;
			}
		} else {
			return 1;
		}
	}
}
