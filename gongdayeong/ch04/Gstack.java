package ch04;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E [] stk;
	
	public class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {}
	}
	
	public class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {}
	}
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			// stk = (E[])Array.newInstance(clazz, capacity);
			stk = (E[])new Object[max]; // �ڷ����� ���� �ֻ��� Ŭ������ ����?
		} catch(OutOfMemoryError e) {
			// OutOfMemoryError : Heap size �������� java Object�� Heap�� �Ҵ����� ���ϴ� ���
			max = 0;
		}
	}
	
	public E push(E x) throws OverflowGstackException {
		if(ptr >= max)
			throw new OverflowGstackException();
		
		return stk[ptr++] = x;
	}
	
	public E pop() throws EmptyGstackException {
		if(ptr <= 0)
			throw new EmptyGstackException();
		
		return stk[--ptr];
	}
	
	// ����� ������ ���, ������� �ƴϹǷ� ptr �� ������x
	public E peek() throws EmptyGstackException {
		if(ptr <= 0)
			throw new EmptyGstackException();
		
		return stk[ptr-1];
	}
	
	public int indexOf(E x) {
		for(int i = ptr-1; i>=0; i--) {
			if(stk[i].equals(x)) // stk[i] == x�� �۵� ������
				return i;
		}
		
		return -1;
	}
	
	public void clear() {
		ptr = 0;
	}
	
	// ���� �뷮 ��ȯ
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr <= 0)
			System.out.println("������ ����ֽ��ϴ�.");
		else {
			for(int i=0; i<ptr; i++)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
}
