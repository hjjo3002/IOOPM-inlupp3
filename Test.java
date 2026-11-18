import org.ioopm.calculator.ast.*;

public class Test{

    public static void testPrinting(String expected, SymbolicExpression e) {
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public static void testEvaluating(SymbolicExpression expected, SymbolicExpression e, Environment enviroment) {
        SymbolicExpression r = e.eval(enviroment);
        if (r.equals(expected)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public static void main(String[] args) {
            
    Constant c1 = new Constant(5);
    Constant c2 = new Constant(2);
    Variable v1 = new Variable("x");
    Variable v2 = new Variable("y");
    Sin s1 = new Sin(v1);

    Addition a1 = new Addition(c1, v1);
    Multiplication m1 = new Multiplication(a1, c2);
    Multiplication m2 = new Multiplication(c1, s1);
    Division d1 = new Division(s1, v1);
    Negation n1 = new Negation(s1);
    Sin s2 = new Sin(a1);
    Addition a2 = new Addition(m2, m1);

    System.out.println("---Printing Tests---");
    testPrinting("sin x", s1);
    testPrinting("5.0 * sin x", m2);
    testPrinting("sin x / x", d1);
    testPrinting("- sin x", n1);
    testPrinting("sin (5.0 + x)", s2);
    testPrinting("5.0 * sin x + (5.0 + x) * 2.0", a2);
    testPrinting("(5.0 + x) * 2.0", m1);


    System.out.println("---Evaluate Tests---");

    SymbolicExpression a3 = new Addition(new Constant(5), new Constant(37));
    SymbolicExpression c3 = new Constant(42);
    SymbolicExpression c4 = new Constant(10);

    SymbolicExpression m3 = new Multiplication(c1, c2);

    SymbolicExpression d2 = new Division(new Constant(Math.PI), new Constant(2));
    SymbolicExpression c5 = new Constant(Math.PI / 2);

    SymbolicExpression c6 = new Constant(1);
    SymbolicExpression s3 = new Sin(d2);

    SymbolicExpression l1 = new Log(new Constant(1));
    SymbolicExpression c7 = new Constant(0.0);

    SymbolicExpression d3 = new Division(new Constant(10), new Constant(2));

    Environment env = new Environment();

    testEvaluating(c3, c3, env);
    testEvaluating(c3, a3, env); // Tests if reducing a3 returns c3
    testEvaluating(c4, m3, env);
    testEvaluating(c1, d3, env);
    testEvaluating(c6, s3, env);
    testEvaluating(c7, l1, env);
    testEvaluating(c5, d2, env);

        
    System.out.println("---Eval with variables test---");

    // x = 5
    SymbolicExpression as1 = new Assignment(c1, v1);
    testEvaluating(c1, as1, env);

    // y = 5
    SymbolicExpression as2 = new Assignment(c1, v2);
    testEvaluating(c1, as2, env);

    // y + 1 = z
    SymbolicExpression a4 = new Addition(v2, c6);
    SymbolicExpression v3 = new Variable("z");
    SymbolicExpression as3 = new Assignment(a4, v3);

    testEvaluating(new Constant(6), as3, env);

    // Kontrollera att y + 1 = 6
    testEvaluating(new Constant(6), a4, env);

    // y + 1 = x (uppdaterar x från 5 till 6)
    SymbolicExpression as4 = new Assignment(a4, v1);
    testEvaluating(new Constant(6), as4, env);

    // check x, z = 6
    testEvaluating(new Constant(6), v1, env);
    testEvaluating(new Constant(6), v3, env);


    SymbolicExpression v4 = new Variable("å");
    SymbolicExpression v5 = new Variable("z");

    SymbolicExpression as5 = new Assignment(v3, v4);
    testEvaluating(new Constant(6), as5, env);

    System.out.println("v3 = " + v3.hashCode() + "\nv5 = " + v5.hashCode());

    System.out.println(env);




    System.out.println("---Named constant---");

    SymbolicExpression PI = new Variable("pi");
    SymbolicExpression ans = new Variable("answer");

    testEvaluating(new Constant(Math.PI), PI, env);

    System.out.println(PI.isNamedConstant());


    SymbolicExpression a7 = new Addition(ans, ans);

    testEvaluating(c3, ans, env);
    testEvaluating(new Constant(84), a7, env);
    
    SymbolicExpression E = new NamedConstant("e", Math.E);
    System.out.println(E.isNamedConstant());

    //SymbolicExpression EisNotTwo = new Assignment(new Constant(2), E);
    //testEvaluating(new Constant(2), EisNotTwo, env); should return a illegal assignment exception. 

    

    }
}