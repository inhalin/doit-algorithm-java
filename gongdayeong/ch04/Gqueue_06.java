package ch04;

public class Gqueue_06<E> {
	// ������ �� ���ܣ�ť�� ��� ����
	public class EmptyGQueueException extends RuntimeException {
		public EmptyGQueueException() {
		}
	}

	// ������ �� ���ܣ�ť�� ���� ��
	public class OverflowGQueueException extends RuntimeException {
		public OverflowGQueueException() {
		}
	}

	private int max;
	private int num;
	private int front;
	private int rear;
	private E[] que;

	// ������
	public Gqueue_06(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E[]) new Object[max]; // ť ��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // ������ �� �����ϴ�.
			max = 0;
		}
	}

	// ť�� �����͸� ��ť
	public E enque(E x) throws OverflowGQueueException {
		if (num >= max)
			throw new OverflowGQueueException(); // ť�� ���� ��
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// ť���� �����͸� ��ť
	public E deque() throws EmptyGQueueException {
		if (num <= 0)
			throw new EmptyGQueueException(); // ť�� ��� ����
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// ť���� �����͸� ��ũ(�Ӹ������͸� ���캽)
	public E peek() throws EmptyGQueueException {
		if (num <= 0)
			throw new EmptyGQueueException(); // ť�� ��� ����
		return que[front];
	}

	// ť���� x�� �˻��Ͽ� index(ã�� ���ϸ� -1)�� ��ȯ
	public int indexOf(E x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x) // �˻�����
				return idx;
		}
		return -1; // �˻�����
	}

	// ť�� ���
	public void clear() {
		num = front = rear = 0;
	}

	// ť�� �뷮�� ��ȯ
	public int capacity() {
		return max;
	}

	// ť�� ���� ������ ���� ��ȯ
	public int size() {
		return num;
	}

	// ť�� ��� �ִ°�?
	public boolean isEmpty() {
		return num <= 0;
	}

	// ť�� ���� á�°�?
	public boolean isFull() {
		return num >= max;
	}

	// ť ���� ��(���͸� �Ӹ��沿���� ���ʷ� ��Ÿ��
	public void dump() {
		if (num <= 0)
			System.out.println("ť�� ������ϴ�.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
}
