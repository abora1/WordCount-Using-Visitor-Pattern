package wordCount.modules;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class PopulateVisitor implements Visitor {
	private FileProcessor fp;

	public PopulateVisitor(FileProcessor fpIn) {
		this.fp = fpIn;
	}

	@Override
	public void visit(BST bst) {
		try {
			String st = null;
			while ((st = fp.readline()) != null) {
				st = st.replaceAll("[^a-z A-Z]", " ");

				String[] wordsLine = st.split("\\s+");
				for (int i = 0; i < wordsLine.length; i++) {

					bst.put(wordsLine[i]);
				}
			}

		} catch (Exception e) {
			System.out.println("ERROR WHILE INSERTING DATA FROM FILE TO TREE");
			Logger.writeMessage("ERROR WHILE INSERTING DATA FROM FILES",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		}

	}

}
