package ds.stack;

public class Stack<E> {
	
	private int maxSize;
	private Object[] stackArray;
	private int top;
	
	Stack(int size){
		this.maxSize = size;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}
	
	public void push(E j){
		if(isFull()) {
			System.out.println("Stack overflow..");
		}else{
			top++;
			stackArray[top] = j;
		}
		
	}
	
	public Object pop(){
		if(isEmpty()){
			System.out.println("Stack underflow...");
			return "0";
		}else{
			int oldTop = top;
			top--;
			return stackArray[oldTop];
		}
		
	}
	
	public Object peak(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (maxSize-1 == top);
	}
}
