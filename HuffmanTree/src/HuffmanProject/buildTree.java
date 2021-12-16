package HuffmanProject;

import static java.lang.System.out;

public class buildTree {
    /**
     * This Method takes in input from a file and then creates the huffman tree.
     * @param freqTable
     * @return
     */
    public TreeNode build(ListArrayBased freqTable) {
        Reader read = new Reader();
        // Give the reader the file location.
        char[] charArray = read.readChar("src/HuffmanProject/LetterCount.txt");
        int[] frequencyArray = read.readInt("src/HuffmanProject/FreqCount.txt");

        //out.println("---- Frequency Table ----");
        for (int j = 0; j < 26; j++) {
            // Add each item to a Node
            freqTable.add((j + 1), new TreeNode(new HuffItem(frequencyArray[j], charArray[j])));
            //   out.println(((HuffItem) ((TreeNode) freqTable.get(j + 1)).getItem()).getSymbol() + " = " + ((HuffItem) ((TreeNode) freqTable.get(j + 1)).getItem()).getFreq());
        }

        //  out.println("\n ---- Huffman Tree Creation ----");
        int leftFrequency = 0;
        int rightFrequency = 0;
        TreeNode parentNode = null;
        while (freqTable.size() > 1) {
            leftFrequency = ((HuffItem) ((TreeNode) freqTable.get(1)).getItem()).getFreq();
            rightFrequency = ((HuffItem) ((TreeNode) freqTable.get(2)).getItem()).getFreq();
            TreeNode leftNode = (TreeNode) freqTable.get(1);
            TreeNode rightNode = (TreeNode) freqTable.get(2);

            // Create Parent Node with 2 added frequencies and '*' as symbol.
            parentNode = new TreeNode(new HuffItem((leftFrequency + rightFrequency), '*'), leftNode, rightNode);

            freqTable.remove(1);
            freqTable.remove(1);

            //add Parent Node to end of the table.
            freqTable.add(freqTable.size() + 1, parentNode);

            freqTable.Sort();
            for(int i = 1; i <= freqTable.size(); i++) {
                out.println(((HuffItem) ((TreeNode) freqTable.get(i)).getItem()).getSymbol() + " = " + ((HuffItem) ((TreeNode) freqTable.get(i)).getItem()).getFreq());

            }
            out.println("");
        }
        return parentNode;
    }
}
