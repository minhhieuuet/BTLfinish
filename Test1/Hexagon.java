
public class Hexagon extends Shape {
    private float x, y, n;
    //Khoi tao Hexagon
	public Hexagon(float x, float y, float n) {
		super(HEXAGON);
		this.x = x;
		this.y = y;
		this.n = n;
	}
        //Di chuyen
	public void move(float x, float y) {
		this.x = x;
		this.y = y;
	}
        
	//Lay dien tich
	public float getArea() {
		area = (float)Math.round((3*Math.sqrt(3)/2)*n*n*100)/100;
		return area;
	}

	public String toString() {
		return "Hexagon: x=" + x + ", y=" + y + ", n=" + n + ", area=" + getArea()+" color: "+this.getColor();
	}

	public void showInfo() {
		System.out.println(toString());
	}

}
