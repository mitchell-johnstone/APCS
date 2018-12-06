package Unit10;

public class Tester extends Class{
    public String name;
    public String[] var;

    public Tester(String name) {
        this.name = name;
    }

    public String generateCode(){
        String code = super.generateStructure();
        code = code.substring(0,code.length()-2) + name + code.substring(code.length()-2);
        code = code.substring(0,code.length()-1) + super.generatePSVM() + code.substring(code.length()-1);
        code = code.substring(0,code.length()-3) + "\n\t\tSystem.out.println(\"Hello World!\");\n\t"+code.substring(code.length()-3);
        return code;
    }
}
