package HuffmanProject;
public class decodeHuff {
    /**
     * This Method takes a binary String and decodes it into a word.
     * @return`
     */
    public String decode(TreeNode root, String word){

        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; ++i) {
            if (characters[i] == '0') { // left child
                root = root.getLeft();
            } else { // right child
                root = root.getRight();
            }
        }
        String returnword = "";
        returnword = returnword + ((HuffItem) root.getItem()).getSymbol();
        return returnword;
    }
}

