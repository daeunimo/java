package e;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		int gas = 20;
		car1.setGas(gas);
		boolean gasState=car1.isLeftGas(); 
		if(gasState) {
			System.out.println("����մϴ�.");
			car1.run();
		}
		
		if(car1.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		} else {
			System.out.println("gas�� �����ϼ���.");
		}
	}

}

class Car {
	//�ʵ�
	int gas;
	//������
	//�޼ҵ�
	void setGas(int gas) {
		this.gas=gas;
	}
	
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas�� �����ϴ�.");
			return false;
		}
		System.out.println("gas�� �ֽ��ϴ�");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("�޸��ϴ�.(gas�ܷ�:"+gas+")");
				gas-=1;	
			} else {
				System.out.println("����ϴ�.(gas�ܷ�:"+gas+")");
				return;
			}
		}
	}
}