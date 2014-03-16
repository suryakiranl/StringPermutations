package edu.cmu.sv.surya;

import java.util.ArrayList;
import java.util.List;

public class StrPermutationsV2 {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("abcd");
		
		List<String> perms = getPermutations(str.toString());
		System.out.println("Perms = " + perms);
	}

	public static List<String> getPermutations(String str) {
		List<String> permutations = new ArrayList<String>();
		char[] strChars = str.toCharArray();

		for (int loop = 0; loop < str.length(); loop++) {
			String strToPermutate = str.substring(0, loop);
			if ((loop + 1) != str.length()) {
				strToPermutate += str.substring(loop + 1, str.length());
			}

			List<String> subPermutations = getSubPermutations(strToPermutate);
			for (String subStr : subPermutations) {
				permutations.add(strChars[loop] + subStr);
			}
		}

		return permutations;
	}

	private static List<String> getSubPermutations(String str) {
		List<String> subPermutations = new ArrayList<String>();
		
		if (str.length() == 1) {
			subPermutations.add(str);
		} else if (str.length() == 2) {
			char[] chars = str.toCharArray();
			subPermutations.add(chars[0] + "" + chars[1]);
			subPermutations.add(chars[1] + "" + chars[0]);
		} else {
			subPermutations = getPermutations(str);
		}

		return subPermutations;
	}
}
