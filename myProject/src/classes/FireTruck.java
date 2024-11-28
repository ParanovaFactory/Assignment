package classes;

import interfaces.I_FireTruck;

public class FireTruck implements I_FireTruck {
    private String ID;
    private FireTruckKinds kind;
    private boolean isAvailable = true;

    public FireTruck(int stationNumber, int truckNumber, FireTruckKinds kind) {
        this.ID = stationNumber + "/49/" + truckNumber;
        this.kind = kind;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public FireTruckKinds getKind() {
        return kind;
    }

    @Override
    public void setKind(FireTruckKinds kind) {
        this.kind = kind;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 

        FireTruck other = (FireTruck) obj;
        return this.ID != null && this.ID.equals(other.ID); 
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0; 
    }
}