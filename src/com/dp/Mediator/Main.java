package com.dp.Mediator;
import java.util.ArrayList;
import java.util.List;

interface GroupMediator {
    void sendMessage(String msg, User user);
    void registerUser(User user);
}

class GroupMediatorImpl implements GroupMediator {
    private List<User> userList;
    public GroupMediatorImpl(){
        userList = new ArrayList<>();
    }
    @Override
    public void sendMessage(String msg, User user) {
        for (User u : userList){
            if (u != user){
                u.receiveMessage(msg);
            }
        }
    }
    @Override
    public void registerUser(User user) { this.userList.add(user); }
}

abstract class User {
    protected GroupMediator groupMediator;
    protected String userName;
    public User(GroupMediator groupMediator, String userName){
        this.groupMediator = groupMediator;
        this.userName = userName;
    }
    public abstract void sendMessage(String msg);
    public abstract void receiveMessage(String msg);
}

class UserImpl extends User {
    public UserImpl(GroupMediator groupMediator, String userName){
        super(groupMediator, userName);
    }
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sending msg from =>\t"+this.userName + " : " + msg);
        this.groupMediator.sendMessage(msg, this);
    }
    @Override
    public void receiveMessage(String msg) {
        System.out.println("Message received to =>\t" + this.userName + " : " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        GroupMediator facebookMediator = new GroupMediatorImpl();
        User dave = new UserImpl(facebookMediator, "Dave");
        User ram = new UserImpl(facebookMediator, "Ram");
        User raj = new UserImpl(facebookMediator, "Raj");
        facebookMediator.registerUser(dave);
        facebookMediator.registerUser(ram);
        facebookMediator.registerUser(raj);
        dave.sendMessage("Courses.com - check for videos ");
    }
}
