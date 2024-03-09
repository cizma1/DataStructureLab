package Lab2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression){
        QueueBasedStack<Double> valueStack=new QueueBasedStack<>();
        QueueBasedStack<Character> operatorStack=new QueueBasedStack<>();

        for(int i=0; i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch=='('){
                continue;
            }
            else if(ch=='+' || ch=='-' || ch=='+' || ch=='/' || ch=='^' || ch=='%' || ch=='√'){
                operatorStack.push(ch);
            }
            else if(Character.isDigit(ch) || ch=='.'){
                StringBuilder num=new StringBuilder();
                while(i<expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i)=='.')){
                    num.append(expression.charAt(i));
                    i++;
                }
                i--;
                valueStack.push(Double.parseDouble(num.toString()));
            }
            else if(ch==')'){
                char operator= operatorStack.pop();
                double operand2= valueStack.pop();
                double result;
                if(operator=='√'){
                    result=Math.sqrt(operand2);
                }
                else{
                    double operand1= valueStack.pop();
                    switch(operator){

                        case '+':
                            result=operand1+operand2;
                            break;
                        case '-':
                            result=operand1-operand2;
                            break;
                        case '*':
                            result=operand1*operand2;
                            break;
                        case '/':
                            result=operand1/operand2;
                            break;
                        case '%':
                            result=operand1%operand2;
                            break;
                        case '^':
                            result=Math.pow(operand1, operand2);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator");
                    }
                }
                valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
}
