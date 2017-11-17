import java.util.*;
import java.io.*;

public class sumOfLinesWithScanner{
	
	public static void main(String[] args){
		if((args.length>1) || (args.length<1)){
			System.out.println("Bad nr of arguments!");
		} else {
			try{
				sumWithScan(args[0]);
			} catch (IOException e){
				System.err.println("IO ERROR");
				e.printStackTrace();
			}
		}
	}
	
	public static void sumWithScan(String inFileName)
	throws IOException{
		try( Scanner sc = new Scanner(new File(inFileName));){
			String line1 ="";
			ArrayList<String> resultList = new ArrayList<String>();
			while(sc.hasNextLine()){
				line1 = sc.nextLine();
				// System.out.println(line1);
				if(sc.hasNextLine()){
					String line2 = sc.nextLine();
					// System.out.println(line2);
					Scanner scanner1 = new Scanner(line1);
					Scanner scanner2 = new Scanner(line2);
					scanner1.useDelimiter(",");
					scanner2.useDelimiter(",");
					
					int[] tmp = new int[line1.split(",").length];
					// System.out.println("*" + tmp.length);
					int idx = 0;
					while(scanner1.hasNext()){
						int tmpElem = scanner1.nextInt() + scanner2.nextInt();
						System.out.println(tmpElem);
						tmp[idx] = tmpElem;
						++idx;
					}
					resultList.add(Arrays.toString(tmp));
				}
			}
			printToFile(resultList);
		}
	}
	
	public static void printToFile(ArrayList<String> data){
		String outFileName = "out.txt";
		File outFile = new File(outFileName);
		try( PrintWriter pw = new PrintWriter(outFile);){
			for(int i=0; i<data.size(); ++i)
				pw.println(data.get(i));
		} catch (IOException e){
			System.err.println("IO ERROR ON WRITE");
			e.printStackTrace();
		}
	}
}