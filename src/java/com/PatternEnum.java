package com;

import java.util.regex.Pattern;

public enum PatternEnum {
	NODEF("^(?<allData>.*)$"),
	ENCRYPT("(?<encData>\\$\\.[^=]+={0,})"),
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
