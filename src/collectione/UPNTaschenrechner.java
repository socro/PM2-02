package collectione;

import java.nio.charset.MalformedInputException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class UPNTaschenrechner {

	public static void main(String[] args) throws MalformedInputException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben sie einen arithmetischen Ausdruck ein (mit Leerzeichen trennen):");
		while (sc.hasNextLine()) {
			String inputInfix = sc.nextLine(); // blocking bis User Enter
												// drückt
			String inputUPN = String.join(" ", InfixToUPN.process(inputInfix));
			Double result = process(inputUPN);
			System.out.println("Result: " + result);
		}
		sc.close();
	}

	public static Double process(String line) throws MalformedInputException {
		Stack<Double> stack = new Stack<>();
		Scanner sc = new Scanner(line);
		Pattern elemPattern = Pattern.compile("\\s*(:?\\d*||[\\+\\-\\*\\/])");

		while (sc.hasNext(elemPattern)) {
			String character = sc.next(elemPattern).trim();

			if (character.matches("\\d*")) {
				Double digit = Double.valueOf(character);
				stack.push(digit);
			} else {
				Double firstOperant = Double.valueOf(stack.pop());
				Double secondOperant = Double.valueOf(stack.pop());
				Double result;
				switch (character) {
				case ("+"):
					result = firstOperant + secondOperant;
					break;
				case ("-"):
					result = secondOperant - firstOperant;
					break;
				case ("*"):
					result = firstOperant * secondOperant;
					break;
				case ("/"):
					result =  secondOperant / firstOperant ;
					break;
				default:
					throw new MalformedInputException(character.length());

				}
				stack.push(result);
			}
		}
		sc.close();

		return stack.peek();
	}
}
