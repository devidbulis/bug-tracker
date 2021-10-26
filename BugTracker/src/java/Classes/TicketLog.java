package Classes;

public class TicketLog {
    
    private int id;
    private Ticket ticket;
    private String property;
    private String oldValue;
    private String newValue;
    private Long changedDateTime;
    
    public TicketLog(int id, Ticket ticket, String property, String oldValue, String newValue){
        this.id = id;
        this.ticket = ticket;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changedDateTime = System.currentTimeMillis();
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Long getChangedDateTime() {
        return changedDateTime;
    }

    public void setChangedDateTime(Long changedDateTime) {
        this.changedDateTime = changedDateTime;
    }
}
