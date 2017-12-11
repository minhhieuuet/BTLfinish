
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MINH HIEU
 */
public class className {
    String path;
    int count=0;
    public className(String path)
    {
        this.path=path;
    }
    public  String[] name()
    {
        String[] clist=new String[1000];
        
       File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
         if (file.isFile()) {
            
             try {

            File f = new File(path+file.getName());

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            

            while ((readLine = b.readLine()) != null) {
                if(readLine.contains("class")&&!readLine.contains("//"))
                {
                    readLine=readLine.trim();
                    String[] arr1=readLine.split(" ");
                    for(int i=0;i<arr1.length;i++)
                    {
                        if(arr1[i].equals("class"))
                        {
                            clist[count]=arr1[i+1];
                            count++;
                           
                        }
                    }
                    
                    
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        }
}   
        return clist;
    }
    
    
    
}
