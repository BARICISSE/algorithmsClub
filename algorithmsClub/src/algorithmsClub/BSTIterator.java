package algorithmsClub;

public class BSTIterator {
	
	TreeNode root;

    public BSTIterator(TreeNode root) {
    	this.root = root;
    	
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	boolean hasnext = true;
    	if(root.left != null){
    		hasnext = true;
    	}
    	else{
    		hasnext = false;
    	}
    	
    	return hasnext;
        
    }

    /** @return the next smallest number */
    public int next() {
        
    	int nextSmall = 0;
    	if(root.left != null){
    		nextSmall = root.left.val;
    	}
    	
    	
    	return nextSmall;
    }
}