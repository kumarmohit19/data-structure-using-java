package adt;

public class Counter {
	
	private int count;
	private String name;
	
	Counter(String str){
		name = str;
		count = 0;
	}
	
	public int getCurrentValue(){
		return count;
	}
	
	public void increment(){
		count++;
	}
	
	public String toString(){
		return Integer.toString(count);
	}

}
