package Unit13;

public class Sentence {
    public String sentence;
    public int length;

    public Sentence(String sentence) {
        this.sentence = sentence;
        length = sentence.length();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
        length=sentence.length();
    }

    public void reverse(int a, int b){
        Sentence tmp = new Sentence(sentence.substring(a,b));
        tmp.reverse();
        sentence = sentence.substring(0,a) + tmp.getSentence() + sentence.substring(b);
    }

    public void reverse(){
        if(length>0) {
            String t = sentence.substring(0, 1);
            Sentence n = new Sentence(sentence.substring(1));
            n.reverse();
            this.sentence = n.getSentence() + t;
        }
    }

    public boolean find(String t){
        if(t.length()>=sentence.length()){
            return false;
        } else if(t.equalsIgnoreCase(sentence.substring(0,3))){
            return true;
        } else {
            return (new Sentence(sentence.substring(1))).find(t);
        }
    }

    public int indexOf(String t){
        if(t.length()>=sentence.length()){
            return -1;
        } else if(t.equalsIgnoreCase(sentence.substring(0,t.length()))){
            return 0;
        } else {
            return 1 + (new Sentence(sentence.substring(1))).indexOf(t);
        }
    }

//    public int indexOf(String t){
//        int index = 0;
//        return indexOf(t, 0);
//    }
}
