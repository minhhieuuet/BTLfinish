    public class Rectangle extends Shape {
	private float height,width,x,y;

	public Rectangle(float height,float width,float x,float y) {
		super(RECTANGLE);
                this.height=height;
                this.width=width;
                this.x=x;
                this.y=y;
	}

   

	public void move(float x,float y) {
		this.x=x;
                this.y=y;
	}
        public int getType()
        {
            return 1;
        }
	
	
	public float getArea() {
			
		area = width*height;
		return area;
	}

	public String toString() {
		return "Rectangle : x="+x+" y= "+y+" width="+width+" height="+height + ", area=" + getArea()+" color: "+this.getColor();
	}

	public void showInfo() {
		System.out.println(toString());
	}

}
