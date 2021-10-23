public class TicketLog {
    
    private int num;
    private Ticket ticket;
    private String property;
    private String oldValue;
    private String newValue;
    private Long changedDateTime;
    
    public TicketLog(int num, Ticket ticket, String property, String oldValue, String newValue){
        this.num = num;
        this.ticket = ticket;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changedDateTime = System.currentTimeMillis();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
