
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Copyright (c) 2017 MINH HIEU.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    MINH HIEU - initial API and implementation and/or initial documentation
 */

/**
 *
 * @author MINH HIEU
 */
public class TestSwing {
   
    public void draw(String path) throws IOException {
        
         File folder = new File(path);
         JTextArea[] a=new JTextArea[100];
         int count =0;
         int x=20;
         int x1=20;
        JFrame f;
        f=new JFrame("UML");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 300);
        JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);
        f.add(hbar, BorderLayout.SOUTH);
        f.add(vbar, BorderLayout.EAST);

    hbar.setUnitIncrement(2);
    hbar.setBlockIncrement(1);
    

        
         
        File[] listOfFiles = folder.listFiles();
        for(int i=0;i<listOfFiles.length;i++)
        {
            if(listOfFiles[i].getName().contains(".java"))
            {
                String s;
                showInfo s1=new showInfo(path+listOfFiles[i].getName());
                s=s1.xuly();
                if(s1.rank==1)
                {
                        a[count]=new JTextArea(s,300,300);
                        //JScrollPane scroll=new JScrollPane(a[count],JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        a[count].setBounds(x,30,220,310);  
                        a[count].setBorder(BorderFactory.createLineBorder(Color.black));
                        a[count].setDragEnabled(true);
                        a[count].setEditable(false); 
                        x=x+240;
                        f.add(a[count]);
                        //f.add(scroll);
                        count++;
                }
                
                if(s1.rank==2)
                {       a[count]=new JTextArea(s,300,300);
                        a[count].setBounds(x1,380,220,310);  
                        a[count].setBorder(BorderFactory.createLineBorder(Color.black));
                        a[count].setDragEnabled(true);
                        a[count].setEditable(false); 
                        x1=x1+240;
                        f.add(a[count]);
                        count++;
                    
                }
            }
            
        }
       
        
        
        f.setSize(1400,740);
        f.setLocationRelativeTo(null);  
        f.setLayout(null);  
        f.setVisible(true);
        
        
        
    }
}
