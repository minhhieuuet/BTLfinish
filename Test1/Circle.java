public class Circle extends Shape {
	private float x, y, R;
	//Khoi tao Circle
	public Circle(float x, float y, float R) {
		super(CIRCLE);
		this.x = x;
		this.y = y;
		this.R = R;
	}
        //Di chuyen Circle
	public void move(float x, float y) {
		this.x = x;
		this.y = y;
	}
       
	
	//Lay dien tich
	public float getArea() {
		area = (float)Math.PI * R * R;
		return area;
	}

	public String toString() {
		return "Circle: x=" + x + ", y=" + y + ", R=" + R + ", area=" + getArea()+" color: "+this.getColor();
	}
        //Lay info
	public void showInfo() {
		System.out.println(toString());
	}

}
