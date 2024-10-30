package telran.interview;

import java.util.*;

//All methods should have complexity O[1]
public class MyStackInt {
   private LinkedList<Integer> numbers = new LinkedList<>();
   private LinkedList<Integer> maxNumbers = new LinkedList<>();
	public void push(int num) {
		//adds num into top of stack (last element)
		numbers.addLast(num);
		if(maxNumbers.isEmpty() || num >= maxNumbers.getLast()){
			maxNumbers.addLast(num);
		}
	}
	public int pop() {
		//removes element from top of stack (last element)
		//returns being removed number
		//throws exception if the stack is empty
		checkEmpty();
		int res = numbers.removeLast();
		if(res == maxNumbers.getLast()) {
			maxNumbers.removeLast();
		}
		return res;
	}
	private void checkEmpty() {
		if(numbers.isEmpty()) {
			throw new EmptyStackException();
		}
	}
	public int peek() {
        checkEmpty();
		return numbers.getLast();
	}
	public boolean isEmpty() {
        return numbers.isEmpty();
	}
	public int getMaxElement() {
		//returns the max number from the stack
		//throws exception if the stack is empty
		checkEmpty();
		return maxNumbers.getLast();
	}
}
