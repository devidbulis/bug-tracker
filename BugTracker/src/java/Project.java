public class Project {
    
    private int id;
    private String name;
    private String description;
    private User[] Staff;
    private Ticket[] Tickets;
    
    
    public Project(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User[] getStaff() {
        return Staff;
    }

    public void setStaff(User[] Staff) {
        this.Staff = Staff;
    }

    public Ticket[] getTickets() {
        return Tickets;
    }

    public void setTickets(Ticket[] Tickets) {
        this.Tickets = Tickets;
    }
}
