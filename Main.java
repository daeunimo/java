
package phoneBookProgram;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// 핵심 데이터 메모리 생성...
		// String [][] arrData = new String [100][3];
		// 값의 가치가 다르기 때문에 이중배열로 생성하지 않음
		String[] arrName = new String[100];
		String[] arrNumber = new String[100];
		String[] arrBirth = new String[100];
		int indexCount = 0;

		System.out.println("전화번호부 프로그램에 오신걸 환영합니다!");

		while (true) {
			System.out.println("===메뉴===");
			System.out.println("1. 전화변호 입력");
			System.out.println("2. 전체 리스트 출력");
			System.out.println("3. 검색");
			System.out.println("4. 전화번호 삭제");
			System.out.println("5. 전화번호 수정");
			System.out.println("입력 (종료=q)>");

			String inputValue = scn.nextLine(); //값을 입력받음

			if (inputValue.equals("q")) {
				System.out.println("프로그램이 종료됩니다.");
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}

			if (inputValue.equals("1")) {
				// 입력로직...
				System.out.println("===입력 시작===");
				System.out.print("이름 입력>");
				String name = scn.nextLine();
				System.out.print("번호 입력>");
				String number = scn.nextLine();
				System.out.print("생년 입력>");
				String birth = scn.nextLine();
				
				if(indexCount>=arrName.length) {
					// arrName= new String [arrName.length*2] // 기존배열이 사라지는 문제
					// 배열을 두 배 늘려서 복사하기...
					String [] tempArrName = new String [arrName.length*2];
					String [] tempArrNumber = new String [arrNumber.length*2];
					String [] tempArrBirth = new String [arrBirth.length*2];
					for (int i=0; i<arrName.length; i++) {
						tempArrName[i]=arrName[i];
						tempArrNumber[i]=arrNumber[i];
						tempArrBirth[i]=arrBirth[i];
						
					}
					
					//기존 배열 소멸 
					arrName=tempArrName;
					arrNumber=tempArrNumber;
					arrBirth=tempArrBirth;
					
				}
				arrName[indexCount] = name;
				arrNumber[indexCount] = number;
				arrBirth[indexCount] = birth;

				indexCount++;

				System.out.println("===입력이 완료되었습니다.===");

				System.out.println("===계속 하시려면 enter...===");
				scn.nextLine();

			} else if (inputValue.equals("2")) {
				// 전체 리스트 출력
				System.out.println("=== 리스트 출력===");
				for (int i = 0; i < indexCount; i++) {
					System.out.println("이름: " + arrName[i] + ", 번호: " + arrNumber[i] + ", 생년: " + arrBirth[i]);

				} 
				System.out.println("===계속 하시려면 enter...===");
				scn.nextLine();

			} else if (inputValue.equals("3")) {
				//검색
				System.out.println("===검색 시작===");
				System.out.println("검색할 대상의 이름을 입력하세요.");
				System.out.print("입력>");
				
				String name= scn.nextLine();
				boolean isSearched=false;
			
				for (int i=0; i<indexCount; i++) {
					if (arrName[i].equals(name)) {
						System.out.println("이름: " + arrName[i] + ", 번호: " + arrNumber[i] + ", 생년: " + arrBirth[i]);
						isSearched=true;
					}
				}	
				if(isSearched==false) {
					System.out.println("검색된 결과가 없습니다.");
				}

				System.out.println("===계속 하시려면 enter...===");
				scn.nextLine();
					
			} else if (inputValue.equals("4")) {
				//삭제
				System.out.println("===삭제 시작===");
				System.out.println("삭제할 이름을 입력하세요.");
				System.out.print("입력>");
				
				String name= scn.nextLine();
				
				for (int i=0; i<indexCount; i++) { //여기에 -1을 하면 마지막 이름 삭제 불가
					if (arrName[i].equals(name)) {
						/* 삭제 방법 _ null로 바꾸거나(메모리를 버림, 예외 처리 필요) 
						 뒤에 오는 값을 한 칸씩 앞으로 복사(데이터가 많을 경우 연산이 너무 많아짐) _배열의 단점
						*/ //후자 로직
						
						for (int j=i; j<indexCount-1; j++) {  //마지막 인덱스를 넘어가는 것을 방지
							arrName[j]=arrName[j+1];
							arrNumber[j]=arrNumber[j+1];
							arrBirth[j]=arrBirth[j+1];
						}
						
						arrName[indexCount]=null;
						arrNumber[indexCount]=null;
						arrBirth[indexCount]=null;
						
						indexCount--; // 를 하지 않으면, null값이 출력되며, 나 중에 값을 추가할 때 null값 이후의 메모리에 값이 들어감.
						
					}
				}
				
				System.out.println("===삭제 완료===");
				System.out.println("===계속 하시려면 enter...===");
				scn.nextLine();
				
			} else if (inputValue.equals("5")) {

			} else {

				break;
			}

		}
	}

}
