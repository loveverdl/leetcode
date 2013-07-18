/*
 * FILE     :  LongestsubstringWithoutRepeatingCharacters.java
 *
 * CLASS    :  LongestsubstringWithoutRepeatingCharacters
 *
 * COPYRIGHT:
 *
 *   The computer systems, procedures, data bases and programs
 *   created and maintained by Qware Technology Group Co Ltd, are proprietary
 *   in nature and as such are confidential.  Any unauthorized
 *   use or disclosure of such information may result in civil
 *   liabilities.
 *
 *   Copyright Jul 18, 2013 by Qware Technology Group Co Ltd.
 *   All Rights Reserved.
 */
package cn.zju.edu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestsubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		char[] cs = s.toCharArray();
		int length = s.length();
		int num = 0, currentNum = 0;
		int j = 0;
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < length; i++) {
			if (map.get(cs[i]) == null) {
				map.put(cs[i], true);
				currentNum++;
			} else {
				if (currentNum > num) {
					num = currentNum;
				}
				for (int k = j; k < i; k++) {

					if (map.get(cs[k]) != null) {
						map.remove(cs[k]);
						currentNum--;
					}
					j = k + 1;
				}
			}
		}
		if (currentNum > num) {
			num = currentNum;
		}
		return num;
		// Start typing your Java solution below
		// DO NOT write main() function

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestsubstringWithoutRepeatingCharacters s = new LongestsubstringWithoutRepeatingCharacters();
		System.out.println(s.lengthOfLongestSubstring("stackoverflow"));
	}

}
