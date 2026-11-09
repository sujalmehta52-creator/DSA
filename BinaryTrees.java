import java.util.*;

public class BinaryTrees{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;

        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" "); 
        preorder(root.left);
        preorder(root.right);

    }
    public static void Inorder(Node root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);

    }
     public static void postorder(Node root){
        if(root==null){
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" "); 

    }
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curNode= q.remove();
            if(curNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curNode.data+" ");
                if(curNode.left!=null){
                    q.add(curNode.left);
                }if(curNode.right !=null){
                    q.add(curNode.right);
                }
            }
        }
    }
    //count of Nodes
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftNodes=countOfNodes(root.left);
        int rightNodes=countOfNodes(root.right);
        return leftNodes+rightNodes+1;

    }
    //Sum of Nodes
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumOfNodes(root.left);
        int rightsum=sumOfNodes(root.right);
        return leftsum+rightsum+root.data;

    }
    //HEIGHT OF A TREE
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int myheight = Math.max(leftHeight, rightHeight)+1;
        return myheight;

    }
    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int D1=diameter(root.left);
        int D2=diameter(root.right);
        int D3=height(root.left)+height(root.right)+1;
        return Math.max(D3, Math.max(D1,D2));
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    // Diameter by approach 2
    public static TreeInfo DiamApproach2(Node root){
        if(root==null){
           return new TreeInfo(0,0);
        }
        TreeInfo left = DiamApproach2(root.left);
        TreeInfo right = DiamApproach2(root.right);
        int myheight= Math.max(left.ht,right.ht)+1;
        int D1=left.diam;
        int D2=right.diam;
        int D3=left.ht+right.ht+1;
        int myDiameter = Math.max(Math.max(D1, D2),D3);
        TreeInfo myInfo = new TreeInfo(myheight, myDiameter);
        return myInfo;
    }

    //Subtree of a graph 

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println();
        Inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countOfNodes(root));
        System.out.println("Sum of Nodes is "+sumOfNodes(root));
        System.out.println(height(root)); 
        System.out.println(diameter(root)); 
        System.out.println(DiamApproach2(root).diam);
    }  
}