/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan101;

/**
 *
 * @author MINH HIEU
 */
public class Tuan101 {

    
    public static void main(String[] args) {
       Shortcut s1=new Shortcut();
       Shortcut s2=new Shortcut();
       
       BinaryFile b1=new BinaryFile();
       
       TextFile t1=new TextFile();
       TextFile t2=new TextFile();
       TextFile t3=new TextFile();
       
       Folder f1=new Folder();
       f1.addEntries(s1);
       f1.addEntries(b1);
       f1.addEntries(t1);
       Folder f2=new Folder();
       f2.addEntries(t3);
       f2.addEntries(f1);
       f2.addEntries(t2);
       
       
       f1.visit();
        System.out.println("__________");
        f2.visit();
       
    }
    
}
