package lintcode;

import java.util.Stack;

public class MinStack {

	public Stack<Integer> s;
	public Stack<Integer> sm;
	
	public MinStack() {
		this.s = new Stack<Integer>();
		this.sm = new Stack<Integer>();
	}

	/*
	 * @param number: An integer
	 * 
	 * @return: nothing
	 */
	public void push(int number) {
	    if(sm.size() == 0){
			sm.push(number);
			s.push(number);
			return;
		}
		int min = sm.peek();
		if(number <= min){
			sm.push(number);
		}else{
		    sm.push(min);
		}
		s.push(number);
	}

	/*
	 * @return: An integer
	 */
	public int pop() {
		sm.pop();
		return s.pop();
		// write your code here
	}

	/*
	 * @return: An integer
	 */
	public int min() {
		return sm.peek();
		// write your code here
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
