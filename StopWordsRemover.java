package com.codex.bot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ResourceUtils;

public class StopWordsRemover{

	public static String removeStopWords(String inputText) {
		HashSet<String> stopWords=readStopWordsFromFile();
		String stopWordsPattern = String.join("|", stopWords);
		Pattern pattern = Pattern.compile("\\b(?:" + stopWordsPattern + ")\\b\\s*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputText);
		return matcher.replaceAll("");
	}

	private static HashSet<String> readStopWordsFromFile() {
		HashSet<String> set=new HashSet<>();
		try {
			
			File file = ResourceUtils.getFile("classpath:stopwords.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				set.add(line);
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

}
