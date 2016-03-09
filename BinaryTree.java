import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Nathan on 3/3/2016.
 */
public class BinaryTree {

    protected Node root;

    public void addNode(int key, String name){

        Node Pointer1= root, prev =null;
        while (Pointer1 != null){
            prev = Pointer1;
            if (Pointer1.key <key){
                Pointer1=Pointer1.rightChild;
            }//end if
            else{
                Pointer1 = Pointer1.leftChild;
            }//end else
        }//end while

            if (root == null){// you have an empty tree make your root
                root = new Node(key,name);
            }//end if you have made a tree
            else if (prev.key <key){// 1
                prev.rightChild =new Node(key,name);
            }//end else if 1
            else {
                prev.leftChild = new Node(key,name);
            }//end else






    }//end addNode

    public void addNode2(int key, String name){
                /*this is all attempt one
        //Create a new Node and initialize it
        Node newNode = new Node (key,name);

        // If there is no root this is the new root
        if (root == null){
            root = newNode;
        }//end if
        else {
            //start looking through the tree from the root to witch side the node should be set to
            Node focusNode = root;

            //future parent for the new Node

            Node parent = new Node(1,"");

            while (true){
                //root is the top parent so we start there and move down left less then right greater then

                if (key < focusNode.key){
                    // We move to the left side of the tree

                    focusNode = focusNode.leftChild;

                    //if the let child has no children

                    if (focusNode ==null){
                        //then become the left child

                        parent.leftChild = newNode;
                        return;

                    }//end inner if

                    else {// you need to add to the right side of the tree

                        focusNode = focusNode.rightChild;

                        // If the right chiled has no kids the new node becomes the chiled

                        if(focusNode == null){
                            parent.rightChild = newNode;
                            return;

                        }//end inner if
                    }//end inner else
                }//end outer if
            }// end while
        }//end else
        */
    }//end addNode2

    public Node search (Node n1, int key){
        while (n1 != null){
            if (key ==n1.key){
                return n1;
            }//end if
            else if (key < n1.key){

                n1 =n1.leftChild;
            }//end else if
            else {
                n1 =n1.rightChild;
            }//end else
        }//end while
        return null;
    } //end search

    public void breadthFirst(){
        /* ? We need this to use a Queue and the book said nothing about an import?
        Node n1 = root;
        Queue queue = new Queue;
        if (n1 != null){
            queue.enqueue(n1);
        }//end if
        while (!queue.isempty()){
            n1 = (Node) queue.dequeue();
            visit(p);
            if (n1.leftChild != null){
                queue.enpueue(n1.leftChild);
            }//end if
            if (n1.rightChild != null){//if 2
                queue.enpueue(n1.rightChild);
            }//end if 2
        }//end while
        */
    }//end breadthFirst


    //use recursion to check the tree in order
    public void inOrderTraverseTree(Node foucuseNode){
        //check the left for the for the highest value
        if (foucuseNode!= null) {
            inOrderTraverseTree(foucuseNode.leftChild);

            System.out.println(foucuseNode.toString());

            inOrderTraverseTree(foucuseNode.rightChild);
        }//end if
    }//end inOrderTraverseTree

    //use recursion to check the tree in pre order meaning looking first
    public void preOrderTraverseTree(Node foucuseNode){
        //check the left for the for the highest value
        if (foucuseNode!= null) {
            System.out.println(foucuseNode.toString());

            preOrderTraverseTree(foucuseNode.leftChild);

            preOrderTraverseTree(foucuseNode.rightChild);
        }//end if
    }//end preOrderTraverseTree

    //use recursion to check the tree in pre order meaning looking first
    public void postOrderTraverseTree(Node foucuseNode){
        //check the left for the for the highest value
        if (foucuseNode!= null) {
            postOrderTraverseTree(foucuseNode.leftChild);

            postOrderTraverseTree(foucuseNode.rightChild);

            System.out.println(foucuseNode.toString());
        }//end if
    }//end postOrderTraverseTree

    public Node findNode(int key){
        //start from the root and use the key to check witch side to move on
        Node focusNode = root;

        //use a while loop to keep looking through the tree
        while (focusNode.key != key){

            if (key < focusNode.key){
                focusNode = focusNode.leftChild;
            }//end if
            else{
                focusNode =focusNode.rightChild;
            }//end else

            if (focusNode== null){
                return  null;
            }//end if

        }//end while

        return focusNode;


    }//end findNode

    // Frome this point forward I am trying to get things frome the book to see if I can fix my coding
    //
    //
    //

    //these are from the book trying to work on getting everything together
    protected  void visit(Node n1){
        System.out.print(n1.key + " " + n1.name +"\n");
    }//end visit

    protected void preorder(Node n1){
        if (n1 != null){
            visit(n1);
            preorder(n1.leftChild);
            preorder(n1.rightChild);
        }//end if

    }//end preorder

    protected void inorder(Node n1) {
        if (n1 != null) {
            inorder(n1.leftChild);
            visit(n1);
            inorder(n1.rightChild);
        }//end if
    }//end inorder

    protected void postorder(Node n1){
        if (n1 != null){
            postorder(n1.leftChild);
            postorder(n1.rightChild);
            visit(n1);

        }//end if

    }//end postorder

    public void iterativePreorder(){
        Node n1 = root;
        Stack travStack = new Stack();
        if (n1 != null) {//outer if
            travStack.push(n1);
            while (!travStack.isEmpty()){
                n1= (Node)travStack.pop();
                visit(n1);
                if (n1.rightChild != null)
                    travStack.push(n1.rightChild);
                if (n1.leftChild != null)           //left child pushedafter right to be on the top of the stack
                    travStack.push(n1.leftChild);
            }//end while
        }//end outer if
    }//end iterativePreorder

