package ch04;

public class IntDeque_07 {
	private int max; // ť�� �뷮
	private int frontA; // �� �� Ŀ��
	private int rearA; // �� �� Ŀ��
	private int frontB; // �� �� Ŀ��
	private int rearB; // �� �� Ŀ��
	private int num; // ������ ������ ��
	private int[] que; // ť�� ��ü

	// ������ �� ���ܣ�ť�� ��� ����
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// ������ �� ���ܣ�ť�� ���� ��
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}

	// ������
	public IntDeque_07(int capacity) {
		num = frontA = rearA  = frontB = rearB = 0;
		max = capacity;
		try {
			que = new int[max]; // ť ��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // ������ �� �����ϴ�.
			max = 0;
		}
	}

	// ť�� �����͸� ��ť
	public int enque(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // ť�� ���� ��
		que[rearA++] = x;
		num++;
		if (rearA == max)
			rearA = 0;
		return x;
	}

	// ť���� �����͸� ��ť
	public int deque() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // ť�� ��� ����
		int x = que[frontB++];
		num--;
		if (frontB == max)
			frontB = 0;
		return x;
	}

	// ť���� �����͸� ��ũ(�Ӹ������͸� ���캽)
	public int peek() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // ť�� ��� ����
		return que[front];
	}

	// ť���� x�� �˻��Ͽ� index(ã�� ���ϸ� -1)�� ��ȯ
	public int indexOf(int x) {
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

	public int search(int x) {
		int index = 0;

		for (int i = 0; i <= num; i++) {
			index = (i + front) % max;

			if (que[index] == x)
				return i + 1;
		}

		return 0;
	}
}
