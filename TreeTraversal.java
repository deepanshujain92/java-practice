import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	public static void main(String[] args) {
		   TreeTraversal t = new TreeTraversal();
		   TreeNode tree = new TreeNode(0); 
	       tree.left= new TreeNode(1); 
	       tree.right= new TreeNode(2); 
	       tree.left.left= new TreeNode(3); 
	       tree.left.right= new TreeNode(4); 
	       t.levelOrderTraversal(tree);

	}
	public void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode tempNode = q.poll();
			System.out.println(tempNode.value);
			if(tempNode.left!=null) q.add(tempNode.left);
			if(tempNode.right!=null) q.add(tempNode.right);
		}
		
	}
}
