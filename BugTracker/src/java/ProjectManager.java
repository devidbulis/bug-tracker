public class ProjectManager extends User {
    
    private String name;
    private String email;
    private String password;
    private String role;
    
    public ProjectManager(String name, String email, String password, String role) {
        super(name,email,password,role="Project Manager");
    }
}
