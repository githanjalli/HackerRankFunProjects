package hackerrank.thirtydaysofcode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Day23 {

	static void levelOrder(BSTNode root){
		Queue<BSTNode> m_q = new LinkedList<BSTNode>();
		m_q.add(root);

		while(!m_q.isEmpty()){
			BSTNode current = m_q.remove();
			System.out.print(current.data + " ");
			if(current.left != null)
			{
				m_q.add(current.left);
			}
			if(current.right != null)
			{
				m_q.add(current.right);
			}
		}

	}

	public static BSTNode insert(BSTNode root,int data){
		if(root==null){
			return new BSTNode(data);
		}
		else{
			BSTNode cur;
			if(data<=root.data){
				cur=insert(root.left,data);
				root.left=cur;
			}
			else{
				cur=insert(root.right,data);
				root.right=cur;
			}
			return root;
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		BSTNode root=null;
		while(T-->0){
			int data=sc.nextInt();
			root=insert(root,data);
		}
		sc.close();
		levelOrder(root);
	}	
}