    public void iterativePostorder(){
        Node n1 = root;
        Node n2 = root;
        Stack travStack = new Stack();
       while (n1 != null) {
            travStack.push(n1);
       for ( ; n1.leftChild !=null; n1 =n1.leftChild){
           travStack.push(n1);
       }//end for
           while (n1 != null && (n1.rightChild == null || n1.rightChild == n2)){
               visit(n1);
               n2 = n1;
               if (travStack.isEmpty()){
                   return;
               }//end if
               n1 = (Node) travStack.pop();
           }//end inner while
           travStack.push(n1);
           n1 = n1.rightChild;
        }//end outter while
    }//end iterativePreorder

    public void iterativeInorder(){
     Node n1 = root;
        Stack travStack = new Stack();
        while (n1 != null){
            while(n1 != null){
                if (n1.rightChild != null)
                    travStack.push(n1.rightChild);
                travStack.push(n1);
                n1=n1.leftChild;
            }//end inner while
            n1 =(Node) travStack.pop();
            while (!travStack.isEmpty() && n1.rightChild != null){//inner while 2
                visit(n1);
                n1 = (Node) travStack.pop();
            }//end inner while 2
            visit(n1);
            if (!travStack.isEmpty()){
                n1 = (Node)travStack.pop();
            }//end if
            else n1 = null;
        }//end outter while
    }//end iteraritiveInorder

    public void deleteByMerging(int key){
        Node temp = root;
        Node n1 = root;
        Node n2 = root;
        Node prev = null;
        while (n1 != null && n1.key != key){ //find the node that has the key
            prev = n1;
            if (n1.key < key){
                n1 = n1.rightChild;
            }//end if
            else{
                n1 = n1.leftChild;
            }//end else
        }//end while
        n2=n1;
        if (n1 != null && n1.key ==key){
            if (n2.rightChild == null){// node has no right child: its left child( if any) is attached to its parent
                n2= n2.leftChild;
            }//end inner if
            else if (n2.leftChild == null){// node has no left child its right child is attached to it's parent
                n2 = n2.rightChild;
            }//end else if
            else{// be ready for merging subtrees
                temp = n2.leftChild; // 1 move to the left
                while (temp.rightChild != null){
                    temp = temp.rightChild;// 2 move to the most right node
                }//end while
                temp.rightChild= // 3. establish the link between the right most node and the left subtree and thr right subtree
                        n2.rightChild;// ?why do they do this
                n2 =n2.leftChild;// 4.
            }//end else
            if (n1 ==root) {
                root = n2;
            }//end inner if
            else if (prev.leftChild == n1){
                prev.leftChild = n2;
            }//end else if
            else{
                prev.rightChild = n2;// 5.
            }//end else
        }//end outer if
        else if (root != null){
            System.out.println("key"+ key + "has not been found inside this tree");
        }//end else if
        else {
            System.out.println("You are looking in an empty tree please build a tree and try again");
        }//end else
    }//end deleteByMerging

    public  void deleteByCopying(int key){
        Node n1= root;
        Node n2= root;
        Node prev= null;
        while (n1 != null && n1.key != key){// find the node n1 with the key
            prev = n1;
            if (n1.key< key){
                n1= n1.rightChild;
            }//end if
            else{
                n1 =n1.leftChild;
            }//end else
        }//end while
        n2= n1;
        if (n1 != null && n1.key == key){
            if (n2.leftChild== null){
                n2= n2.leftChild;
            }//end inner if
            else if(n2.rightChild == null){
                n2 =n2.rightChild;
            }//else if
            else{
                Node temp = n2.leftChild;
                Node previous = n2;
                while (temp.rightChild != null){
                    previous =temp;
                    temp = temp.rightChild;
                }//end while
                n2.key =temp.key;
                if (previous == n2){
                    previous.leftChild = temp.leftChild;
                }//end inner if
                else{
                    previous.rightChild = temp.leftChild;
                }//end inner else
            }//end outer else
            if (n1 == root){
                root =n2;
            }//end inner if
            else if(prev.leftChild == n1){
                prev.leftChild = n2;
            }//end else if
            else{
                prev.rightChild= n2;
            }//end else
        }//end outer if
        else if( root != null){
            System.out.println("key:"+key+"has not been found");
        }//end else if
        else{
            System.out.println("You have no tree make one and try again");
        }//end else
    }//end deleteByCopying

    //used from

    public void parse(InputStream fIn) {

        int ch = 1;
        Node n1;
        int lineNum = 1;  // current parsing line number
        try {
            while (ch > -1) {  // While not end of stream
                // Step 1
                while (true)
                    if (ch > -1 && !Character.isLetter((char)ch)) // skip
                        if ((ch = fIn.read()) == '\n')           // non-letters;
                            lineNum++;
                        else break;
                if (ch == -1)
                    break;
                // Step 2
                // Now collect characters from start of a word to end of that word
                String s = "";
                while (ch > -1 && Character.isLetter((char)ch)) {
                    s += Character.toUpperCase((char)ch);
                    if ((ch = fIn.read()) == '\n')
                        lineNum++;
                }
                // Step 3
                // Insert the world into the container with current line number
                if (s.length() > 0) {
                    Word wrd = new Word(s, lineNum);
                    if ((n1 = (Word) search(wrd)) == null)  // if new word not found
                        addNode(wrd);                       // then insert it into the tree
                    else {
                        ((Word) n1).addLineNum(lineNum);    // if found
                        ((Word) n1).freq++;                 // then just add the line number
                    }
                }
            }
        } catch (IOException io) {
            System.err.println("A problem with input");
        }
    }

}//end BinaryTree
