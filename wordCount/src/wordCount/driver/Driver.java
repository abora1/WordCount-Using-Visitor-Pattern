package wordCount.driver;

import java.io.File;

import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.treesForStrings.BST;
public class Driver {
	public static void main(String[] args) {
		try{
			BST tree=new BST();
			if (args.length != 2) {
				System.out
						.println("Please Enter Input file,K value and Debug value along with the debug value");
				System.exit(0);
			}
			String input = args[0];
			//int k = Integer.parseInt(args[1]);
			int debug = Integer.parseInt(args[1]);
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
			FileProcessor fp=new FileProcessor(f1);
			String s=fp.readline();
			s = s.replace(".", "");
			String[] elements=s.split("\\s+");
			for(int z=0;z<elements.length;z++)
			{
				tree.put(elements[z]);
			}
			tree.printnodes();
			System.out.println(tree.getCount());
			System.out.println(tree.getCharCount());
			System.out.println(tree.totalcount());
			
			}
		catch(Exception e)
		{
			
		e.printStackTrace();	
		}
		}
}
