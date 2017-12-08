import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class TestSwing1 extends JFrame implements MouseListener, MouseMotionListener {
//String path="E:/d/";
   // String path;


JScrollPane scroll=new JScrollPane();
public JLabel[] l = new JLabel[100];








class JPanel1 extends JPanel
{
    
    private final int ARR_SIZE = 9;
            //Ve mui ten giua hai diem
            void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
                Graphics2D g = (Graphics2D) g1.create();

                double dx = x2 - x1;
                double dy = y2 - y1;
                double angle = Math.atan2(dy, dx);
                int len = (int) Math.sqrt(dx*dx + dy*dy);
                AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
                at.concatenate(AffineTransform.getRotateInstance(angle));
                g.transform(at);

                // Draw horizontal arrow starting in (0, 0)
                g.drawLine(0, 0, len, 0);
                g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                              new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            }
            //Ve mui ten giua hai label j1=dau j2=duoi ( Quan he extends )
             void drawArrow2(Graphics g1, JLabel j1,JLabel j2) {
                Graphics2D g = (Graphics2D) g1.create();
                int x1=j1.getX()+j1.getWidth()/2;
                int y1=j1.getY();
                int x2=j2.getX()+j2.getWidth()/2;
                int y2=j2.getY()+j2.getHeight();
                double dx = x2 - x1;
                double dy = y2 - y1;
                double angle = Math.atan2(dy, dx);
                int len = (int) Math.sqrt(dx*dx + dy*dy);
                AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
                at.concatenate(AffineTransform.getRotateInstance(angle));
                g.transform(at);
                 

                g.drawLine(0, 0, len, 0);
                g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                              new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            }
             //Ve mui ten giua hai label quan he implements
             void drawArrow3(Graphics g1, JLabel j1,JLabel j2) {
                Graphics2D g = (Graphics2D) g1.create();
                int x1=j1.getX()+j1.getWidth()/2;
                int y1=j1.getY();
                int x2=j2.getX()+j2.getWidth()/2;
                int y2=j2.getY()+j2.getHeight();
                double dx = x2 - x1;
                double dy = y2 - y1;
                double angle = Math.atan2(dy, dx);
                int len = (int) Math.sqrt(dx*dx + dy*dy);
                
                AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
                at.concatenate(AffineTransform.getRotateInstance(angle));
                g.transform(at);
                //Stroke dang net dut
                Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g.setStroke(dashed);

                g.drawLine(0, 0, len, 0);
                g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                              new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            }
    public void paintComponent( Graphics g ) {
                    super.paintComponent(g);
                    //Tao mot mang class info
                    classInfo[] c=new classInfo[count];
                    //drawArrow(g,l[0].getX()+l[0].getWidth()/2, l[0].getY(),l[1].getX()+l[1].getWidth()/2,l[1].getY()+l[1].getHeight());
                    for(int i=0;i<count;i++)
                    {
                        if(!l[i].getText().contains("subClass"))
                        {
                            String[] s=l[i].getText().split("</h2>");
                            s[0]=s[0].replaceAll("center","");
                            s[0]=s[0].replaceAll("h2","");
                            s[0]=s[0].replaceAll("html","");
                            s[0]=s[0].replaceAll("<","");
                            s[0]=s[0].replaceAll(">","");
                            s[0]=s[0].replaceAll("/","");
                            c[i]=new classInfo(s[0]);
                            c[i].showInfo();
                        }
                        else
                        {
                        String[] s=l[i].getText().split("<subClass>");
                        s[0]=s[0].replaceAll("center","");
                            s[0]=s[0].replaceAll("h2","");
                            s[0]=s[0].replaceAll("html","");
                            s[0]=s[0].replaceAll("<","");
                            s[0]=s[0].replaceAll(">","");
                            s[0]=s[0].replaceAll("/","");
                            s[0]=s[0].replaceAll("ibr","");
                            s[0]=s[0].replaceAll("subClass"," ");
                            s[0]=s[0].replaceAll("Super Class Name: ","");
                            if(s[0].contains("extends"))
                            {
                                String[] s1=s[0].split("extendsbr");
                                c[i]=new classInfo(s1[0].trim(),s1[1].trim(),1);
                            }
                            else
                            {
                                String[] s1=s[0].split("implementsbr");
                                c[i]=new classInfo(s1[0].trim(),s1[1].trim(),2);
                            }
                            //c[i]=new classInfo(s1[0].trim(),s1[1].trim());
                            //c[i].showInfo();
                        
                        }
                    }
                    //Ve duong thang 
                    for(int i=0;i<count;i++)
                    {
                        for(int j=0;j<count;j++)
                        {
                            if(c[i].getSC().equals(c[j].getName()))
                            {
                                if(c[i].type==1)
                                {
                                    drawArrow2(g, l[i], l[j]);
                                }
                                else
                                {
                                    drawArrow3(g, l[i], l[j]);
                                }
                            }
                        }
                        
                    }
                    
                    
                    
                    /*
                    for(int i=0;i<count;i++)
                    {
                        drawArrow3(g,l[0],l[i]);
                    }
                    */
                 }

}


