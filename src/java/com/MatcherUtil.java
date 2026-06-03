package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
	
	public enum PatternEnum {
		NODEF("^.*$"),
		ENCRYPT("(?<encData>\\$\\.[^=]+=)"),
		EMAIL("^(?<firstName>[A-Za-z0-9._%+-]+)@(?<lastName>[A-Za-z0-9.-]+\\.[A-Za-z]{2,})$"),
		PHONE_NUMBER("^(?<firstNumber>\\d{2,3})([.-])(?<secondNumber>\\d{3,4})\\2(?<lastNumber>\\d{4})$");
	
		private final String regex;
		
		private PatternEnum(final String regex) {
			this.regex = regex;
		}
		
		public Pattern toPattern() {
			return Pattern.compile(regex);
		}
	}
	
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
