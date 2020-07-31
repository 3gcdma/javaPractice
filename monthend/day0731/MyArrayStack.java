import java.util.Arrays;

public class MyArrayStack {
	
	Mystack ms = new Mystack();

	
	public boolean isFull() {
		if(ms.getTop() == ms.getCAPACITY() -1) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if(ms.getTop() == -1) {
			return true;
		}
		return false;
	}

	public void push(int nextInt) {
		ms.setData(nextInt);
	}

	public int pop() {
		return ms.getData();
	}

	@Override
	public String toString() {
		return ms.toString();
		
	}


}
