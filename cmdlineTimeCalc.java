import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class cmdlineTimeCalc {
	
	//Methode zur einfachen Unitenumrechnung
	
	public static void ConvertUnits() {
		System.out.println("");

				String inputStr=null; //User input
				
				//Read user input
				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input); {
				//Input instruction
				System.out.println("Type in the value (Use . instead of ,)");
				System.out.println("Syntax: [value] [input unit] [output unit]");
				System.out.println("Possible units: a (years), d (days), h (hours), min (minutes), s (seconds)");
				System.out.println("Input:");
				
				//Read after pressing Enter
				try {
					inputStr = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Input separation
				String [] inputArr = inputStr.split(" ");
				//Converting the value to Double
				double input1 = Double.parseDouble(inputArr[0]);
				
				//Converting to seconds
				
				if (inputArr[1].equals("min")) {
					input1=input1*60;
				};
				if (inputArr[1].equals("h")) {
					input1=input1*3600;
				}
				if (inputArr[1].equals("d")) {
					input1=input1*86400;
				}
				if (inputArr[1].equals("a")) {
					input1=input1*31536000;
				}
				
				//Converting to output unit
				
				if (inputArr[2].equals("s")) {input1=input1;};
				if (inputArr[2].equals("min")) {input1=input1/60;};
				if (inputArr[2].equals("h")) {input1=input1/3600;};
				if (inputArr[2].equals("d")) {input1=input1/86400;};
				if (inputArr[2].equals("a")) {input1=input1/31536000;};
				
				//Output of the solution
				System.out.println("Result: " + input1 +  " " + inputArr[2]);
				
				
				
				}
	}
	
	
	
	
	
	
	
	
	
	//Method for splitting into seperate units
	
	public static void SeperateUnits () {
		System.out.println("");
		
		//String for the user input
		String inputStr=null;
		
		//Read the user input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input); {
		//Input instruction
		System.out.println("Type in the value (Use . instead of ,)");
		System.out.println("Syntax: [Wert] [Unit]");
		System.out.println("Possible units: a (years), d (days), h (hours), min (minutes), s (seconds)");
		System.out.println("Input:");
		
		//Read after pressing Enter
		try {
			inputStr = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Separation of the number and the unit
		String [] inputArr = inputStr.split(" ");
		//Convert number to Double
		double input1 = Double.parseDouble(inputArr[0]);
		
		//Converting to seconds
		if (inputArr[1].equals("min")) {
			input1=input1*60;
		};
		if (inputArr[1].equals("h")) {
			input1=input1*3600;
		}
		if (inputArr[1].equals("d")) {
			input1=input1*86400;
		}
		if (inputArr[1].equals("a")) {
			input1=input1*31536000;
		}
		
		//Isolation of the years
		double a = input1/315360000;
		long areal = (long) a;
		long asek = areal*315360000;
		
		//Isolation of the months
		double d = (input1-asek)/86400;
		long dreal = (long) d;
		long dsek = dreal*86400;
		
		//Isolation of the hours
		double h = (input1-asek-dsek)/3600;
		long hreal = (long) h;
		long hsek = hreal*3600;
		
		//Isolation of the minutes
		double min = (input1-asek-dsek-hsek)/60;
		long minreal = (long) min;
		long minsek = minreal*60;
		
		//Isolation of the seconds
		double sreal = input1-asek-dsek-hsek-minsek;
		
		//Output of the result
		System.out.println("Result: " + areal + "a "  + dreal + "d " + hreal + "h " + minreal  + "min " + sreal+ "s");
	
		}
	}
	
	
	
	
	
	
	
	
	
	//Methode for summing up times
	
	public static void TimeSum () {
		System.out.println();
		System.out.println("Enter the times in this format: 1:23 or 1:23:45");
		System.out.println("You can also enter negative times for subtraction: -1:23 or -1:23:45");
		System.out.println("Hit Enter after every value");
		System.out.println("Last value: Type in q and hit Enter");
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		
		String input="0:00:00";
		String [] splitStr;
		List<Integer> values = new ArrayList<Integer>();
		
		int tins =0;
		
		while (!input.equals("q")) {
			values.clear();
			
			input=sc.next();
			splitStr=input.split(":");
			
			if (splitStr.length==2) {
				values.add(0);
				values.add(Integer.parseInt(splitStr[0]));
				values.add(Integer.parseInt(splitStr[1]));
			}
			if (splitStr.length==3) {
				values.add(Integer.parseInt(splitStr[0]));
				values.add(Integer.parseInt(splitStr[1]));
				values.add(Integer.parseInt(splitStr[2]));
			}
			
			if (input.contains("-")) {
				values.set(0, -Math.abs(values.get(0)));
				values.set(1, -Math.abs(values.get(1)));
				values.set(2, -Math.abs(values.get(2)));
			}
			
			if (values.size()==3) {
			tins=tins+values.get(0)*3600+values.get(1)*60+values.get(2);}
		}
		
		int seconds;
		int minutes;
		int hours;
		
		hours=tins/3600;
		tins=tins-hours*3600;
		
		minutes=tins/60;
		tins=tins-minutes*60;
		
		seconds=tins;
		
		String seczero="";
		String minzero="";
		String hzero="";
		
		if (seconds<10 && seconds>-10) {seczero="0";};
		if (minutes<10 && minutes>-10) {minzero="0";};
		if (hours<10 && hours>-10) {hzero="0";};
		
		if (hours<0 || minutes<0 || seconds<0) {
			hours=Math.abs(hours);
			minutes=Math.abs(minutes);
			seconds=Math.abs(seconds);
			
			System.out.println();
			System.out.println("-"+hzero+hours+":"+minzero+minutes+":"+seczero+seconds);
		} else {
		
			System.out.println();
		System.out.println(hzero+hours+":"+minzero+minutes+":"+seczero+seconds);
	}
	}
	
	
	
	
	
	
	//Method to assemble seperate units to a decimal number
	public static void SeparateToDecimal (){
		
		System.out.println("");
		
		String inString = null;
		String[] inArray;
		 String Unit;
		 double sek = 0;
		 double min = 0;
		 double h = 0;
		 double d = 0;
		 double a = 0;
		 double complete;
		 double result = 0;
		
		
        //Read user input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(input);
		
		//Input instruction
		System.out.println("Use . instead of ,");
		System.out.println("Syntax: [ouput unit] [seconds] [minutes] [hours] [days] [years]");
		System.out.println("Possible units: s (seconds), min (minutes), h (hours), d (days), a (years)");
		System.out.println("Input:");
		
		try {
			inString=bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Split user input
		inArray=inString.split(" ");
		
		Unit=inArray[0];
		
		//Convert to Double
		if (inArray.length==1) {System.out.println("Check your input");}
		
		if (inArray.length==2) {
			sek=Double.parseDouble(inArray[1]);
		}
		
		if (inArray.length==3) {
			sek=Double.parseDouble(inArray[1]);
			min=Double.parseDouble(inArray[2]);
		}
		
		if (inArray.length==4) {
			sek=Double.parseDouble(inArray[1]);
			min=Double.parseDouble(inArray[2]);
			h=Double.parseDouble(inArray[3]);
		}
		
		if (inArray.length==5) {
			sek=Double.parseDouble(inArray[1]);
			min=Double.parseDouble(inArray[2]);
			h=Double.parseDouble(inArray[3]);
			d=Double.parseDouble(inArray[4]);
		}
		
		if (inArray.length==6) {
			sek=Double.parseDouble(inArray[1]);
			min=Double.parseDouble(inArray[2]);
			h=Double.parseDouble(inArray[3]);
			d=Double.parseDouble(inArray[4]);
			a=Double.parseDouble(inArray[5]);
			
		}
		
		//Sum up times
		complete=sek+min*60+h*3600+d*86400+a*31536000;
		
		
		
		
		//Convert to output unit
		if (Unit.equals("s")) {}
		if (Unit.equals("min")) {result=complete/60;}
		if (Unit.equals("h")) {result=complete/3600;}
		if (Unit.equals("d")) {result=complete/86400;}
		if (Unit.equals("a")) {result=complete/31536000;}
		
		//Output
		System.out.println("Result: "  + result + " " + Unit);
		}
	
	public static void main (String [] args) {
	
		//Selection of actions
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		String inputStr = "";
		System.out.println("1: Convert time: Only converts into another unit (Decimal)");
		System.out.println("2: Convert time: Split into separate units");
		System.out.println("3: Convert seperate units into a decimal number");
		System.out.println("4: Sum up durations (eg for music pieces)");
		
		System.out.println("Enter action number:");
		
		//Read user input
		try {
			inputStr = bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Run action based on user input
		if (inputStr.equals("1")) {
			try {
				ConvertUnits();}
				catch (java.lang.NumberFormatException f) {System.out.println(""); System.out.println("Check your input"); System.out.println(""); SeperateUnits();}
				catch (java.lang.ArrayIndexOutOfBoundsException g) {System.out.println(""); System.out.println("Check your input"); System.out.println(""); SeperateUnits();}
			
		}
		
		if (inputStr.equals("2")) {
		
		//Aufrufen der Methode und Fehlerbehandlung
		try {
		SeperateUnits();}
		catch (java.lang.NumberFormatException f) {System.out.println(""); System.out.println("Check your input"); System.out.println(""); SeperateUnits();}
		catch (java.lang.ArrayIndexOutOfBoundsException g) {System.out.println(""); System.out.println("Check your input"); System.out.println(""); SeperateUnits();}
	}
	if (inputStr.equals("4")) {
		TimeSum();
	}
	
	if (inputStr.equals("3")) {
		SeparateToDecimal();
	}
	}
}
