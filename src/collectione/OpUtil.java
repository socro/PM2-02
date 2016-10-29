package collectione;

import java.util.ArrayList;
import java.util.Arrays;

public class OpUtil {
	
	private static ArrayList<String> list = new ArrayList<>(Arrays.asList("(","/","*","-","+",")"));

	static boolean lowerPrecedence(String op1, String op2) {
		if(op1.equals(null) || op2.equals(null)){
			return false;
		}
		int firstElemPos = list.indexOf(op1);
		int secondElemPos = list.indexOf(op2);
		if(firstElemPos > secondElemPos) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean higherPrecedence(String op1, String op2) {
		return lowerPrecedence(op2,op1);
	}
	
}
