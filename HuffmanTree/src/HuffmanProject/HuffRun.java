package HuffmanProject;


/**
 * The following class will create a Huffman Tree.
 *  By Graham Henderson B00130193
 */
public class HuffRun {
    public static String input = "";
    public static TreeNode root;
    public static void main(String[] args) {
        //Run the Frame
        startGUI();

        // Instantiate Classes
        encodeHuffman huffEncode = new encodeHuffman();
        ListArrayBased freqTable = new ListArrayBased();
        buildTree tree = new buildTree();

        // Build Tree
        root = tree.build(freqTable);
        huffEncode.encodeChar(root, input, 'A');
        decodeHuff huffDecode = new decodeHuff();
       // huffDecode.decode(root, huffEncode.getBin());

    }

    public static void startGUI(){
        HuffFrame window = new HuffFrame();
        window.frame.setVisible(true);
    }
}



