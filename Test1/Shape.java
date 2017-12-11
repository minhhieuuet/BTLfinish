public class Shape {
        
	public static int RECTANGLE = 1;
	public static int SQUARE = 2;
	public static int TRIANGLE = 3;
	public static int CIRCLE = 4;
	public static int HEXAGON=5;
	
        
        private int type;
	private String color="blue";
	protected float area;
	
	public Shape(int type) {
		this.type = type;
		
	}

	

	public int getType() {
		return this.type;
	}

	public String getColor() {
		return this.color;
	}

	public void move() {
		
	}
	
	public void fillColor(String color) {
		this.color=color;
	}
	
	
	
	public float getArea() {
		return area;
	}
	
        
	public void showInfo() {
		
	}
}
