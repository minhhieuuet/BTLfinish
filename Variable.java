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
public class Variable {
    String name="";
    String type="";
    String value="";
    public Variable(String name,String type)
    {
        this.name=name;
        this.type=type;
    }
    public Variable(String name,String type,String value)
    {
        this.name=name;
        this.type=type;
        this.value=value;
    }
    
    public void showInfo()
    {
        if(value.equals(""))
        {
            System.out.println("-"+name+":"+type);
        }
        else
        {
            System.out.println("-"+name+":"+type+" = "+value);
        }
    }
    
    public String toString()
    {
        if(value.equals(""))
        {
            return "-"+name+":"+type;
        }
        else
        {
            return "-"+name+":"+type+" = "+value;
        }
    }
}
