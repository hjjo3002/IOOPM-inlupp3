package org.ioopm.calculator.ast;

public class Assignment extends Binary{
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    @Override
    public String getName() {
        return "=";
    }

    @Override 
    public int getPriority(){
        return 10;
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment){
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        SymbolicExpression rhs = this.getRhs();

        if(rhs.isNamedConstant()){
            throw new IllegalAssignmentException("Error: Cannot be a named Constant");
        }

        if(rhs.isVariable()){
            Variable rhsVariable = (Variable) rhs;
            enviroment.put(rhsVariable, lhs);
            //System.out.println("lhs = "+ lhs);
            //System.out.println("rhs = "+rhs);
            return lhs;
        }
        throw new RuntimeException("Error: Must be variable on right hand side!");
    }
}