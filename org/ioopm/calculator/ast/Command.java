package org.ioopm.calculator.ast;

public abstract class Command extends SymbolicExpression{
    
    
    @Override 
    public SymbolicExpression eval(Environment enviroment){
        throw new RuntimeException("Cant evaluate a command");
    }

    @Override 
    public boolean isCommand(){
        return true;
    }

    
}