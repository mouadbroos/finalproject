/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tino_
 */
package Demo;

import DAO.ConnectionFactory;
import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import java.util.Date;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourcesWeb {
    
    private int resourceID;
    private String resourceName;
    private boolean isMaintained;
    private String description;
    private LinkedList<Reservation> reservations;
    private boolean isAvailable;
    
    public ResourcesWeb(){
    
    }

    public ResourcesWeb(int id, String resourcename, String description) {
        this.resourceID = id;
        this.resourceName = resourcename;
        this.description = description;
        this.isMaintained = true;//???
        this.reservations = new LinkedList<Reservation>();
        this.isAvailable = true;

    }

    public ResourcesWeb(int id, String resourcename, String description, boolean isMaintained, boolean isAvailable, Date startDate, Date endDate) {

    }

    public int getResourceID() {
        return resourceID;
    }

    //should never use, kept for testing purposes
    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
    
    public LinkedList<ResourcesWeb> getAllUnavailableResources() {
        // Create a list of resources
        LinkedList<ResourcesWeb> resources = new LinkedList<ResourcesWeb>();
       
        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resultSet = resourcesDAO.getAllUnavailableResources();
    
  
        try {
            while (resultSet != null && resultSet.next()) {
                // Create a resource from the result set
                ResourcesWeb res = new ResourcesWeb(Integer.parseInt(resultSet.getString("resourceID")), resultSet.getString("resourceName"),
                        resultSet.getString("resourceName"));
                
                res.setMaintained(resultSet.getBoolean("isMaintained"));
                
                // Create a reservation object from the extra details in the query I got
                Reservation reserve = new Reservation(resultSet.getDate("startDate"), resultSet.getDate("endDate"), 
                                        new UsersWeb(Integer.parseInt(resultSet.getString("userID"))));
                
                // Add it to the resource
                res.addReservation(reserve);
                
                // Add the resource to the linked list
                resources.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resources;
    }

    public LinkedList<ResourcesWeb> getAllResources() {
        // Create a list of resources
        LinkedList<ResourcesWeb> resources = new LinkedList<ResourcesWeb>();

        ResourcesDAO resourcesDAO = new ResourcesDAO();
        ResultSet resourcesResultSet = resourcesDAO.getAllResources();

        // Loop through the resources
        try {
            while (resourcesResultSet != null && resourcesResultSet.next()) {
                // Create a resource from the result set
                ResourcesWeb res = new ResourcesWeb(Integer.parseInt(resourcesResultSet.getString("resourceID")), resourcesResultSet.getString("resourceName"),
                        resourcesResultSet.getString("resourceName"));
                
                res.setMaintained(resourcesResultSet.getBoolean("isMaintained"));
                

                
                // Get the last reservation for this resource
                ReservesLogDAO reservesLogDAO = new ReservesLogDAO();
                // Get the result set
                ResultSet reservationResultSet = reservesLogDAO.getLastReservationByID(Integer.parseInt(resourcesResultSet.getString("resourceID")));
                
                // Get the next (should only be one
                while (reservationResultSet != null && reservationResultSet.next()) {                      
                    // Create an object with it
                    Reservation reserve = new Reservation(reservationResultSet.getDate("startDate"), reservationResultSet.getDate("endDate"), 
                                            new UsersWeb(Integer.parseInt(reservationResultSet.getString("userID"))));
                    
                    // See if it's an active reservation
                    Date now = new Date();
                    if(reservationResultSet.getDate("startDate").before(now) && reservationResultSet.getDate("endDate").after(now)) {
                        res.setAvailable(false);
                    }
                    
                    // Add it to the list of reservations for this resource
                    res.addReservation(reserve);
                }
                

                // Add it to the linked list
                resources.add(res);                                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the resources
        return resources;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getMaintained() {
        return isMaintained;
    }

    public void setMaintained(boolean isMaintained) {
        this.isMaintained = isMaintained;
    }

    public String getDescription() {
        return description + " isMaintained:\t" + isMaintained + " isAvailable:\t" + isAvailable;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addReservation(Reservation reserve) {
        this.reservations.add(reserve);
    }

    /*public void reserve(Date start, Date end, EndUser user, Date currentDate) {      
        reservations.add(new Reservation(start, end, user));
        if (start.before(currentDate) && end.after(currentDate)) {
            status = Status.RESERVED;
        }
    }*/
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

    // Other methods
    public String classAsString() {
        return resourceName;
    }

    public String descriptionString() {
        return getDescription();
    }
}
