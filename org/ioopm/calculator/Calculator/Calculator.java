package org.ioopm.calculator.Calculator;

import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;


public class Calculator {
    public static void main(String[] args){
        Environment environment = new Environment();

        final Constants constants = new Constants();
        final CalculatorParser parser = new CalculatorParser();
        Boolean loop = true;

        
        while (loop) {
            /// Event loop code here!
            
            String input = System.console().readLine();
            try {
                SymbolicExpression expression = parser.parse(input, environment);
                //System.out.println(expression instanceof Command);
                
                if(expression.isCommand()){
                    if(expression==Quit.instance()){
                        loop = false;
                    }
                    if(expression==Vars.instance()){
                        System.out.println(environment);
                        
                    }
                    if(expression==Clear.instance()){
                        environment = new Environment();
                        System.out.println(environment);
                    }
                }
                else{
                    System.out.println(expression.eval(environment));
                }


            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("try again");
            }
            
            


        }
    }
}
