package Unit10;

public class Class {
    public Class(){}
    public String generateGetter(String var){
        return "\n\tpublic String get" + var + "(){}\n";
    }
    public String generateSetter(String var){
        return "\n\tpublic void set" + var + "(){}\n";
    }
    public String generateMethod(String var){
        return "\n\tpublic void " + var + "(){}\n";
    }
    public String generatePSVM(){return "\n\tpublic static void main(String[] args){}\n";}
    public String generateStructure(){
        return "public class {}";
    }
}
