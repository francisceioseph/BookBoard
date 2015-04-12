package br.edu.ifce.engcomp.psi.util;

/**
 * Created by FAMÍLIA on 31/03/2015.
 */
public class UserSingleton {

    private static UserSingleton instance ;


    //this userName reference the email
    private String userName;
    private String name;

    private UserSingleton(){
        userName="";
        name="";
    }

    public static UserSingleton getInstance(){
        if(instance==null){
            instance = new UserSingleton();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
