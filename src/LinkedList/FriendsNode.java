package LinkedList;

public class FriendsNode {
    private String name;
    private String nickname;
    private int age;
    private int numOfFriends;

    public FriendsNode(String name, String nickname, int age, int numOfFriends) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.numOfFriends = numOfFriends;
    }

    /**methods for normal class **/
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getNumOfFriends() {
        return numOfFriends;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumOfFriends(int numOfFriends) {
        this.numOfFriends = numOfFriends;
    }

    @Override
    public String toString() {
        return "FriendsNode{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", numOfFriends=" + numOfFriends +
                '}';
    }
}
