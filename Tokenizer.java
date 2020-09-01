package com.codex.bot.util;

import java.util.ArrayList;
import java.util.List;

import com.codex.framework.exception.BaseException;

/**
 * 
 * @author Sachin Bainur
 * @copyright Copyright (c) All Right Reserved.
 * @date 20-feb-2018
 */
public class Tokenizer {

	/**
	 * This method get tokens out of query
	 * 
	 * @param que
	 *            - User Query
	 * @throws BaseException
	 * 
	 */
	private Tokenizer() {

	}


	public static String[] getFeatureTokens(String query,String[] allFeatures){
		String[] queSplit = query.toLowerCase().split("[ .,!?]");
		List<String> tokenList=new ArrayList<>(); 
		for (String questionWords : queSplit) {
			for (String index : allFeatures) {
				if((PercentageMatch.matchPercent(questionWords, index) > 50.0)) {
					tokenList.add(index);
				}						
			}
			
		}
		if(tokenList.isEmpty())
			return allFeatures;
		return tokenList.stream()
				 .toArray(String[]::new);
	}

}
