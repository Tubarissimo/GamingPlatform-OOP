package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CreatorDatabase {
    private ArrayList<Creator> creatorList;
    private Creator connectedUser;
    private ArrayList<String> updateList;

    public CreatorDatabase()
    {
        this.creatorList = new ArrayList<>();
        this.connectedUser = null;
        this.updateList = new ArrayList<>();
    }

    // getters
    public ArrayList<Creator> getCreatorList() {
        return creatorList;
    }
    public Creator getConnectedUser() {
        return connectedUser;
    }

    // setters
    public void setConnectedUser(Creator connectedUser) {
        this.connectedUser = connectedUser;
    }

    public void registerUser()
    {
        Creator newUser = new Creator(null, null, null, 0);
        Scanner in = new Scanner(System.in);
        System.out.println("How old are you: ");
        newUser.setAge(in.nextInt());
        if (newUser.getAge() < 18)
        {
            System.out.println("You're a minor, you don't have permission to create a creator account!!!");
            return;
        }
        System.out.println("Type your e-mail adress: ");
        newUser.setEmail(in.nextLine());
        System.out.println("Type your password: ");
        newUser.setPassword(in.nextLine());
        System.out.println("Type your user nickname: ");
        newUser.setNickname(in.nextLine());
        creatorList.add(newUser);
        System.out.println("New user created successfully!\n");
    }

    public Creator validateUser(String email, String password) {
        for (Creator user : creatorList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Creator searchUser(String nickname) {
        for (Creator user : creatorList) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public void login()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Type your e-mail adress: ");
        String emailString = in.nextLine();
        System.out.println("Type your password: ");
        String passwordString = in.nextLine();
        
        if (validateUser(emailString, passwordString) != null)
        {
            setConnectedUser(validateUser(emailString, passwordString));
            System.out.println("Logged in successfully!\n");
        }
        else
        {
            System.out.println("User not found\n");
        }
    }

    public void logout()
    {
        setConnectedUser(null);
    }

    public void sendMessage(Creator user)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Write the nickname of the user you wanna chat: ");
        String searchedUser = in.nextLine();

        if (searchUser(searchedUser) == null)
        {
            System.out.println("User not found\n");
            return;
        }

        System.out.println("Type the message tou wanna send to this user: ");
        String message = in.nextLine();

        StringBuilder messageBuilder = new StringBuilder();

        messageBuilder.append("\n\t[ ").append(getConnectedUser().getNickname()).append(" ]\n").append(message).append("\n\n");

        user.getSentChatMessages().add(messageBuilder.toString());
        searchUser(searchedUser).getReceivedChatMessages().add(messageBuilder.toString());

        System.out.println("Message sent succesfully\n");
    }

    public String showSentMessages(Creator user)
    {
        StringBuilder messageString = new StringBuilder();

        if (user.getSentChatMessages().isEmpty() == true)
        {
            return "You have no sent messages\n";
        }
        else
        {
            for (String message : user.getSentChatMessages()) {
                messageString.append(message);
            }
            
            return messageString.toString();
        }
    }

    public String showReceivedMessages(Creator user)
    {
        StringBuilder messageString = new StringBuilder();

        if (user.getReceivedChatMessages().isEmpty() == true)
        {
            return "You have no messages\n";
        }
        else
        {
            for (String message : user.getReceivedChatMessages()) {
                messageString.append(message);
            }
            
            return messageString.toString();
        }
    }

    public void publishUpdates(Creator user)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Type the message of the update you did: ");
        String message = in.nextLine();

        StringBuilder messageBuilder = new StringBuilder();

        messageBuilder.append("\n\t[ ").append(getConnectedUser().getNickname()).append("'s update ]\n").append(message).append("\n\n");

        this.updateList.add(messageBuilder.toString());
        user.getPublishedUpdates().add(messageBuilder.toString());

        System.out.println("Update sent succesfully\n");
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();

        for (Creator user : creatorList) {
            userString.append(user);
        }

        return userString.toString();
    }
}
