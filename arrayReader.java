////////////////////////////////////////////////////////////////
//      cs112 project: Happy Hours. This program will read files 
//		into arrays.
//
////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class arrayReader {

	public static int N;
	public static String[] restaurants;
	public static String[] start;
	public static String[] end;
	public static String[] comments;

	private static final String FILENAME = "happyhoursMonday.csv";

	public static void main(String[] args) {
		
		System.out.println("Please specify day, with first letter capitalized.");
		Scanner console = new Scanner(System.in);
		String chooseDay = console.nextLine();
		readFile(chooseDay);
	}

	private static void readFile(String day) {

		
		Scanner input = null;
		
		try {
			if (day.equals("Monday"))
			input = new Scanner(new File("happyhoursMonday.csv"));
			
			else if (day.equals("Tuesday"))
				input = new Scanner(new File("happyhoursTuesday.csv"));
			
			else if (day.equals("Wednesday"))
				input = new Scanner(new File("happyhoursWednesday.csv"));
			
			else if (day.equals("Thursday"))
				input = new Scanner(new File("happyhoursThursday.csv"));
			
			else if (day.equals("Friday"))
				input = new Scanner(new File("happyhoursFriday.csv"));
			
			else if (day.equals("Saturday"))
				input = new Scanner(new File("happyhoursSaturday.csv"));
			
			else if (day.equals("Sunday"))
				input = new Scanner(new File("happyhoursSunday.csv"));
			
			else
				System.out.println("Not a day of the week, try again.");
			
			//System.out.println("file");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("hello");
			e.printStackTrace();
		}

		String test = input.next();
		String number = test.replaceAll("[^0-9]", "");
		
		N = Integer.parseInt(number);
		//String str = N
		//System.out.println(N);
		input.nextLine();

		restaurants = new String[N];
		start = new String[N];
		end = new String[N];
		comments = new String[N];


		
		for(int i=0;i<N;i++) {
			String line = input.nextLine();
			//System.out.println(line);
			String[] parts = line.split(",");
			restaurants[i] = parts[0];
			System.out.println(parts[0]);
			
			start[i] = parts[2];
			String starter = parts[2].replaceAll(":00", "");
			System.out.println(starter);
			//int first = Integer.parseInt(starter);
			
			end[i] = parts[3];
			String ender = parts[3].replaceAll(":00", "");
			System.out.println(ender);
			//int second = Integer.parseInt(ender);
			
			comments[i] = parts[4];
			
		}
/*
		//String[] startraw = new String[N];
		//String[] endraw = new String[N];		
		//some cells have commas inside...method replaces with string so that splitting works later
		//line = handleCommas(line);
		//Split 
			
		//cleans array of quotes and of whitespace
		restaurants = cleanArray(restaurants);
		startraw = cleanArray(startraw);
		endraw = cleanArray(endraw);
		comments = cleanArray(comments);
*/		 		


	}
/*
	private static String[] handleCommas(String[] stringto) {

		for(int i=0;i<N;i++) {
			//taken from http://codewithabhi.com/2013/07/read-csv-files-in-java-with-commas-in-data.html
			//find commas that are within quotation marks
			Pattern pat = Pattern.compile("\"+[^,]+[,]+[^,]+\"");
			//find all instances of that within each line
			Matcher mat = pat.matcher(stringto[i]);
			//when one is found, replace the line with a line containing !@ for commas within quotes
			while(mat.matches()) {
				String replac = mat.group().replaceAll(",", "!@");
				stringto[i] = stringto[i].replaceAll(mat.group(), replac);
			}
			System.out.println(stringto[i]);
		}


		return stringto;
	}

	private static String[] cleanArray(String[] stringto) {

		for(int i=0;i<N;i++) {
			//replace quotes and trim out whitespace:
			stringto[i] = stringto[i].replaceAll("\"","").trim();

			//now add commas back into each field!
		}

		return stringto;
	}
*/

}
