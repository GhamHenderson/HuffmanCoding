package HuffmanProject;
import static java.lang.System.out;
public class encodeHuffman {

    /**
     * This function takes a character and encodes it using the huffman tree.
     * @param root
     * @param word
     * @param c
     * @return
     */
    public String encodeChar(TreeNode root, String word, char c){
        TreeNode currentNode = root;
        char leaf = '.';
        //While Node is not null.
        if(currentNode != null) {
            if(((HuffItem) currentNode.getItem()).getSymbol() == c ) {
                leaf = ((HuffItem) currentNode.getItem()).getSymbol();
                out.println("The encoding for " + leaf + " is  = " + word + "");
            }
            encodeChar(currentNode.getLeft(), word + "0", c );
            encodeChar(currentNode.getRight(), word + "1", c );
        }
        return word;
    }

    public String encodeString(TreeNode root, String word, String wordinput){
        TreeNode currentNode = root;
        char leaf = '.';
        //While Node is not null.
        for(int i = 0; i < wordinput.length(); i++) {
            if (currentNode != null) {
                if (((HuffItem) currentNode.getItem()).getSymbol() == wordinput.charAt(i)) {
                    leaf = ((HuffItem) currentNode.getItem()).getSymbol();
                    out.println("The encoding for " + leaf + " is  = " + word + " \n");
                }
                encodeChar(currentNode.getLeft(), word + "0", wordinput.charAt(i));
                encodeChar(currentNode.getRight(), word + "1", wordinput.charAt(i));
            }
        }
        return word;
    }


    String bin;
    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBin() {
        return bin;
    }
}
