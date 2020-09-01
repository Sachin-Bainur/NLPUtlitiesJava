/**
 * 
 */
package com.codex.bot.util;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * @author Sachin Bainur<br/>
 *         Created On: 09-May-2018 6:16:57 PM
 */
public class ValueComparator implements Comparator<Entry<String, Double>> {

	private boolean order;

	public ValueComparator(boolean isDescending) {
		this.order = isDescending;
	}

	public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {

		if (order) {
			return o1.getValue().compareTo(o2.getValue());
		} else {
			return o2.getValue().compareTo(o1.getValue());
		}

	}

}
