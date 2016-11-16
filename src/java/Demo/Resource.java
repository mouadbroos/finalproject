
package Demo;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Resource {
    
    public enum Status {AVAILABLE, RESERVED};
    
    private String id; // will be replaced with HashMap key in the actual implementation
    private Status status;
    private HashMap<String, String> attributes;
    private LinkedList<Reservation> reservations;
        
    private Date currentDate;
    
    public Resource(String id) {
        this.id = id;
        status = Status.AVAILABLE;
        attributes = new HashMap<>();
        reservations = new LinkedList<Reservation>();
    }
      
    public void reserve(Date start, Date end, EndUser user, Date currentDate) {      
        reservations.add(new Reservation(start, end, user));
        if (start.before(currentDate) && end.after(currentDate)) {
            status = Status.RESERVED;
        }
    }
    
    /**
     * 
     * @return null if the resource has never been reserved 
     */
    public Reservation getLastReservation() {
        Reservation lastReservation = null;
        
        if (reservations.isEmpty()) {
            return lastReservation;
        } else {
            lastReservation = reservations.getFirst();
        }
        
        for (Reservation reservation : reservations) {
            if (reservation.getStart().before(lastReservation.getStart())) {
                lastReservation = reservation;
            }
        }
        return lastReservation;
    }
    
    public LinkedList<Reservation> getReservations() {
        return reservations;
    }
    
    public String getID() {
        return id;
    }
    
    public String classAsString() {
        return "Resource";
    }
    
    public String descriptionString() {
        return "Resource description";
    }
    
    public HashMap<String, String> getAttributes() {
        return attributes;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status newStatus) {
        status = newStatus;
    }
}
