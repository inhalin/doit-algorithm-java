package ch05;

import java.util.Scanner;
import java.util.Stack;
//�޼ҵ� recur3�� �����������

public class Recur_Q5 {
	// �޼ҵ� recur�� ������� ����
	static void recur3(int n) {
		Stack<Integer> nstk = new Stack<Integer>();
		Stack<Integer> sstk = new Stack<Integer>();
		int sw = 0;

		// sw ������ ��͹ݺ� �Ϸ� �ܰ� ����
		// sw=0 : ��� ��͹��� ������� ����
		// sw=1 : ù��° ��͹� recur3(n-1) ó�� �Ϸ�
		// sw=2 : �ι��� ��͹� recur3(n-2) ó�� �Ϸ� 
		while (true) {
			if (n > 0) {
				nstk.push(n);
				sstk.push(sw);

				if (sw == 0)
					n = n - 1;
				else if (sw == 1) {
					n = n - 2;
					sw = 0; // n-1 ���� �����ϱ� ����
				}
				continue;
			}
			
			do {
				n = nstk.pop();
				sw = sstk.pop() + 1;

				if (sw == 2) {
					System.out.println(n);
					if (nstk.isEmpty())
						return;
				}
			} while (sw == 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		int x = stdIn.nextInt();

		recur3(x);
	}

}
