
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new FileReader("/home/szymcio/eclipse-workspace/NieMamPojecia/src/testin.txt"));
		List<String> solutions = new ArrayList<>();
		try {
		    StringBuilder sb = new StringBuilder();
		    
		    String line = br.readLine();
		    String temp = "";
		    while (line != null) {
		    	
		    	
		        String parseLine = line + " ";
		        
			    if(parseLine.trim().equals("==")) {
			    	break;
			    }else if(parseLine.trim().equals("=")){
			    	solutions.add(temp);
			    	temp = "";
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
		while(iter.hasNext()) {
			String a = iter.next();
			System.out.println(a);
			
		}
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval("4*5");
	}

}
