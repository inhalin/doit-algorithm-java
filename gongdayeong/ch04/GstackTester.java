package ch04;
import java.util.Scanner;

public class GstackTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Gstack<String> s = new Gstack<String>(64);
		
		while(true) {
			System.out.println("���� ������ �� : "+s.size()+"/"+s.capacity());
			
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (0)���� : ");
			
			int menu = stdIn.nextInt();
			if(menu == 0) break;
			
			String x;
			switch(menu) {
			case 1:
				System.out.print("������:");
				x=stdIn.next();
				try {
					s.push(x);
				} catch (Gstack.OverflowGstackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
				
			case 2:
				try {
					x = s.pop();
					System.out.println("���� �����ʹ� " + x + "�Դϴ�.");
				}catch (Gstack.EmptyGstackException e) {
					System.out.println("������ ����̽��ϴ�.");
				}
				break;
				
			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				}catch (Gstack.EmptyGstackException e) {
					System.out.println("������ ����̽��ϴ�.");
				}
				break;
				
			case 4:
				s.dump();				
				break;
				
			case 5:
				System.out.print("������:");
				x=stdIn.next();
				int reslut=s.indexOf(x);
				if(reslut > 0)
					System.out.println("�˻� �������� �ε����� " + reslut + "�Դϴ�.");
				else
					System.out.println("�˻� �����Ͱ� �����ϴ�");
				break;
				
			case 6:
				s.clear();				
				break;
				
			case 7:
				if(s.isEmpty())
					System.out.println("�� ����");
				else
					System.out.println("���� ������ ����");
				break;
				
			case 8:
				if(s.isFull())
					System.out.println("���� ����");
				else
					System.out.println("���� �������� ����");
				break;
			}
		}

	}

}
