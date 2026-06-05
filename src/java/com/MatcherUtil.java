package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
	
	public static PatternEnum getMatcherType(CharSequence input) {
		if (findMatches(PatternEnum.EMAIL, input)) {
			return PatternEnum.EMAIL;
		} else if (findMatches(PatternEnum.PHONE_NUMBER, input)) {
			return PatternEnum.PHONE_NUMBER;
		} else if (findMatches(PatternEnum.ENCRYPT, input)) {
			return PatternEnum.ENCRYPT;
		} else {
			return PatternEnum.NODEF;
		}
	}
	
	public static boolean findMatches(PatternEnum patternEnum, CharSequence input) {
		return findMatches(patternEnum.toPattern(), input);
	}
	
	public static boolean findMatches(Pattern pattern, CharSequence input) {
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}	
}
