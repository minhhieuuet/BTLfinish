public class Triangle extends Shape {
	private float x1, y1, x2, y2, x3, y3;
	
	public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
		super(TRIANGLE);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	public void move(float x1, float y1, float x2, float y2, float x3, float y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	
	
	public float getArea() {
		area = (float)Math.abs(((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1))/2);
		return area;
	}

	public String toString() {
		return "Triangle: x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2="+ y2 + ", x3=" + x3 + ", y3=" + y3 + " area=" +getArea()+" color: "+this.getColor();
	}

	public void showInfo() {
		System.out.println(toString());
	}
}
