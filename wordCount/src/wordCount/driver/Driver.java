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

public class Driver {
	public static void main(String[] args) {
		try{
			
			if (args.length != 4) {
				System.out.println("Please Enter INPUT FILE,OUTPUT FILE,ITERATIONS value and Debug value");
				System.exit(0);
			}
			String input = args[0];
			String output=args[1];
			int NOOFITERATIONS = Integer.parseInt(args[2]);
			int debug = Integer.parseInt(args[3]);
			if(debug>4 || debug<1)
			{
				System.out.println("The Debug Value is out of scope it should be Between 1 And 4");
				System.out.println("1.FILE PROCESSOR\n2.CONSTRUCTOR \n3.INPUT FILE \n4.OUTPUTS");
				System.exit(0);
			}
			File f1=new File(input);
			if (!f1.exists()) {
				Logger.writeMessage("THE GIVEN INPUT FILE IS INVALID",
						DebugLevel.FILE_PROCESSOR);
				System.out.println("THE GIVEN INPUT FILE IS INVALID");
				System.exit(0);
			}
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < NOOFITERATIONS; i++) {
			BST bst=new BST();
			BSTNode bstnode=new BSTNode();
			FileProcessor fp=new FileProcessor(f1);
			Visitor v1=new PopulateVisitor(fp);
			Visitor v2=new TreeFunctionVisitor(output);
			bst.accept(v1);
			bst.accept(v2);
			fp.fileclose();
			}
			 long finishTime = System.currentTimeMillis();
		        System.out.println("The Start Time is "+startTime);
		        System.out.println("The Finish Time is "+finishTime);
		        double TotalTime = (double) (finishTime - startTime) / NOOFITERATIONS;
		        System.out.println("The Total time is "+TotalTime);
			
			}
		catch(Exception e)
		{
			
		e.printStackTrace();	
		}
		}
}
