package org.pg.march.lc.num;

/*
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {

	public boolean isNumber(String s) {
		if (s == null || (s = s.trim()).isEmpty()) {
			return false;
		}

		boolean numberSeen = false;
		boolean eSeen = false;
		boolean pointSeen = false;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				numberSeen = true;
			}else if(c == 'e') {
				if(!numberSeen || eSeen) return false;
				eSeen = true;
				numberSeen = false;
			}else if(c == '.') {
				if(eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			}else if(c == '+' || c == '-') {
				if(i != 0 && s.charAt(i-1) != 'e') {
					return false;
				}
			}else {
				return false;
			}
		}

		return numberSeen;
	}
}
