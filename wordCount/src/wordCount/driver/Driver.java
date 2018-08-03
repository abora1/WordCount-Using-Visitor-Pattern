package wordCount.driver;

import java.io.File;

import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.modules.PopulateVisitor;
import wordCount.modules.TreeFunctionVisitor;
import wordCount.modules.Visitor;
import wordCount.treesForStrings.BST;

public class Driver {
	public static void main(String[] args) {
		try{
			
			if (args.length != 3) {
				System.out
						.println("Please Enter Input file,K value and Debug value along with the debug value");
				System.exit(0);
			}
			String input = args[0];
			String output=args[1];
			//int k = Integer.parseInt(args[1]);
			int debug = Integer.parseInt(args[2]);
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
				System.exit(0);
			}
			BST bst=new BST();
			FileProcessor fp=new FileProcessor(f1);
			Visitor v1=new PopulateVisitor(fp);
			Visitor v2=new TreeFunctionVisitor(output);
			bst.accept(v1);
			bst.accept(v2);
			
			}
		catch(Exception e)
		{
			
		e.printStackTrace();	
		}
		}
}
