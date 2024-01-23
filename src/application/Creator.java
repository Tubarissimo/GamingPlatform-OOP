package application;

import java.util.ArrayList;

public class Creator extends AbstractUser {
    private GameLibrary createdGames;
    private ArrayList<String> publishedUpdates;


    public Creator(String email,String password,String nickname,int age)
    {
        super(email,password,nickname,age);

        this.createdGames = new GameLibrary();
        this.publishedUpdates = new ArrayList<>();
    }

    // GETTERS
    public GameLibrary getCreatedGames() {
        return createdGames;
    }
    public ArrayList<String> getPublishedUpdates() {
        return publishedUpdates;
    }


    // SETTERS
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setAge(int age) {
        this.age = age;
    }


}
