package collectione;

import java.util.ArrayList;
import java.util.Arrays;

public class OpUtil {
	
	private static ArrayList<String> list = new ArrayList<>(Arrays.asList("(","/","*","-","+",")"));

	static boolean lowerPrecedence(String op1, String op2) {
		int firstElemPos = list.indexOf(op1);
		int secondElemPos = list.indexOf(op2);
		return firstElemPos > secondElemPos;

	}
	
	static boolean higherPrecedence(String op1, String op2) {
		return lowerPrecedence(op2,op1);
	}
	
}
