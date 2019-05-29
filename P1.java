package e;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		int gas = 20;
		car1.setGas(gas);
		boolean gasState=car1.isLeftGas(); 
		if(gasState) {
			System.out.println("출발합니다.");
			car1.run();
		}
		
		if(car1.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}

}

class Car {
	//필드
	int gas;
	//생성자
	//메소드
	void setGas(int gas) {
		this.gas=gas;
	}
	
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다.(gas잔량:"+gas+")");
				gas-=1;	
			} else {
				System.out.println("멈춥니다.(gas잔량:"+gas+")");
				return;
			}
		}
	}
}