import java.util.Stack;


public class Calculator {
	public static double evalInfix(String exp) throws IllegalExpressionException{
		
		String[] list=new String[exp.length()/2+1];
		// omit the space between each item 
		int countExp=0;
		int countNum=0;
		int countOpera=0;
		String temp=null;		
		boolean judge=false;

		for(int i=0;i<list.length;i++){
			while(exp.charAt(countExp)==(' ')){
				countExp++;
			}
			
			if(Character.isDigit(exp.charAt(countExp))){
				countNum++;
				temp=Character.toString(exp.charAt(countExp));
				countExp++;	
				while(Character.isDigit(exp.charAt(countExp))){
					temp=temp+exp.charAt(countExp);
					countExp++;
					judge=true;
				}	
			}
			if(exp.charAt(countExp)=='+'||exp.charAt(countExp)=='-'||exp.charAt(countExp)=='*'||exp.charAt(countExp)=='/'){
					countOpera++;
			}
						
			if(judge=true){
				list[i]=temp;
				judge=false;
				temp=null;
			}else{
				list[i]=Character.toString(exp.charAt(countExp));
				countExp++;
				
			}
		}
		
		//exception
		if(countNum!=countOpera+1){
			throw new IllegalExpressionException("incorrect form");
		}
		
		
		//the list is now all the numbers and operators		
		double term1Value=0;
		double term2Value=0;
		String[] term1=findTerm(list);
		String[] term2= new String[list.length-term1.length-1];
		//find term2
		for(int i=0;i<list.length;i++){
			term2[i]=list[term1.length+1+i];
		}
		
			/* if no this is the last term 
		 * evaluate it
		 * if this is not,
		 * recursive call 
		 */
		if(term1.length==1){
			term1Value=Double.parseDouble(term1[0]);
			//if the term is a number then return the number 
		}else if(term1.length>1){
			term1Value=evalInfix(term1.toString());
		}
		
		if(term2.length==1){
			term2Value=Double.parseDouble(term2[0]);
		}else if(term2.length>1){
			term2Value=evalInfix(term2.toString());
		}

		
		//Evaluate it 
		String operator=list[term1.length];
		if(operator=="+"){
			return term1Value+term2Value;
		}else if(operator=="-"){
			return term1Value-term2Value;
		}else if(operator=="*"){
			return term1Value*term1Value;
		}else{
			return term1Value/term2Value;
		}
	
	}
	
	//private helper method 
	//@see if a string is numeric
	
	private static boolean isNumeric(String x){
		try  
		  {  
		    double d = Double.parseDouble(x);  
		  }  
		  catch(NumberFormatException e)  
		  {  
		    return false;  
		  }  
		  return true;  
		
	}
	
	//private helper method
	private static String[] findTerm(String[] list){
		
		String[] list2;

		if(isNumeric(list[1])){
				
				list2=new String[1];
				list2[0]=list[1];
				return list2;
		}
			
		int count=0;
		int countListLength=1;
		for(int i=1;i<list.length;i++){
			
			if(list[i]=="("){
				count++;
				countListLength++;
			}else if(list[i]==")"){
				count--;
				countListLength++;
			}else if(isNumeric(list[i])){
				countListLength++;
			
			}
			
			if(count==0){
				list2 = new String[countListLength];
				for(int j=0;j<countListLength;j++){
					list2[j]=list[j];
				}
				return list2;

			}

		}
		list2=new String[0];
		return list2;
	}
	
	
	public static double evalPrefix(String exp) throws IllegalExpressionException{
		
		Stack list=new Stack();
		//term1 
		int countNum=0;
		int countOpe=0;
		int countString=0;
		String temp=null;
		boolean judge=false;
		
		while(countNum!=countOpe+1){
			
			while(exp.charAt(countString)==' '){
				countString++;
			}
			
			if(Character.isDigit(exp.charAt(countString))){
				countNum++;		
				temp=Character.toString(exp.charAt(countString));
				countString++;
				while(Character.isDigit(exp.charAt(countString))){
					temp=temp+exp.charAt(countString);
					countString++;
					judge=true;
				}
			}else if(exp.charAt(countString)=='+'||exp.charAt(countString)=='-'||exp.charAt(countString)=='*'||exp.charAt(countString)=='/'){
				list.push(Character.toString(exp.charAt(countString)));
				countString++;

				}	
				
				if(judge=true){
					list.push(temp);
					judge=false;
					temp=null;
				}else{
					list.push(Character.toString(exp.charAt(countString)));
					countString++;
					
				}
				
				list.push(Character.toString(exp.charAt(countString)));
			}
		
		
		//for exception
		int countTerm1Ope=countOpe;
		int countTerm1Num=countNum;
		
		if(countTerm1Ope!=countTerm1Num+1){
			throw new IllegalExpressionException("incorrect form");
		}
		while(list.size()>2){
			getRes(list);
			//see the private helper method
		}
		
		//term2
		countNum=0;
		countOpe=0;
		while(countNum!=countOpe+1){
			
			if(exp.charAt(countString)==' '){
				countString++;
			}else if(Character.isDigit(exp.charAt(countString))){
				countNum++;
				countString++;
				list.push(Character.toString(exp.charAt(countString)));
			}else if(exp.charAt(countString)=='+'||exp.charAt(countString)=='-'||exp.charAt(countString)=='*'||exp.charAt(countString)=='/'){
				countOpe++;
				countString++;
				list.push(Character.toString(exp.charAt(countString)));
			}
		}
		//exception when number of numbers doesn't equal to numbers of operators plus 1
		int totalNum=countNum+countTerm1Num;
		int totalOpe=countOpe+countTerm1Ope;
		if(totalNum!=totalOpe+1){
			throw new IllegalExpressionException("incorrect form");
		}
		
		while(list.size()>1){
			getRes(list);
		}
		
		double result=Double.parseDouble((String) list.pop());
		return result;
		
	}
	
