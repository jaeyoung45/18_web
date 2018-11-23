package chap04;

public class Baby {
	String name;
	int age;
	
	//¿ô´Â´Ù
	public void smile() {
		System.out.println("¿ô´Â´Ù");
	}
	//¿î´Ù.
	public void cry() {
		System.out.println("¿î´Ù");
	}
	
	
	public static void main(String[] args) {
		Baby b1 = new Baby();
		b1.smile();
		b1.name="È«±æµ¿";
		System.out.println(b1.name);

	}

}
