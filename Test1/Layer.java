public class Layer {
	private final int MAX_SHAPE = 50;
        
	public Shape[] shapes;
	protected int countShape;
        boolean visible = true;
	//Khoi tao Layer
	public Layer() {
		shapes = new Shape[MAX_SHAPE];
		countShape = 0;
	}
        
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
        //Lay visible
	public boolean getVisible() {
		return this.visible;
	}
        //Them shape
	public void addShape(Shape shape) {
		if (countShape >= MAX_SHAPE) {
			return;
		}
		shapes[countShape] = shape;
                countShape++;
	}
        //Xoa shape
	public void deleteShape(int index) {
		if (countShape == 0) {
			return;
		}
		for (int i=index; i<countShape; i++) {
			shapes[i] = shapes[i+1];
		}
		countShape--;
	}
	//So sanh 2 shape
	public boolean sameShape (Shape s1, Shape s2) {
		if (s1.toString().equals(s2.toString())) {
			return true;
		}
                
		return false;
	}
        //Xoa shape giong nhau
	public void deleteSameShapes() {
		for (int i=0; i<countShape; i++) {
			for (int j=i+1; j<countShape; j++) {
				if(sameShape(shapes[i], shapes[j])) {
					deleteShape(j);
					
				}
			}
		}
	}
        //Xoa toan bo Circle trong Layer
	public void deleteCircleLayer() {
		for (int i=countShape-1; i>=0; i--) {
			if (shapes[i].getType() == Shape.CIRCLE) {
				deleteShape(i);
			}
		}
	}
	//Xoa toan bo Triangle trong Layer
	public void deleteAllTriangleLayer() {
		for (int i=countShape-1; i>=0; i--) {
			if (shapes[i].getType() == Shape.TRIANGLE) {
				deleteShape(i);
			}
		}		
	}
	//Lay thong tin
	public void showInfo() {
			for (int i=0; i<countShape; i++) {
				shapes[i].showInfo();
			}
	}
}
