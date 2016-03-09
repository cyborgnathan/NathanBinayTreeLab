import java.io.*;

public class Main {


    public static void main(String[] args) {
	// this is what I have working thus far
        BinaryTree BT = new BinaryTree();
        // you need to take a file and input it into a string
        String fileName = "";
        InputStream fIn;
        BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in));

        try {
            if (args.length == 0) {
                System.out.print("Enter a file name: ");  // get file to read from
                fileName = buffer.readLine();
                fIn = new FileInputStream(fileName);
            }
            else {
                fIn = new FileInputStream(args[0]);
                fileName = args[0];
            }

            // create a new tree
            // Phase 1 - parse the file for all words and add the words to this tree
            BT.parse(fIn);
            // Phase 2 - display the built tree
            BT.displayTree(fileName);

            fIn.close();
        } catch(IOException io) {
            System.err.println("Cannot open " + fileName);
        }
    }//end main

    public void commentCode(){
        /*
        BT.addNode(12, "Jake");
        BT.addNode(15, "Dave");
        BT.addNode(10, "Kate");
        BT.addNode(13, "Jim");
        BT.addNode(17, "Nick");
        BT.addNode(20, "Mort");
        BT.addNode(25, "Lee");
        BT.addNode(35, "Stan");
        BT.addNode(45, "Pete");

        BT.findNode(10);
        BT.inOrderTraverseTree(BT.root);
        System.out.printf("\n");
        BT.deleteByCopying(10);
        BT.deleteByCopying(17);
        BT.inOrderTraverseTree(BT.root);
        BT.preOrderTraverseTree(BT.root);
        System.out.printf("\n");
        BT.postOrderTraverseTree(BT.root);
        System.out.printf("\n");
        System.out.println(BT.findNode(12));
        BT.iterativeInorder();
        System.out.println();
        BT.iterativePostorder();
        System.out.println();
        BT.iterativePreorder();

         */
    }//end commentCode

}//end class Main
