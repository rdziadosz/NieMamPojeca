
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new FileReader("/home/szymcio/eclipse-workspace/NieMamPojecia/src/in2.txt"));
		List<String> solutions = new ArrayList<>();
		try {
		    StringBuilder sb = new StringBuilder();
		    
		    String line = br.readLine();
		    String temp = "";
		    while (line != null) {
		    	
		    	
		        String parseLine = line + " ";
		        
			    if(parseLine.trim().equals("==")) {
			    	solutions.add(temp);
			    	break;
			    }else if(parseLine.trim().equals("=")){
			    	solutions.add(temp);
			    	temp = "";
			    }else if(parseLine.trim().equals("^")){
			    	line = br.readLine();
			    	String numberBefore = temp.substring(temp.length() -2);
			    	
			    	int pow = Integer.parseInt(line);
			    	System.out.println(pow);
			    	
			    	for(int i=0;i<pow-1;i++) {
			    		temp += "*" + numberBefore;
			    	}
			    	solutions.add(temp);
			    }else if(parseLine.trim().equals("5")){
			    	if(temp.equals("")) {
			    		line = br.readLine();
			    	}else {
			    		temp = temp.substring(0, temp.length()-2);
			    	}
			    }else {
			    	System.out.println(temp);
			    	temp += parseLine;
			    }
		        line = br.readLine();
		    }
		    
		    
		} finally {
		    br.close();
		}
		
		Iterator<String> iter = solutions.iterator();
		System.out.println("asd");
		PrintWriter writer = new PrintWriter("/home/szymcio/eclipse-workspace/NieMamPojecia/src/out2.txt", "UTF-8");
		
		while(iter.hasNext()) {
			String a = iter.next();
			
			System.out.println(a);
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object result = engine.eval(a);
			if(result != null) {
				writer.println(result.toString());
			}
			
		}
		writer.close();
		
		
	}

}
