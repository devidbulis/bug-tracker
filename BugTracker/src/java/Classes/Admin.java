package Classes;


import Classes.User;

public class Admin extends User {
    
    public Admin(String name, String email, String password, String role) {
        super(name,email,password,role="Admin");
    }
}