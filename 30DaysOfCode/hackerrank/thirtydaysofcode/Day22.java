package hackerrank.thirtydaysofcode;

import java.util.Scanner;

class BSTNode {
	BSTNode left,right;
	int data;
	BSTNode(int data){
		this.data=data;
		left=right=null;
	}
}
class Day22 {

	public static int getHeight(BSTNode root){
		//depth first search

		int left_height = 0;
		int right_height = 0;

		if(root.data > 0){ //3
			if(root.left != null)
			{
				left_height = getHeight(root.left) + 1;     
			}
			if(root.right != null)
			{
				right_height = getHeight(root.right) + 1;          
			}

		}
		return left_height > right_height ? left_height : right_height; 
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
		int height=getHeight(root);
		System.out.println(height);
	}
}