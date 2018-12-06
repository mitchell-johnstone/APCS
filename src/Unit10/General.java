package Unit10;

public class General extends Class{
    public String name;
    public String var;

    public General(String name, String var) {
        this.name = name;
        this.var = var;
    }

    public String generateCode(){
        String code = super.generateStructure();
        code = code.substring(0,code.length()-2) + name + code.substring(code.length()-2);
        code = code.substring(0,code.length()-1) + "\n\tString " + var + ";\n" + code.substring(code.length()-1);
        code = code.substring(0,code.length()-2) + super.generateGetter(var) + code.substring(code.length()-2);
        code = code.substring(0,code.length()-4) + "\n\t\tthis."+ var + " = var;\n\t" + code.substring(code.length()-4);
        code = code.substring(0,code.length()-2) + super.generateSetter(var) + code.substring(code.length()-2);
        code = code.substring(0,code.length()-4) + "\n\t\treturn this."+ var + ";\n\t" + code.substring(code.length()-4);
        code = code.substring(0,code.length()-2) + super.generateMethod("Test") + code.substring(code.length()-2);
        code = code.substring(0,code.length()-4) + "\n\t\tSystem.out.println(\"Testing...\")\n\t" + code.substring(code.length()-4);
        return code;
    }
}
