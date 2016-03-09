/**
 * Created by Nathan on 3/3/2016.
 */
public class Node {

    protected int key;
    protected String name;

    protected Node leftChild = null;
    protected Node rightChild = null;


    Node( int key, String name){

        this.key =key;
        this.name = name;

    }//end Node constructor

    @Override
    public String toString(){

        return name+" "+key;

    }//end toString


}//end class Node
