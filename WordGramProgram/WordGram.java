
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        int length = myWords.length;
        return length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method
        for(int k =0;k<myWords.length;k++){
            ret = ret + " " + myWords[k];
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        if(other.length() != myWords.length){
            return false;
        }
        for(int k=0; k<myWords.length;k++){
            if(myWords[k].equals(other.wordAt(k))){
                 continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) { 
        String[] answer = myWords;
        for(int k=1;k<answer.length;k++){
            answer[k-1] = answer[k];
        }
        answer[answer.length-1] = word; 
        WordGram out = new WordGram(answer, 0, answer.length);
        return out;
    }

}