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
        Pattern elemPattern = Pattern.compile("\\s*[\\d\\+\\-\\*/]");

        while (sc.hasNext(elemPattern)) {
        	String character = sc.next(elemPattern).trim();
        	
        	if(character.matches("\\d")) {
        		queue.offer(character);
        	} else {
        		if(stack.isEmpty() || stack.contains("(") ||  OpUtil.lowerPrecedence(stack.peek(),character) ) {
        			stack.push(character);
        		} else {
        			while(OpUtil.higherPrecedence(stack.peek(),character)) {
        				String opFromStack = stack.pop();
        				if(!(opFromStack == "(")) { 
        					queue.offer(opFromStack);
        				}
        			}
        			if(character != ")") {
        				stack.push(character);
        			}
        		}
        	}
        	
        } // Ende der Eingabe

        while(!stack.isEmpty()) {
        	String opFromStack = stack.pop();
        	if(opFromStack != ")") {
        		queue.offer(opFromStack);
        	}
        }
        	
         
        sc.close();
        return queue;
	}
}
