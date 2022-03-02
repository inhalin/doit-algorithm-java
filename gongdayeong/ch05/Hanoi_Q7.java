package ch05;

import java.util.Scanner;
import java.util.Stack;

// ��� Ǯ���٤Ф�
public class Hanoi_Q7 {
	private static void move(int no, int x, int y) {
		Stack<Integer> nstack = new Stack<Integer>();
		Stack<Integer> xstack = new Stack<Integer>();
		Stack<Integer> ystack = new Stack<Integer>();
		
		Stack<Integer> sstack = new Stack<Integer>();
		
		int sw = 0;
		
		while(true) {
			if(no > 1 && sw == 0) {
				nstack.push(no);
				xstack.push(x);
				ystack.push(y);
				sstack.push(sw);
				
				no = no-1;
				y = 6-x-y;
				
				continue;
			}
			
			if(no == 1 && sw == 0) { // no=1 �� ���, ���ÿ� �����ʰ� �ٷ� ���
				System.out.println("����["+no+"]�� "+x+"��տ��� "+y+"������� �ű�");
				sw = 1;
				
				continue;
			} else if(nstack.isEmpty() != true) { // no>1 �� ���, ���ÿ� ���� ������ pop�Ͽ� ���
				no = nstack.pop();
				x = xstack.pop();
				y = ystack.pop();
				sw = sstack.pop()+1;
				
				System.out.println("����["+no+"]�� "+x+"��տ��� "+y+"������� �ű�");
			}
			
			if(no > 1 && sw == 1) {
				no = no-1;
				x = 6-x-y;
				
				sw = 0;
				continue;
			}
			
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ϳ����� ž");
		System.out.print("���� ���� : ");
		int n = stdIn.nextInt();
		
		move(n,1,3);
	}
}
