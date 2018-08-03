package wordCount.modules;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.util.Results;

public class TreeFunctionVisitor implements Visitor{
	String op;
FileProcessor output;
Results rs=new Results();
	 public TreeFunctionVisitor(String outputIN) {
		this.op=outputIN;
	}
	@Override
	public void visit(BST bst) {
		int DistinctCountofwords=bst.getCount();
		int TotalWordsCount=bst.totalcount();
		int TotalCharacterCount=bst.getCharCount();
		rs.storeNewResult("TOTAL NUMBER OF DISTINCT WORDS IS :"+DistinctCountofwords+"\n");
		rs.storeNewResult("TOTAL NUMBER OF WORDS IS :"+TotalWordsCount+"\n");
		rs.storeNewResult("TOTAL NUMBER OF CHARACTERS IS :"+TotalCharacterCount+"\n");
		rs.writeToFile(op);
	}

}
