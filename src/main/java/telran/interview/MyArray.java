package telran.interview;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
	private T allValue;
	private HashMap<Integer, T> mapArray = new HashMap<>();
	private int size;
	public void setAll(T value) {
		//all array's elements should be set with a given value
		allValue = value;
		mapArray = new HashMap<>();
		
	}
	public void set(int index, T value) {
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
       checkIndex(index);
	   mapArray.put(index, value);	
	}
	
	public T get(int index) {
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		checkIndex(index);
		return mapArray.getOrDefault(index, allValue);
		
	}
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
	public MyArray(int size) {
		//creates the Array object for a given size
		//with setting null's at each element
		this.size = size;
	}
}
