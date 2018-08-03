package wordCount.treesForStrings;
public class BST
{
    private BSTNode root;
    int count=0;
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
			traverseBST(node.right);
		}
	}
    public void printnodes(){
    	traverseBST(this.root);
    }
    public int getLeafCount() 
    {
        return count;
    }
  
    
}