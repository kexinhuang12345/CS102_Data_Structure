import java.util.Stack;


public class Calculator1 {
	
	/*
	 * author: Kexin Huang
	 * 
	 * Evaluate infix expression by using stacks
	 * 
	 * 
	 * @param String exp the Infix expression
	 * @return double   the computation result of the expression
	 */
	public static double evalInfix(String exp)throws IllegalExpressionException{
		//omit the space 
		Stack<String> list=new Stack<String>();
		String[] tokens = exp.trim().split("\\s+");
		//counters for Exceptions
		int countParenthese=0;
		int countOperator=0;
		int countNumber=0;
		
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].equals("(")){
				System.out.println("");
			}else if(tokens[i].equals(")")){
				//observation: this means you could compute the 2 number beforehand 
				countParenthese++;
				String z=list.pop();
				if(z.equals("+")||z.equals("-")||z.equals("*")||z.equals("/")){
					throw new IllegalExpressionException("Wrong form (lack a number)");
				}
				double x=Double.parseDouble(z);
				String operator=list.pop();
				double y=Double.parseDouble(list.pop());
				if (operator.equals("+")){
					list.push(Double.toString(x+y));
				}else if (operator.equals("-")){
					list.push(Double.toString(y-x));
				}else if (operator.equals("*")){
					list.push(Double.toString(x*y));
				}else if (operator.equals("/")){
					list.push(Double.toString(y/x));
				}
			}else{
				if(isNumeric(tokens[i])){
					countNumber++;
				}else if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
					countOperator++;
				}else {
					// then the string is in wrong format, throw exception
					throw new IllegalExpressionException("wrong form (the string format is wrong)");
				}
				list.push(tokens[i]);

			}
		
		}
		
		if(countNumber!=(countOperator+1)){
			throw new IllegalExpressionException("wrong form (cannot compute)");
			
		}
		
		if(countParenthese!=countOperator){
			throw new IllegalExpressionException("wrong form (some operation is not enclosed in a parenthese)");
		}
		
		
		return Double.parseDouble(list.pop());
	}
	
	
	//private helper method
	//to find if a string is a number
	private static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	/*
	 * evaluate a prefix expression by using stacks 
	 * 
	 * observation: if reversing the order first
	 * then the stack is working much easier
	 * 
	 * @param string exp  the prefix expression
	 * @return double  the prefix result
	 */
	public static double evalPrefix(String exp)throws IllegalExpressionException{
		Stack<String> list=new Stack<String>();
		String[] tokens = exp.trim().split("\\s+");
		int countOperator=0;
		int countNumber=0;
		if(!tokens[0].equals("+")&&!tokens[0].equals("-")&&!tokens[0].equals("*")&&!tokens[0].equals("/")){
			throw new IllegalExpressionException("wrong form (start with number)");
		}
		
		//reverse the order first by counting from the end to the start
		for(int i=0;i<tokens.length;i++){
			
			if(isNumeric(tokens[i])){
				countNumber++;
			}else{
				countOperator++;
			}
		}
		if(countNumber!=(countOperator+1)){
			throw new IllegalExpressionException("wrong form (cannot compute)");
		}
		for(int i=tokens.length-1;i>-1;i--){
			if(tokens[i].equals("+")){
				list.push(Double.toString(Double.parseDouble(list.pop())+Double.parseDouble(list.pop())));
			}else if(tokens[i].equals("-")){
				list.push(Double.toString(Double.parseDouble(list.pop())-Double.parseDouble(list.pop())));
			}else if(tokens[i].equals("*")){
				list.push(Double.toString(Double.parseDouble(list.pop())*Double.parseDouble(list.pop())));
			}else if(tokens[i].equals("/")){
				list.push(Double.toString(Double.parseDouble(list.pop())/Double.parseDouble(list.pop())));
			}else {
				list.push(tokens[i]);//push numbers
			}
		}
	
		return Double.parseDouble(list.pop());
	}
	
	/*
	 * transform infix expression to postfix expression
	 * 
	 * @param String infix expression
	 * @return String postfix expression
	 * 
	 */
	public static String InfixToPostfix(String exp)throws IllegalExpressionException{
		String res=" ";
		Stack<String> list=new Stack<String>();
		String[] tokens = exp.trim().split("\\s+");
		int countOperator=0;
		int countDigit=0;
		if(!tokens[0].equals("(")){
			throw new IllegalExpressionException("wrong form (paratheness)");
		}
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
				list.push(tokens[i]);
				countOperator++;
			}else if(tokens[i].equals("(")){
				System.out.print("");
				//do nothing
			}else if(tokens[i].equals(")")){
				res=res.concat(list.pop()+" ");
			}else {
				res=res.concat(tokens[i]+" ");
				countDigit++;
			}
		}
		
		if(countDigit!=(countOperator+1)){
			throw new IllegalExpressionException("Wrong form (cannot compute)");
		}
		
		return res;
	}
}
