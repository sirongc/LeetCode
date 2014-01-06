package first_round;

public class SameTree {
	public static void main(String[] args){
		
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null) return false;
		if(q == null) return false;
		if(p.val != q.val) return false;
		if(!isSameTree(p.left, q.left) || !isSameTree(q.right, q.right)) return false;
		return true;    
    }
}
