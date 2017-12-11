/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thtuan8;

/**
 *
 * @author MINH HIEU
 */
public class  Division extends BinaryExpression{
    Expression left;
    Expression right;
    public Division( Expression left,Expression right) {
        this.left=left;
        this.right=right;
        
    }

    @Override
    public Expression left(){
        return left;
        
    }
    @Override
    public Expression right(){
        return right;
        
    }

    @Override
    public int evaluate()
    {
        return left.evaluate()/right.evaluate();
    
    }

    @Override
    public  String toString()
    {
        return " ";
    }
    
     
    
    
    
}
