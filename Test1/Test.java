


public class Test {
	public static void main(String[] args) {
		Diagram d1 = new Diagram();
	
		
		Layer l0 = new Layer();
		Layer l1 = new Layer();
		Layer l2 = new Layer();
                l2.setVisible(true);
		d1.addLayer(l0);
		d1.addLayer(l1);
		d1.addLayer(l2);
		
		l0.addShape(new Triangle(0, 0, 2, 0, 3, 3));
		l0.addShape(new Square(3,5,6));
		l0.addShape(new Triangle(-4, -4, -2, 0 , 0, 0));
		

		l1.addShape(new Rectangle(7,10,10,10));
		l1.addShape(new Square(10,5,5));
		l1.addShape(new Hexagon(6, 8, 5));
                l1.addShape(new Rectangle(7,10,10,10));
                l1.addShape(new Rectangle(5,1,10,10));
                l1.addShape(new Circle(1,3,5));
                l1.addShape(new Hexagon(5, 10, 5));
                
                
		l2.addShape(new Square(3,5,6));
		l2.addShape(new Square(2,7,4));
		l2.addShape(new Hexagon(5, 8, 5));
                l2.addShape(new Triangle(0, 0, 2, 0, 1, 1));
                l2.shapes[0].fillColor("black");
		
                
		
                
                System.out.println("Tat ca cac Layer:");
                d1.showInfo();
                
                
              
		System.out.println("\n\n");
		System.out.println("Xoa tat ca shape giong nhau cua layer 1:");
		l1.deleteSameShapes();
		d1.showInfo();
		
		System.out.println("\n\n");
		System.out.println("Xoa tat ca triangle cua layer 0:");
		l0.deleteAllTriangleLayer();
		d1.showInfo();
		
		System.out.println("\n\n");
		System.out.println("Xoa tat ca Circle trong diagram:");
		d1.deleteAllCircleDiagram();
		d1.showInfo();
                
		System.out.println("\nDi chuyen tat ca shape cung loai ve mot tang:");
		d1.movesameTypeShapestoLayers();
		d1.showInfo();
                
	}

}
