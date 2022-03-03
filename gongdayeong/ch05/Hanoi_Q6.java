package ch05;

import java.util.Scanner;

// 05-3 �ϳ����� ž
// �ʹ��ʹ� ��ƴ�.. ��� ��ü�� �򰥸��µ� �ϳ����� ž ��Ģ���� �����ؼ� �����Ϸ��� ���ǳ� �򰥷ȴ�

public class Hanoi_Q6 {
	private static void move(int no, int x, int y) {
		// ���
		char[] arr = {'A','B','C'};
		
		if(no > 1)
			move(no-1, x, 6-x-y);
		
		System.out.println("����["+no+"]�� "+arr[x-1]+"��տ��� "+arr[y-1]+"������� �ű�");
		
		if(no > 1)
			move(no-1, 6-x-y, y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ϳ����� ž");
		System.out.print("���� ���� : ");
		int n = stdIn.nextInt();
		
		move(n,1,3);
	}
}
