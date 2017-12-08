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
public class classInfo {
    String superClass="";
    String name;
    public int type=0;
    public int rank;
    public String s;
   
    
    public classInfo(String name,String superClass)
    {
        this.name=name;
        this.superClass=superClass;
        rank=2;
    }
    public classInfo(String name)
    {
        this.name=name;
        rank=1;
    }
    public classInfo(String name,String superClass,int type)
    {
        this.type=type;
        this.name=name;
        this.superClass=superClass;
        rank=2;
    }
    
    public String getSC()
    {
        return this.superClass;
    }
    public String getName()
    {
        return this.name;
    }
    
    
    public String toString()
    {
         if(!this.superClass.equals(""))
        {
            if(this.type==1)
            {
                return "<h2><center>"+name+"</center></h2>"+"<extends>"+"<br><"+superClass+"><subClass>";
            }
            else
            {
                return "<h2><center>"+name+"</center></h2>"+"<implements>"+"<br><"+superClass+"><subClass>";
            }
        }
        else
        {
            return "<h2><center>"+name+"</center></h2>";
        }
    }
    public void showInfo()
    {
        if(!this.superClass.equals(""))
        {
        System.out.println("Name: "+name+" Super Class Name: "+superClass);
        }
        else
        {
            System.out.println("Name:"+name);
        }
    }
}
