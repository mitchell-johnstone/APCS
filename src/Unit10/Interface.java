package Unit10;

public class Interface extends Class{
    public String name;
    public String var1;

    public Interface(String name, String var1) {
        this.name = name;
        this.var1 = var1;
    }

    public String generateCode(){
        String code = super.generateStructure();
        code = code.substring(0,code.length()-2) + name + " extends interface" + code.substring(code.length()-2);
        code = code.substring(0,code.length()-1) + super.generateMethod(var1) + code.substring(code.length()-1);
        return code;
    }
}
