package DTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassSupport {
	public static String findText(String text, String regex) {
		Pattern pt = Pattern.compile(regex);
		Matcher mc = pt.matcher(text);
		String result = "";
		while (mc.find()) {
			result = mc.group(1);
		}
		return result;
	}

	public static boolean checkText(String text, String regex) {
		return text.matches(regex);
	}

	public static int getIntFromString(String text) {
		return Integer.parseInt(findText(text, "(\\d+)"));
	}
}
