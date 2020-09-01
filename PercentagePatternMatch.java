package com.codex.bot.util;

import com.codex.framework.exception.BaseException;

/**
 * 
 * @author Sachin Bainur
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @date 20-feb-2018
 */
public class PercentagePatternMatch {

	private PercentagePatternMatch () {
	}

	public static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		for (int i = 0; i < len0; i++)
			cost[i] = i;

		for (int j = 1; j < len1; j++) {

			newcost[0] = j;

			for (int i = 1; i < len0; i++) {

				int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

				int costReplace = cost[i - 1] + match;
				int costInsert = cost[i] + 1;
				int costDelete = newcost[i - 1] + 1;

				newcost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
			}

			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}

		return cost[len0 - 1];
	}

	/**
	 * This method is to get percentage match of 2 strings.
	 * 
	 * @param source
	 *            - String
	 * @param target
	 *            - String
	 * @throws BaseException
	 * 
	 */
	public static double matchPercent(String source, String target) {
		double dif;

		if ((source == null) || (target == null))
			dif = 0.0;
		else if ((source.length() == 0) || (target.length() == 0))
			dif = 0.0;
		else if (source == target)
			dif = 1.0;
		else {
			int stepsToSame = levenshteinDistance(source.toLowerCase(), target.toLowerCase());
			dif = 1.0 - ((double) stepsToSame / (double) Math.max(source.length(), target.length()));
		}
		return dif * 100;
	}

}
