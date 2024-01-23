package application;

import java.util.ArrayList;

public class AbstractUser {
    protected String email;
    protected String password;
    protected String nickname;
    protected int age;
    protected ArrayList<String> sentChatMessages;
    protected ArrayList<String> receivedChatMessages;

    public AbstractUser(String email, String password, String nickname, int age)
    {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.sentChatMessages = new ArrayList<>();
        this.receivedChatMessages = new ArrayList<>();
    }

    // GETTERS
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
    }
    public ArrayList<String> getSentChatMessages() {
        return sentChatMessages;
    }
    public ArrayList<String> getReceivedChatMessages() {
        return receivedChatMessages;
    }

}
