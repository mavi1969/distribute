package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
	
	public void runTest() {
//		checkEmail();
//		checkPhoneNumber();
//		checkEncrypt();
		
		testMatcher();
	}
	
	public void testMatcher() {
		//String input = "abc@samsung.co.kr";
		//String input = "02.1234.5678";
		
		//String input = "가나다라@마바사";
		String input = "$.dasfasfsdafdsafsd==@samsung.co.kr$.dasfasfsdafdsafsd=";
		//String input = "02.1234.$.dasfasfsdafdsafsd=";
		PatternEnum patternEnum = MatcherUtil.getMatcherType(input);
		Matcher matcher = patternEnum.toPattern().matcher(input);
		if (patternEnum == PatternEnum.EMAIL) {
			if (matcher.find()) {
				System.out.println("firstName:" + matcher.group("firstName"));
				System.out.println("lastName:" + matcher.group("lastName"));				
			} else {
				System.out.println("Pattern not found");
			}
		} else if (patternEnum == PatternEnum.PHONE_NUMBER) {
			if (matcher.find()) {
				System.out.println("firstNumber:" + matcher.group("firstNumber"));
				System.out.println("secondNumber:" + matcher.group("secondNumber"));
				System.out.println("lastNumber:" + matcher.group("lastNumber"));				
			} else {
				System.out.println("Pattern not found");
			}
		} else if (patternEnum == PatternEnum.ENCRYPT) {
			
			while (matcher.find()) {
	            input = input.replace(matcher.group("encData"), "abc");
	        }	        
	        System.out.println(input);
	        
		} else {
			if (matcher.find()) {
				System.out.println("allData:" + matcher.group("allData"));
			} else {
				System.out.println("Pattern not found");
			}
		}
	}
	
	public void checkEmail() {
		Pattern pattern = PatternEnum.EMAIL.toPattern();		
		Matcher matcher = pattern.matcher("abc@samsung.co.kr");
		
		if (matcher.find()) {
			System.out.println("firstName:" + matcher.group("firstName"));
			System.out.println("lastName:" + matcher.group("lastName"));
		} else {
			System.out.println("Pattern not found");
		}
	}
	
	public void checkPhoneNumber() {
		Pattern pattern = PatternEnum.PHONE_NUMBER.toPattern();
		Matcher matcher = pattern.matcher("02.1234.5678");
		
		if (matcher.find()) {
			System.out.println("firstNumber:" + matcher.group("firstNumber"));
			System.out.println("secondNumber:" + matcher.group("secondNumber"));
			System.out.println("lastNumber:" + matcher.group("lastNumber"));			
		} else {
			System.out.println("Pattern not found");
		}
	}
	
	public void checkEncrypt() {
		
		String checkData = "암호화복호화$.dasfasfsdafdsafsd=1234$.asdfasfsdafdsafsd=abcdefg암호화복호화";
		Pattern pattern = PatternEnum.ENCRYPT.toPattern();
		Matcher matcher = pattern.matcher(checkData);
		
		if (matcher.find()) {
			matcher.reset();
			
	        String decValue = checkData;
	
	        int count = 0;
	        while (matcher.find()) {
	            count++;
	            System.out.println("패턴 발견 시작 위치: " + matcher.start());
	            System.out.println("패턴 발견 종료 위치: " + matcher.end());
	            System.out.println("패턴 데이타: " + matcher.group("encData"));
	            
	            decValue = decValue.replace(matcher.group("encData"), "홍길동");
	        }
	        
	        System.out.println(decValue);
	        System.out.println("총 반복 횟수: " + count);
		} else {
			System.out.println("Pattern not found");
		}
	}
	
	public static void main(String[] args) {		
		MatcherTest matcherTest = new MatcherTest();
		matcherTest.runTest();
	}

}
