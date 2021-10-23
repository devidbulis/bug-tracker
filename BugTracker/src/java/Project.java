public class Project {
    
    private int num;
    private String name;
    private String description;
    private User[] Staff;
    private Ticket[] Tickets;
    
    
    public Project(int num, String name, String description) {
        this.num = num;
        this.name = name;
        this.description = description;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
