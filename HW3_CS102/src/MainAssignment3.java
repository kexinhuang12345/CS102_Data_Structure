import java.io.BufferedReader;
import java.io.FileReader;


public class MainAssignment3 extends Calculator1{
	public static void testEvalInfix(String path) throws Exception{
		
		String line=null;
		BufferedReader br=new BufferedReader(new FileReader(path));
		try{
			
			while((line=br.readLine())!=null){
				try{
					double x=evalInfix(line);
					System.out.println("Input is "+line+" output is "+x);
				}catch(IllegalExpressionException iee ){
					iee.printStackTrace();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		br.close();
		
	}
	
	public static void testEvalPrefix(String path) throws Exception{
		
		String line=null;
		BufferedReader br=new BufferedReader(new FileReader(path));
		try{
			
			while((line=br.readLine())!=null){
				try{
					double x=evalPrefix(line);
					System.out.println("Input is "+line+" output is "+x);
				}catch(IllegalExpressionException iee){
					iee.printStackTrace();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		br.close();
		
	}
	

	public static void testInfixToPostfix(String path) throws Exception{
		
		String line=null;
		BufferedReader br=new BufferedReader(new FileReader(path));
		try{
			
			while((line=br.readLine())!=null){
				try{
					String x=InfixToPostfix(line);
					System.out.println("Input is "+line+" output is "+x);
				}catch(IllegalExpressionException iee){
					iee.printStackTrace();
				}

			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		br.close();
	
	}

	public static void main(String[] args) throws Exception{
		System.out.println("__________________Evaluate Infix Expression__________________________");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		testEvalInfix(args[0]);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("_________________Evaluate Prefix Expression__________________________");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		testEvalPrefix(args[1]);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("_________________Transform Infix to Postfix__________________________");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		testInfixToPostfix(args[2]);
	 	
		

	}
	
	
}