private JPanel1 panel = new JPanel1();    

JScrollPane scrollBar = new JScrollPane(panel);
          
       


private int  count=0;

private int mouseX = 200;
private int mouseY = 100;
private boolean drag = false;

//Chuc nang di chuyen
@Override
public void mousePressed(MouseEvent e) {
    //if (e.getSource() == l[count]) {
        drag = true;
        //this.repaint();
    //} 
}

@Override
public void mouseReleased(MouseEvent e) {
    drag = false;
    //this.repaint();
}

@Override
public void mouseDragged(MouseEvent e) {
    if (drag == true) {
        JComponent jc = (JComponent)e.getSource();
        jc.setLocation((jc.getX()+e.getX()-50), jc.getY()+e.getY()-50);
        //l[count].setLocation(jc.getX()+e.getX(),jc.getY()+e.getY());
        this.repaint();
    }
}

public void mouseMoved(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseClicked(MouseEvent e) {}

public TestSwing1(String path) throws IOException{
    panel.setPreferredSize(new Dimension(1450,1450));
    this.add(panel);
    
    
    /*
     this.add( new JPanel() {
                 public void paintComponent( Graphics g ) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D)g;

                    Line2D line = new Line2D.Double(10, 10, 40, 40);
                    g2.setColor(Color.blue);
                    g2.setStroke(new BasicStroke(1));
                    g2.draw(line);
                 }
            });
            */
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();
        for(int i=0;i<listOfFiles.length;i++)
        {
            int x=30;
            int x1=30;
            if(listOfFiles[i].getName().contains(".java"))
            {  
               String s="  ";
               String path1;
               path1=path+listOfFiles[i].getName();
                //showInfo s1=new showInfo(path+listOfFiles[i].getName());
                showInfo b=new showInfo(path1);
                s=b.xuly();
                
                
                l[count]=new JLabel();
                panel.setBackground(Color.WHITE);


                //scroll.add(l[count]);
                panel.add(l[count]);
                l[count].setOpaque(true); 
                l[count].setBackground(Color.orange);
                l[count].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                l[count].setText(s);
                //l[count].setLocation(x+=200, 50);
                l[count].setLayout(null);
                if(!l[count].getText().contains("subClass"))
                    {
                        l[count].setLocation(x,30);
                        x+=l[count].getWidth()+10;
                    }
                    else
                    {
                        l[count].setLocation(x1,430);
                        x1+=l[count].getWidth()+10;
                    }
                l[count].setSize(l[count].getPreferredSize());
                //Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
                l[count].setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                //l[count].setBorder(border);
                
                l[count].addMouseMotionListener(this);
                l[count].addMouseListener(this);
                count++;
            }
            
        }
        
        
        //Add menubar
        
        JMenuBar menubar = new JMenuBar();

        ImageIcon iconNew = new ImageIcon("new.png");
        ImageIcon iconOpen = new ImageIcon("open.png");
        ImageIcon iconSave = new ImageIcon("save.png");
        ImageIcon iconExit = new ImageIcon("exit.png");
        
        
        
        
        JMenu fileMenu = new JMenu("Tùy chọn");
        //Them sap xep
        JMenu sort=new JMenu("Sắp xếp");
       
        JCheckBoxMenuItem sx=new JCheckBoxMenuItem("Tự động sắp xếp");
        
        sort.add(sx);
        //Tao event cho sap xep
        sx.addActionListener((ActionEvent event) -> {
            if(!sx.isSelected())
            {
               return;
            }
            int x=20;
            int x1=20;
            for(int i=0;i<count;i++)
                {
                    
                    if(!l[i].getText().contains("subClass"))
                    {
                        l[i].setLocation(x,30);
                        x+=l[i].getWidth()+10;
                    }
                    else
                    {
                        l[i].setLocation(x1,430);
                        x1+=l[i].getWidth()+10;
                    }
                    
                }
                
            
        });
        
        JMenuItem newMi = new JMenuItem("Tạo mới", iconNew);
        JMenuItem openMi = new JMenuItem("Chọn folder", iconOpen);
        JMenuItem saveMi = new JMenuItem("Lưu ảnh", iconSave);
        JCheckBoxMenuItem opacity = new JCheckBoxMenuItem("Trong suốt");
        JMenuItem exitMi = new JMenuItem("Thoát", iconExit);
        exitMi.setToolTipText("Exit application");
        
        opacity.addActionListener(((e) -> {
            if(!opacity.isSelected())
            {
                for(int i=0;i<count;i++)
                {
                    l[i].setOpaque(true);
                    this.repaint();
                }
            }
            else
            {
               for(int i=0;i<count;i++)
                {
                    l[i].setOpaque(false);
                    this.repaint();
                }
                
            }
        }));

//Tao event cho open 
         
        newMi.addActionListener((ActionEvent event) -> {
            
              JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                

               TestSwing s=new TestSwing();
               this.setVisible(false);
                    try {
                        //s.draw();
                        TestSwing1 frame = new TestSwing1(chooser.getSelectedFile().toString().replace("\\\\","/")+"/");
                        
    
                //frame.setName("UML");
                //frame.setLayout(new BorderLayout());
                frame.setTitle("UML Maker");

                frame.setVisible(true);
                //frame.setSize(1024, 4000);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                //frame.setUndecorated(true);
                //frame.setMinimumSize(new Dimension(400, 400));
                frame.setResizable(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    

            } else {
              System.out.println("No Selection ");
            }
           
            
            
            
        });
        
        
        //Tao envent cho save
        saveMi.addActionListener((ActionEvent event) -> {
            //Tao file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                //Tao graphic va luu
                TestSwing s=new TestSwing();
                BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                this.printAll(g2d);
                g2d.dispose();
                try {
                    ImageIO.write(img, "png", new File(chooser.getSelectedFile().toString().replace("\\\\","/")+"/"+"UML.png"));
                } catch (IOException ex) {
                    Logger.getLogger(TestSwing1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                

            } else {
              System.out.println("No Selection ");
            }
            
        });
        //Tao event cho exit
        
        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        //fileMenu.addSeparator();
        fileMenu.add(opacity);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);
        
        
        menubar.add(fileMenu);
        menubar.add(sort);
        setJMenuBar(menubar);
        ///
        
        this.repaint();
        JScrollPane scrollPane = new JScrollPane(panel);
     
// Force the scrollbars to always be displayed
 
scrollPane.setHorizontalScrollBarPolicy(
   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
scrollPane.setVerticalScrollBarPolicy(
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
this.getContentPane().add(scrollPane);



}

    

}