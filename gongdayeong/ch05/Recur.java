package ch05;

import java.util.Scanner;

public class Recur {

	static void recur(int n) {
		if(n > 0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		
		recur(x);
	} 

}

// �ҽ� �����, ����� �м�
// stack ������ ����
// �ϴٺ��ϱ�.. ����Լ��� �ڱ� �ڽ� 1,2,3,..n�� ��� ȣ�� �� �� n��°���� �ٽ� �Ųٷ� �ö���� �����ε�..?
// �׷��� stack ������ ������ ����..?

// ����Լ��� ���ÿ� ���̴°Ŷ� �޸𸮺��� �߻��� �� ����
// �̸� �����ϱ� ���� ���� ��� ���� �ʿ� -> ���� �����Ϸ����� ���� ��� ����ȭ�� ����
// ��� �Լ��� ����Ҷ� ���� ��� ����ȭ�� �����ϴ� ���� ����ϴ°� ����