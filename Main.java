
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

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
public class Main {
  
    JFrame f;
    JLabel a;
    JButton b;
    Main() {
        JFrame f=new JFrame("UML Diagram Maker");
        
        JLabel a=new JLabel("Nhấn Open để chọn đường dẫn đến project của bạn:");
        a.setFont(new Font("Arial",Font.CENTER_BASELINE,14));
        a.setBounds(7,30,1000,20);
        f.add(a);
        //Tao button
        JButton b=new JButton("Open");
         b.setBounds(150,100,90, 50);
         JButton c=new JButton("Exit");
         c.setBounds(150,170,90, 50);
         //Tao event
         c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
         
         b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {


               

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
                f.setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    

            } else {
              System.out.println("No Selection ");
            }
           
            }
        });
         f.add(b);
         f.add(c);
     
// Force the scrollbars to always be displayed
 

       
        
        f.setSize(400, 400);
        
        f.setLocationRelativeTo(null);  
        f.setLayout(null);  
        f.setVisible(true);  
                  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
        
            public static void main(String[] args) throws IOException {
                new Main();
    }
}
