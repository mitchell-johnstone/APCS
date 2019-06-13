package StackyQues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P15_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");

        String test = "y";
        while(test.toLowerCase().equals("y")){
            System.out.println("\nPlease type a mathematical expression");
            String expression = in.next();

            try {
                System.out.println(calculate(expression));
            } catch(IllegalArgumentException e){
                System.out.println("Sorry, that is not a valid expression.");
            }
            System.out.println("would you like to go again? y or n? ");
            test = in.next();
        }
    }

    public static Stack<Integer> calculate(String expression){
        System.out.println(expression);
        Stack <Operator> operators = new Stack<>();
        Stack <Integer> numbers = new Stack<>();

        while(!expression.equals("")){
            expression = expression.trim();
            String op = "+-/*^(";

            int nextOp=10000;
            boolean changed = false;
            for (int i = 0; i < op.length(); i++) {
                if(expression.indexOf(op.charAt(i))>-1 && nextOp>expression.indexOf(op.charAt(i))){
                    nextOp = expression.indexOf(op.charAt(i));
                    changed = true;
                }
            }

            if(!changed){
                nextOp = expression.length();
            }



            if(!(nextOp==0)){
                //if the next char is not an operation, it should be a number.
                String tmp = expression.substring(0,nextOp);
                tmp = tmp.trim();
                expression = expression.substring(nextOp);

                int num = Integer.parseInt(tmp);
                numbers.push(num);
            } else {
                //if not a number, then next must be an operator
                String tmp = expression.substring(0, 1);
                expression = expression.substring(1);
                if (tmp.equals("(")) {
                    //if parenthesis, call recursively
                    int end = findPair(expression);

                    if(end == -1) throw new IllegalArgumentException();

                    Stack<Integer> t = calculate(expression.substring(0,--end));
                    numbers.push(t.pop());
                    expression = expression.substring(end+1);

                } else {
                    //evaluate the precedent of each operand

                    int p = -1;
                    if (tmp.equals("+") || tmp.equals("-")) {
                        p = 0;
                    } else if (tmp.equals("*") || tmp.equals("/")) {
                        p = 1;
                    } else if (tmp.equals("^")) {
                        p = 2;
                    }


                    Operator o = new Operator(tmp, p);

                    //if the operand is of a lower precedence,
                    //calculate until at equal or below the precedence
                    if (operators.size() != 0 && o.getPrecedence() <= operators.peek().getPrecedence()) {
                        while (operators.size() > 0 && o.getPrecedence() <= operators.peek().getPrecedence()) {
                            int t = numbers.pop();
                            int result = numbers.pop();
                            Operator s = operators.pop();
                            if (s.getSymbol().equals("+")) {
                                result += t;
                            } else if (s.getSymbol().equals("-")) {
                                result -= t;
                            } else if (s.getSymbol().equals("*")) {
                                result *= t;
                            } else if (s.getSymbol().equals("/")) {
                                result /= t;
                            } else if (s.getSymbol().equals("^")) {
                                result = (int) Math.pow(result, t);
                            }
                            numbers.push(result);
                        }
                    }
                    operators.push(o);
                }
            }
//            System.out.println(numbers);
//            System.out.println(operators);
//            System.out.println();
        }

        while(operators.size() > 0){
            int t = numbers.pop();
            int result = numbers.pop();
            Operator s = operators.pop();
            if(s.getSymbol().equals("+")){
                result+=t;
            } else if(s.getSymbol().equals("-")){
                result-=t;
            } else if(s.getSymbol().equals("*")){
                result*=t;
            } else if(s.getSymbol().equals("/")){
                result/=t;
            } else if(s.getSymbol().equals("^")){
                result = (int) Math.pow(result, t);
            }
            numbers.push(result);
        }

        return numbers;
    }


    //method to find the first unmatched closed parenthesis
    public static int findPair(String s){
        int open = 1;
        int close = 0;
        int index = 0;
        while(!s.equals("")){
            int i = -1;
            if(s.contains("(") && s.contains(")")){
                i = s.indexOf("(") < s.indexOf(")") ? s.indexOf("(") : s.indexOf(")");
            } else if(s.contains("(")){
                i = s.indexOf("(");
            } else if(s.contains(")")){
                i = s.indexOf(")");
            }

            if(i == -1) break;

            if(s.charAt(i) == '(') open++;
            if(s.charAt(i) == ')') close++;
            s = s.substring(++i);
            index += i;
            if(close == open) return index;
        }
        return -1;
    }
}
