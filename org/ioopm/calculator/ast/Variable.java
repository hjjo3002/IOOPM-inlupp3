package org.ioopm.calculator.ast;

public class Variable extends Atom{
    private String id;

    public Variable(String id){
        this.id = id;
    }
    
    public String toString(){
        return id;
    }
    
    public String getVariableName(){
        return this.toString();
    }

    public boolean equals(Object other){
        if(other instanceof Variable){
            return equals((Variable) other);
        }
        return false;
    }

    public boolean equals(Variable other){
        return this.id.compareTo(other.id)==0;
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment){
        String a = this.toString();

        if(Constants.namedConstants.containsKey(this.toString())){

            double res = Constants.namedConstants.get(this.toString());
            SymbolicExpression resRym = new NamedConstant(a,res);
            System.out.println(resRym);
            return resRym;
        }

        if(enviroment.containsKey(this)){
            SymbolicExpression value = enviroment.get(this);
            return value;
        }
        return this;
    }

    @Override 
    public boolean isVariable(){
        return true;
    }

    @Override
    public int hashCode() {
        String name = this.toString();
        return name.hashCode();
    }
}