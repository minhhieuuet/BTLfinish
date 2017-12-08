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
public class Method {
    String type=" ";
    String name;
    
    public Method(String type,String name)
    {
        this.type=type;
        this.name=name;
    }
    
    public void showInfo()
    {
        if(this.name.contains(","))
        {
            String[] temp=this.name.split("\\(");
            temp[1]=temp[1].replace(")","");
            String[] temp1=temp[1].split(",");
            for(int i=0;i<temp1.length;i++)
            {
                temp1[i]=temp1[i].trim();
                String[] temp2=temp1[i].split(" ");
                String a;
                a=temp2[0];
                temp2[0]=temp2[1];
                temp2[1]=a;
                temp1[i]=String.join(":",temp2);
            }
            
            this.name=temp[0]+"( "+String.join(", ",temp1)+" )";
        }
        
        /////////////
        if(!this.name.contains(","))
        {
            String[] t1=name.split("\\(");
            if(!t1[1].trim().equals(")"))
            {
                t1[1]=t1[1].replace(")","").trim();
                String[] t2=t1[1].split(" ");
                this.name= t1[0]+"("+t2[1]+": "+t2[0]+")";
            }
        }
        
        ////////////
        if(!this.type.equals(""))
        {
        System.out.println("+"+this.name+":"+this.type);
        }
        else
        {
            System.out.println("+"+this.name);
        }
    }
    public String toString()
    {
        if(!this.type.equals(""))
        {
        return "+"+this.name+":"+this.type;
        }
        else
        {
            return "+"+this.name;
        }
    }
}
