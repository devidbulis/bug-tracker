public class Developer extends User {
    
    private String name;
    private String email;
    private String password;
    private String role;
    
    public Developer(String name, String email, String password, String role) {
        super(name,email,password,role="Developer");
    }
}
