import java.util.*;
public class binarytree1 {
        static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        }
    }
        static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
        idx++;
        if(nodes[idx] == -1) {
        return null; 
    }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
        }
    }

    //PREORDER TRAVERSAL...
    public static void preorder(Node root) {
        if(root == null) {
        System.out.print(-1+" ");
        return;
    }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

    //INORDER TRAVERSAL....
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //POSTORDER TRAVERSAL...
       public static void postorder(Node root){
           if(root == null){
              return;
           }
           postorder(root.left);
           postorder(root.right);
           System.out.print(root.data+" ");

       }
        
    //LEVEL ORDER TRAEVRSAL...
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node>q = new LinkedList<>();
              q.add(root);
              q.add(null);

              while(!q.isEmpty()){
                  Node currNode = q.remove();
                  if(currNode == null){
                     System.out.println();
                     if(q.isEmpty()){
                         break;
                     }
                     else{
                         q.add(null);
                    }
                }else {
                        System.out.println(currNode.data);
                        if(currNode.left != null){
                            q.add(currNode.left);
                        }
                        if(currNode.right != null){
                            q.add(currNode.right);
                        }
                    }
                }

            }

            //count of nodes ....

            public static int countOfNOdes(Node root){
                  if(root == null){
                      return 0;
                  }
                  int leftNodes = countOfNOdes(root.left);
                  int rightNodes = countOfNOdes(root.right);
                  return leftNodes + rightNodes +1;
                }
                //height of tree...
                public static int height(Node root){
                    if(root == null){
                        return 0 ;
                    }
                    int leftheight = height(root.left);
                    int rightHeight = height(root.right);
                    int myHeight = Math.max(leftheight, rightHeight);
                        return myHeight;
                }


                //diameter of nodes apporach 1....
                public static int diameter(Node root){
                    if(root == null){
                        return 0 ;
                    }
                    int diam1 = height(root.left) + height(root.right) + 1;
                    int diam2 = diameter(root.left);
                    int diam3 = diameter(root.right);
                    return Math.max(diam1, Math.max(diam2, diam3));
                }
            
        public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preorder(root);
        postorder(root);
        inorder(root);
        levelOrder(root);
        System.out.println(countOfNOdes(root));
        System.out.println(height(root));
    }
}

