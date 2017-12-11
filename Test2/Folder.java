/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan101;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH HIEU
 */
class Folder implements Entries{
    private List<Entries> childEntries=new ArrayList<Entries>();
    public void visit()
    {
        System.out.println("I am Folder ");
        for(Entries entries:childEntries)
        {
            entries.visit();
        }
        
    }
    public void addEntries(Entries e)
        {
            childEntries.add(e);
        }
    
    public void removeEntries(Entries e)
    {
        childEntries.remove(e);
    }
}
