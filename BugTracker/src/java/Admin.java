public class Admin extends User {
    
    private String name;
    private String email;
    private String password;
    private String role;
    
    public Admin(String name, String email, String password, String role) {
        super(name,email,password,role="Admin");
    }
}
