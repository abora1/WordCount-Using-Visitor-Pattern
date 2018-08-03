package wordCount.treesForStrings;

import wordCount.modules.Visitor;

public class BST
{
    private BSTNode root;
    int count=0;
    int charcount=0;
    public void put( String key )
    {
        if ( root == null )
        {
            root = new BSTNode( key );
        }
        else
        {
            root.put( key );
        }
    }

    public Object get( String key )
    {
        return root == null ? null : root.get( key );
    }
    private void traverseBST(BSTNode node) {
		if (node != null) {
			count++;
			traverseBST(node.left);
			System.out.println(node.getKey());
			charcount=charcount+node.getKey().length();
			traverseBST(node.right);
		}
	}
    public void printnodes(){
    	traverseBST(this.root);
    }
    public int getCount() 
    {
        return count;
    }
   public int getCharCount(){
	   int x=BSTNode.getCountduplicatewords();
	   return x+charcount;
   }
   public int totalcount(){
	  int x=BSTNode.getCountduplicate();
	  return x+count;
   }
   public void accept(Visitor visitor) {
       visitor.visit(this);
   }
}