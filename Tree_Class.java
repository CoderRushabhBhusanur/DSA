//package Tree_Examples;
//
//public class Tree_Class {
//	Node root;
//	
//	void insert(Node r, Node n) // r=root/parent, n= new node
//	{
//		if(root == null) //work only for first node
//			root =n; 
//		else
//		{
//			if(n.data <r.data)//left
//			{
//				if(r.left==null)
//					r.left=n;
//				else
//					insert(r.left,n);  // go to left and explore. find more positions here
//			}
//			else
//			{
//				if(r.right ==null)
//					r.right=n;
//				else
//					insert(r.right,n);
//			}
//		}
//	}
//	void inorder (Node r)
//	{
//		if(r!=null) //LPR
//		{
//			inorder(r.left);//L
//			System.out.print(r.data + " , ");//P
//			inorder(r.right);//R
//		}
//	}
//	
//	public static void main(String [] args)
//	{
//		Tree_Class t = new Tree_Class();
//		   t.insert(t.root,new Node(10));
//	       t.insert(t.root,new Node(20));
//	       t.insert(t.root,new Node(5));
//	       t.insert(t.root,new Node(15));
//	       t.insert(t.root,new Node(30));
//	       System.out.print("\nInorder:");
//
//		System.out.print("\nInorder: ");
//		t.inorder(t.root);
//	}
//}


//------------------------------------------------------------------------------------------



package Tree_Examples;

public class Tree_Class {
    Node root;
    
    void insert(Node r, Node n) // r = root/parent, n = new node
    {
        if(root == null) // works only for first node
            root = n;
        else
        {
            if(n.data < r.data) // left
            {
                if(r.left == null)
                    r.left = n;
                else
                    insert(r.left, n);  
            }
            else
            {
                if(r.right == null)
                    r.right = n;
                else
                    insert(r.right, n);
            }
        }
    }

    // INORDER (L P R)
    void inorder(Node r)
    {
        if(r != null)
        {
            inorder(r.left);
            System.out.print(r.data + " , ");
            inorder(r.right);
        }
    }
    
    //write a function to return tree value:
    int sum_nodes(Node r)
    {
        if (r == null)
            return 0;
        return r.data + sum_nodes(r.left) + sum_nodes(r.right);
    }
    
    int count_node(Node r)
    {
    	if(r==null)
    		return 0;
    	else
    		return 1+count_node(r.left) + count_node(r.right);
    }
    
    int count_leaf(Node r)
    {
        if(r == null)
            return 0;

        if(r.left == null && r.right == null)
            return 1;

        return count_leaf(r.left) + count_leaf(r.right);
    }
    
 

    int depth(Node root, int key)
    {
        return depthHelper(root, key, 0);
    }
    
    private int depthHelper(Node r, int key, int d)
    {
        if (r == null)
            return -1;                    
        if (r.data == key)
            return d;                   
        int left = depthHelper(r.left, key, d + 1);
        if (left != -1)
            return left;
        return depthHelper(r.right, key, d + 1);
    }

    // PREORDER (P L R)
    void preorder(Node r)
    {
        if(r != null)
        {
            System.out.print(r.data + " , "); // P
            preorder(r.left);                 // L
            preorder(r.right);                // R
        }
    }

    // POSTORDER (L R P)
    void postorder(Node r)
    {
        if(r != null)
        {
            postorder(r.left);                // L
            postorder(r.right);               // R
            System.out.print(r.data + " , "); // P
        }
    }

    //write a function to return tree value:
    
    public static void main(String [] args)
    {
        Tree_Class t = new Tree_Class();
        
        t.insert(t.root, new Node(10));
        t.insert(t.root, new Node(20));
        t.insert(t.root, new Node(5));
        t.insert(t.root, new Node(15));
        t.insert(t.root, new Node(30));
        t.insert(t.root, new Node(1));
        t.insert(t.root, new Node(6));

        System.out.print("\nInorder: ");
        t.inorder(t.root);

        System.out.print("\nPreorder: ");
        t.preorder(t.root);

        System.out.print("\nPostorder: ");
        t.postorder(t.root);
        
        System.out.print("\nSum of all node values: " + t.sum_nodes(t.root)); //find sum of tree3
        
        System.out.print("\nTotal node :" + t.count_node(t.root)); //calling count
        
        System.out.print("\nTotal leaf nodes: " + t.count_leaf(t.root)); //calling leaf node
                
        System.out.println("Depth of node 15: " + t.depth(t.root, 15));  //count depth
    }
}
