package sec02.exam01;

public class Car {
	// 필드
	String company;
	String model;
	String color;
	int maxSpeed;

	public Car() {
		System.out.println("Car()");
	}

	public Car(String str) {
		company = str;
	}

	public Car(String str, String str1) {
		company = str;
		model = str1;
	}

	public Car(String company, String model, String color, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;

	}

	public Car(String company, int maxSpeed) {
		super();
		this.company = company;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

}