	//private helper method
	private static void getRes(Stack list){
		double term=0;
		Object operand1=list.pop();
		Object operand2=list.pop();
		String operator=(String)list.pop();
		double term1Value=Double.parseDouble((String) operand1);
		double term2Value=Double.parseDouble((String) operand2);
		if(operator=="+"){
			term=term1Value+term2Value;
		}else if(operator=="-"){
			term=term1Value-term2Value;
		}else if(operator=="*"){
			term=term1Value*term1Value;
		}else{
			term=term1Value/term2Value;
		}
		Double termOb=new Double(term);
		list.push(termOb);
		
	}
	
	public static String infixToPostfix(String exp) throws IllegalExpressionException{
		String output="";
		Stack list=new Stack();
		list.push(exp);
		
		while(!list.isEmpty()){
			String top= (String) list.pop();
			//top is a number or an operator means the length is 1
			if(top.length()==1&&!top.equals(" ")){
				output.concat(top+" ");
			}else{
				String[] list1=new String[top.length()/2+1];
				// omit the space between each item
				int countExp=0;
				int countNum=0;
				int countOpera=0;
				String temp=null;
				boolean judge=false;
				
				for(int i=0;i<list1.length;i++){
					while(exp.charAt(countExp)==(' ')){
						countExp++;
					}
					
					if(Character.isDigit(exp.charAt(countExp))){
						countNum++;
						temp=Character.toString(exp.charAt(countExp));
						countExp++;	
						while(Character.isDigit(exp.charAt(countExp))){
							temp=temp+exp.charAt(countExp);
							countExp++;
							judge=true;
						}	
					}
					if(exp.charAt(countExp)=='+'||exp.charAt(countExp)=='-'||exp.charAt(countExp)=='*'||exp.charAt(countExp)=='/'){
							countOpera++;
					}
								
					if(judge=true){
						list1[i]=temp;
						judge=false;
						temp=null;
					}else{
						list1[i]=Character.toString(exp.charAt(countExp));
						countExp++;
						
					}

				}
				
				//exception
				if(countNum!=countOpera+1){
					throw new IllegalExpressionException("incorrect form");
				}
				
				
				//the list is now all the numbers and operators		
				String[] term1=findTerm(list1);
				String[] term2= new String[list1.length-term1.length-1];
				//find term2
				for(int i=0;i<term2.length;i++){
					term2[i]=list1[term1.length+1+i];
				}
				String operator=list1[term1.length];
				String operator1=operator;
				String Term1="";
				String Term2="";
				for(int i=0;i<term1.length;i++){
					Term1.concat(term1[i]);
				}
				for(int i=0;i<term2.length;i++){
					Term2.concat(term2[i]);
				}
				list.push(operator1);
				list.push(Term2);
				list.push(Term1);
				
			}
			
		}
		return output;
	}
	
	
	
}






