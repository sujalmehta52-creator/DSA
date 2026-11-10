import java.util.*;
public class tryBinarytree {
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
    static  int idx=-1;
    static Node buildtree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode=new Node(nodes[idx]);
        newNode.left=buildtree(nodes);
        newNode.right=buildtree(nodes);
        return newNode;



    }
    public static void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void Inorder(Node root){
        if(root==null){
            return;

        }
        Inorder(root.left);
        System.out.print(root.data);
        Inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
/**************************************************
 * // VERY IMP TYPE THAT IS LEVEL ORDER TRAVERSAL *
 **************************************************/
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }


    }
/*************************************
 * //HERE THIS IS THE COUNT OF NODES *
 *************************************/
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftNodes=countOfNodes(root.left);
        int rightNodes=countOfNodes(root.right);
        return leftNodes+rightNodes+1;
    }
/***************************************
 * //THIS IS THE CODE FOR SUM OF NODES *
 ***************************************/
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumOfNodes(root.left);
        int rightsum=sumOfNodes(root.right);
        return leftsum+rightsum+root.data;
    }
/*****************************************
 * //THIS IS THE CODE FOR FINDING HEIGHT *
 *****************************************/
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
/**********************************************************************************************
 * //THERE ARE TWO WAYS OF FINDING DIAMETER OF TREE WE ARE GOING TO TRY THE O(N2) FOORM FIRST *
 **********************************************************************************************/
public static int diameter1(Node root){
    if(root==null){
        return 0;
    }
    int D1=diameter1(root.left);
    int D2=diameter1(root.right);
    int D3=height(root.left)+height(root.right)+1;
    return Math.max(D3, Math.max(D1, D2));
}
/*******************************************************************************************************************
 * //NOW WE ARE GOING TO WRITE THE 2ND WAY OF FINDING DIAMETER THAT IS HAVING TC OD O(N) AND THIS IS BIT DIFFICULT *
 *******************************************************************************************************************/
    static class treeInfo{
        int ht;
        int diam;
        treeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public static treeInfo diameter2(Node root){
        if(root==null){
            return new treeInfo(0, 0);
        }
        treeInfo left=diameter2(root.left);
        treeInfo right=diameter2(root.right);
        int myheight=Math.max(left.ht, right.ht)+1;
        int D1=left.diam;
        int D2=right.diam;
        int D3=left.ht+right.ht+1;
        int myDiameter= Math.max(Math.max(D1, D2),D3);
        treeInfo myInfo=new treeInfo(myheight, myDiameter);
        return myInfo;

    }
    public static void main(String[] args) {
         int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
         Node root=buildtree(nodes);
         System.out.println(root.data+" ");
         System.out.println();
         preorder(root);
         System.out.println();
         Inorder(root);
         System.out.println();
         postorder(root);
         System.out.println();
         levelorder(root);
         System.out.println(countOfNodes(root));
         System.out.println(sumOfNodes(root));
         System.out.println(height(root));
         System.out.println(diameter1(root));
         System.out.println(diameter2(root).diam);

    }
    
}
