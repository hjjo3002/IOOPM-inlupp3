package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs;
    private SymbolicExpression rhs;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String toString(){
        String lhsString = this.lhs.toString();
        String rhsString = this.rhs.toString(); 


        if(lhs.getPriority()<this.getPriority()){
            lhsString = "(" + lhsString + ")";
        }
        
        if(rhs.getPriority()<this.getPriority()){
            rhsString = "(" + rhsString + ")";
        }

        return lhsString + " " + this.getName() + " " + rhsString;
    }

    public boolean equals(Object other){
        return false;
    }

    public boolean equals(Binary other){
        return this.getName().compareTo(other.getName())==0;
    }

    protected SymbolicExpression getLhs(){
        return this.lhs;
    }

    protected SymbolicExpression getRhs(){
        return this.rhs;
    }
}