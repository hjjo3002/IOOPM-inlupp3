package org.ioopm.calculator.ast;

public class Multiplication extends Binary{

    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    @Override 
    public String getName(){
        return "*";
    }

    @Override 
    public int getPriority(){
        return 100;
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment){
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        SymbolicExpression rhs = this.getRhs().eval(enviroment);

        if(lhs.isConstant() && rhs.isConstant()){
            return new Constant(rhs.getValue()*lhs.getValue());
        }
        return new Multiplication(lhs, rhs);
    }
    
} 


    
