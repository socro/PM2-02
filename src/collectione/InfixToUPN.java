package collectione;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;


public class InfixToUPN {

	public static Queue<String> process(String line) {

        Queue<String> queue = new LinkedBlockingQueue<>();
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(line);
        
        // Ziffern und Operatoren sollen durch Leerzeichen getrennt werden
        Pattern elemPattern = Pattern.compile("\\s*[\\d\\+\\-\\*\\/\\(\\)]");
        System.out.println("We are trying to understand: " + line);
        while (sc.hasNext(elemPattern)) {
        	String character = sc.next(elemPattern).trim();
        	System.out.println("Currently working on: " + character);
        	
        	if(character.matches("\\d")) {
        		queue.offer(character);
        		System.out.println("In the queue: " + character);
        	} else {
        		if(stack.isEmpty() || stack.peek().equals("(") ||  OpUtil.lowerPrecedence(stack.peek(),character) ) {
        			stack.push(character);
        			System.out.println("On the stack: " + character);
        		} else {
        			while(!stack.isEmpty() && OpUtil.higherPrecedence(stack.peek(),character)) {
        				String opFromStack = stack.pop();
        				if(!(opFromStack.equals("("))) { 
        					queue.offer(opFromStack);
        					System.out.println("In the queue: " + opFromStack);
        				}
        			}
        			if(!character.equals(")")) {
        				stack.push(character);
        				System.out.println("In the queue: " + character);
        			}
        		}
        	}
        	
        } // Ende der Eingabe

        while(!stack.isEmpty()) {
        	String opFromStack = stack.pop();
        	if(!opFromStack.equals(")")) {
        		queue.offer(opFromStack);
        	}
        }
        	
         
        sc.close();
        return queue;
	}
}
