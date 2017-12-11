
import java.util.Arrays;

public class Diagram {
	//Khoi tạo mảng các layer
	private Layer[] layers=new Layer[100];
        //Khởi tạo biến đếm Layer
	private int countLayer;
	
	//Khởi tạo Diagram
	public Diagram() {
		layers = new Layer[100];
		countLayer = 0;
	}
	//Thêm Layer
	public void addLayer(Layer layer) {
		if (countLayer >= 100) {
			return;
		}
		layers[countLayer++] = layer;
	}
       
	
	//Xoa tat ca Circle trong Diagram
	public void deleteAllCircleDiagram() {
		for(int i=0; i<countLayer; i++) {
			layers[i].deleteCircleLayer();
		}
	}
            
	//Di chuyen Shape cung loai vao mot Layer
	
	public void movesameTypeShapestoLayers() {
		
                Layer[] sortedLayer=new Layer[5];
                for(int j=0;j<5;j++)
                {
                    sortedLayer[j]=new Layer();
                }
                
               
                    
		for(int i=0; i< countLayer; i++) {
			           
			for(int j=0; j<layers[i].countShape; j++) {
                            
                                if(layers[i].shapes[j].getType()==Shape.CIRCLE)
                                {
                                    sortedLayer[0].addShape(layers[i].shapes[j]);
                                }
                                if(layers[i].shapes[j].getType()==Shape.RECTANGLE)
                                {
                                    sortedLayer[1].addShape(layers[i].shapes[j]);
                                }
                                if(layers[i].shapes[j].getType()==Shape.SQUARE)
                                {
                                    sortedLayer[2].addShape(layers[i].shapes[j]);
                                }
                                if(layers[i].shapes[j].getType()==Shape.TRIANGLE)
                                {
                                    sortedLayer[3].addShape(layers[i].shapes[j]);
                                }
                                if(layers[i].shapes[j].getType()==Shape.HEXAGON)
                                {
                                    sortedLayer[4].addShape(layers[i].shapes[j]);
                                }
			}
		}
                int i,j;
                for(i=j=0;j<sortedLayer.length;++j)
                {
                    if(sortedLayer[j].countShape!=0)
                    {
                        sortedLayer[i++]=sortedLayer[j];
                    }
                }
                
                sortedLayer=Arrays.copyOf(sortedLayer,i);
                
                
                countLayer=i;
                layers=sortedLayer;
                 
                
	}
	//Lay info
	public void showInfo() {
		for(int i=0; i<countLayer; i++) {
			if(layers[i].getVisible()) {
                            
				System.out.println("______________________________________________");
				System.out.println("Layer " + i + ":");
                                System.out.println("=======");
				layers[i].showInfo();
			}
		}
	}
	
}
