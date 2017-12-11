public class Square extends Shape {
	private  float a, x, y;

	public Square(float a,float x,float y) {
		super(SQUARE);
		this.x=x;
                this.y=y;
                this.a=a;
	}

	
	
	public void move(float x,float y) {
		this.x=x;
                this.y=y;
	}

	public float getArea() {
		area = (float)x*y;
		return area;
	}

	public String toString() {
		return "Square: x= "+x+" y="+y+" width="+a + ", area=" + getArea()+" color: "+this.getColor();
	}

	public void showInfo() {
		System.out.println(toString());
	}

}
