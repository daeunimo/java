
package phoneBookProgram;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// �ٽ� ������ �޸� ����...
		// String [][] arrData = new String [100][3];
		// ���� ��ġ�� �ٸ��� ������ ���߹迭�� �������� ����
		String[] arrName = new String[100];
		String[] arrNumber = new String[100];
		String[] arrBirth = new String[100];
		int indexCount = 0;

		System.out.println("��ȭ��ȣ�� ���α׷��� ���Ű� ȯ���մϴ�!");

		while (true) {
			System.out.println("===�޴�===");
			System.out.println("1. ��ȭ��ȣ �Է�");
			System.out.println("2. ��ü ����Ʈ ���");
			System.out.println("3. �˻�");
			System.out.println("4. ��ȭ��ȣ ����");
			System.out.println("5. ��ȭ��ȣ ����");
			System.out.println("�Է� (����=q)>");

			String inputValue = scn.nextLine(); //���� �Է¹���

			if (inputValue.equals("q")) {
				System.out.println("���α׷��� ����˴ϴ�.");
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			}

			if (inputValue.equals("1")) {
				// �Է·���...
				System.out.println("===�Է� ����===");
				System.out.print("�̸� �Է�>");
				String name = scn.nextLine();
				System.out.print("��ȣ �Է�>");
				String number = scn.nextLine();
				System.out.print("���� �Է�>");
				String birth = scn.nextLine();
				
				if(indexCount>=arrName.length) {
					// arrName= new String [arrName.length*2] // �����迭�� ������� ����
					// �迭�� �� �� �÷��� �����ϱ�...
					String [] tempArrName = new String [arrName.length*2];
					String [] tempArrNumber = new String [arrNumber.length*2];
					String [] tempArrBirth = new String [arrBirth.length*2];
					for (int i=0; i<arrName.length; i++) {
						tempArrName[i]=arrName[i];
						tempArrNumber[i]=arrNumber[i];
						tempArrBirth[i]=arrBirth[i];
						
					}
					
					//���� �迭 �Ҹ� 
					arrName=tempArrName;
					arrNumber=tempArrNumber;
					arrBirth=tempArrBirth;
					
				}
				arrName[indexCount] = name;
				arrNumber[indexCount] = number;
				arrBirth[indexCount] = birth;

				indexCount++;

				System.out.println("===�Է��� �Ϸ�Ǿ����ϴ�.===");

				System.out.println("===��� �Ͻ÷��� enter...===");
				scn.nextLine();

			} else if (inputValue.equals("2")) {
				// ��ü ����Ʈ ���
				System.out.println("=== ����Ʈ ���===");
				for (int i = 0; i < indexCount; i++) {
					System.out.println("�̸�: " + arrName[i] + ", ��ȣ: " + arrNumber[i] + ", ����: " + arrBirth[i]);

				} 
				System.out.println("===��� �Ͻ÷��� enter...===");
				scn.nextLine();

			} else if (inputValue.equals("3")) {
				//�˻�
				System.out.println("===�˻� ����===");
				System.out.println("�˻��� ����� �̸��� �Է��ϼ���.");
				System.out.print("�Է�>");
				
				String name= scn.nextLine();
				boolean isSearched=false;
			
				for (int i=0; i<indexCount; i++) {
					if (arrName[i].equals(name)) {
						System.out.println("�̸�: " + arrName[i] + ", ��ȣ: " + arrNumber[i] + ", ����: " + arrBirth[i]);
						isSearched=true;
					}
				}	
				if(isSearched==false) {
					System.out.println("�˻��� ����� �����ϴ�.");
				}

				System.out.println("===��� �Ͻ÷��� enter...===");
				scn.nextLine();
					
			} else if (inputValue.equals("4")) {
				//����
				System.out.println("===���� ����===");
				System.out.println("������ �̸��� �Է��ϼ���.");
				System.out.print("�Է�>");
				
				String name= scn.nextLine();
				
				for (int i=0; i<indexCount; i++) { //���⿡ -1�� �ϸ� ������ �̸� ���� �Ұ�
					if (arrName[i].equals(name)) {
						/* ���� ��� _ null�� �ٲٰų�(�޸𸮸� ����, ���� ó�� �ʿ�) 
						 �ڿ� ���� ���� �� ĭ�� ������ ����(�����Ͱ� ���� ��� ������ �ʹ� ������) _�迭�� ����
						*/ //���� ����
						
						for (int j=i; j<indexCount-1; j++) {  //������ �ε����� �Ѿ�� ���� ����
							arrName[j]=arrName[j+1];
							arrNumber[j]=arrNumber[j+1];
							arrBirth[j]=arrBirth[j+1];
						}
						
						arrName[indexCount]=null;
						arrNumber[indexCount]=null;
						arrBirth[indexCount]=null;
						
						indexCount--; // �� ���� ������, null���� ��µǸ�, �� �߿� ���� �߰��� �� null�� ������ �޸𸮿� ���� ��.
						
					}
				}
				
				System.out.println("===���� �Ϸ�===");
				System.out.println("===��� �Ͻ÷��� enter...===");
				scn.nextLine();
				
			} else if (inputValue.equals("5")) {

			} else {

				break;
			}

		}
	}

}
