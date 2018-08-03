package wordCount.driver;

import java.io.File;

import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.modules.PopulateVisitor;
import wordCount.modules.TreeFunctionVisitor;
import wordCount.modules.Visitor;
import wordCount.treesForStrings.BST;
import wordCount.treesForStrings.BSTNode;

/**
 * @author akshay
 *This class handles the inputs along with the Iterator
 *IT passes the object of the FileProcessor and BST class TO the Visitor Pattern.
 *It also measures the performance of the system.
 */
public class Driver {
	public static void main(String[] args) {
		try {

			if (args.length != 4) {
				System.out
						.println("Please Enter INPUT FILE,OUTPUT FILE,ITERATIONS value and Debug value");
				System.exit(0);
			}
			String input = args[0];
			String output = args[1];
			int NOOFITERATIONS = Integer.parseInt(args[2]);
			int debug = Integer.parseInt(args[3]);
			File f1 = new File(input);
			if (debug > 4 || debug < 1) {
				System.out
						.println("The Debug Value is out of scope it should be Between 1 And 4");
				System.out
						.println("1.FILE PROCESSOR\n2.CONSTRUCTOR \n3.OUTPUTS\n4.PERFORMANCE");
				System.exit(0);
			}
			if (!f1.exists()) {
				Logger.writeMessage("THE GIVEN INPUT FILE IS INVALID",
						DebugLevel.FILE_PROCESSOR);
				System.out.println("THE GIVEN INPUT FILE IS INVALID");
				System.exit(0);
			}
			Logger.setDebugValue(debug);
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < NOOFITERATIONS; i++) {
				BST bst = new BST();
				BSTNode bstnode = new BSTNode();
				FileProcessor fp = new FileProcessor(f1);
				Visitor v1 = new PopulateVisitor(fp);
				Visitor v2 = new TreeFunctionVisitor(output);
				bst.accept(v1);
				bst.accept(v2);
				fp.fileclose();
			}
			long finishTime = System.currentTimeMillis();
			double TotalTime = (double) (finishTime - startTime)/ NOOFITERATIONS;
			if(debug!=4){
			System.out.println("\nThe Start Time is " + startTime);
			System.out.println("The Finish Time is " + finishTime);
			System.out.println("The Total time is " + TotalTime);
			}
			else{
				Logger.writeMessage("\nThe START Time is "+startTime,
						DebugLevel.PERFORMANCE);
				Logger.writeMessage("The END Time is "+finishTime,
						DebugLevel.PERFORMANCE);
				Logger.writeMessage("The TOTAL Time is "+TotalTime,
						DebugLevel.PERFORMANCE);
			}
		}catch(NumberFormatException x){
			System.out.println("THE VALUE EXPECTED SHOULD BE INTEGER");
			x.printStackTrace();
			System.exit(0);
		}
		catch (Exception e) {
			System.out.println("ERROR WHILE PARSING FILES");
			Logger.writeMessage("ERROR WHILE PARSING FILES",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		}
	}
}
