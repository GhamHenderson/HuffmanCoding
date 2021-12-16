package HuffmanProject;

public class HuffItem {
    int freq;
    char symbol;

    public HuffItem(int freq, char symbol) {
        this.freq = freq;
        this.symbol = symbol;
    }

    public int getFreq() {
        return freq;
    }
    public char getSymbol() {
        return symbol;
    }
}
