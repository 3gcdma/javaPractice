import java.util.Arrays;

public class Mystack {
	private final int CAPACITY = 5;
	private int[] data = new int[CAPACITY];
	private int top = -1;
	
	
	public int getData() {
		int num = data[top];
		data[top] = 0;
		top--;
		return num;
	}
	public void setData(int data) {
		this.data[++top] = data;
	}
	
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	public int getCAPACITY() {
		return CAPACITY;
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
}
