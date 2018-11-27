package Unit09;

public class Singer implements Speaker{
    private int age;
    private String musicType;

    public Singer(int age, String musicType) {
        this.age = age;
        this.musicType = musicType;
    }

    public int getAge() {
        return age;
    }

    public String getMusicType() {
        return musicType;
    }

    public void speak(){
        System.out.println("My Country Tis' of thee... ");
    }
}
