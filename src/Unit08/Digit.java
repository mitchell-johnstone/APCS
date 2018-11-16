package Unit08;

public class Digit {
    private static final int[] WEIGHT = {7,4,2,1,0};
    private String number = "";
    private String barcode = "";
    public Digit(String s){
        try{
            Integer.parseInt(s);
            number = s;
            convertToBar();
        } catch(NumberFormatException e){
            barcode = s;
            convertToNum();
        }
    }

    private void convertToBar(){
        int n = Integer.parseInt(number);
        n=n==0?11:n;
        int[] bar = new int[5];
        if(n==1||n==2||n==4||n==7){
            bar[4]=1;
        }
        for (int i = 0; i<4; i++) {
            if(n/WEIGHT[i]>0){
                bar[i] = 1;
                n-=i;
            } else {
                bar[i]=0;
            }
        }
        String tmp = "";
        for(int i: bar){
            if(i==1){
                tmp+="|";
            } else {
                tmp+=":";
            }
        }
        barcode = tmp;
    }

    private void convertToNum(){
        int [] tmp = new int[barcode.length()];
        for (int i = 0; i < barcode.length(); i++) {
            tmp[i] = barcode.charAt(i)=='|'?1:0;
        }
        int total = 0;
        for (int i = 0; i < tmp.length; i++) {
            total += tmp[i]*WEIGHT[i];
        }
        number = Integer.toString(total==11?0:total);
    }

    public String getNumber() {
        return number;
    }

    public String getBarcode() {
        return barcode;
    }
}
