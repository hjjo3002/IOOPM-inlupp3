package org.ioopm.calculator.ast;

public abstract class SymbolicExpression{
    
    public boolean isConstant(){
        return false;
    }

    public boolean isVariable(){
        return false;
    }

    public String getName(){
        throw new RuntimeException("getName() called upon with no operator");
    }

    public int getPriority(){
        return 0; //lowest prio
    }

    public double getValue(){
        throw new RuntimeException("getValue called upon with no value");
    }

    public String toString(){
        throw new RuntimeException("nothing to stringify");
    }

    public abstract SymbolicExpression eval(Enviroment enviroment);

    public boolean isCommand(){
        return false;
    }

    
} 