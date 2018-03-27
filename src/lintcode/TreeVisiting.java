package lintcode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	public boolean hasChild(){
		if(this.right != null || this.left != null){
			return true;
		}
		return false;
	}
}

public class TreeVisiting {

	public static String serialize(TreeNode root) {
		StringBuffer s = new StringBuffer();
		visit(root, s);
		return s.toString();

	}

	/**
	 * bfs
	 * @param root
	 * @return
	 */
	private static String visit1(TreeNode root) {
		Queue q = new LinkedList<TreeNode>();
		Queue v = new LinkedList<Integer>();
		q.add(root);
		TreeNode temp = null;
		while(!q.isEmpty()){
			temp = (TreeNode) q.poll();
			v.add(temp.val);
			if(temp.left != null){
				q.add(temp.left);
			}else{
				v.add("#");
			}
			if(temp.right != null){
				q.add(temp.right);
			}else{
				v.add("#");
			}
		}
		StringBuilder s = new StringBuilder();
		while(!v.isEmpty()){
			s.append(v.poll().toString() + ",");
		}
		return s.toString();
	}

	/**
	 * dfs
	 * @param root
	 * @param s
	 */
	private static void visit(TreeNode root, StringBuffer s) {
		if (root == null){
            s.append("#,");
            return;
        }
		s.append(root.val + ",");
		if (root.left != null){
			visit(root.left, s);
		}else{
			s.append("#,");
		}
		if (root.right != null){
			visit(root.right, s);
		}else{
			s.append("#,");
		}
		
	}

	/**
	 * 用一个全局变量来作为递归树时的值存储器，
	 */
	public static String adata;
	public static TreeNode deserialize(String data) {
		adata = data;
		TreeNode root = getTree();
		
		return root;
		
    }
	
	private static TreeNode getTree() {
		// TODO Auto-generated method stub
	
		if (adata.indexOf("#,") == 0) {
            adata = adata.substring(adata.indexOf(",") + 1);
            return null;
        }
        String midVal = adata.substring(0, adata.indexOf(","));
        TreeNode mid = new TreeNode(Integer.parseInt(midVal));
        adata = adata.substring(adata.indexOf(",") + 1);
        TreeNode left = getTree();
        TreeNode right = getTree();
        mid.left = left;
        mid.right = right;
        return mid;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		root.left = left;
		root.right = right;
		left.right = new TreeNode(5);
		System.out.println(serialize(root));
		System.out.println(serialize(deserialize("1,3,#,5,#,#,2,#,#,")));
	}

}
