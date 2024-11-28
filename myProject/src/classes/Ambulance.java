package classes;

import interfaces.I_Ambulance;

public class Ambulance implements I_Ambulance {
    private String ID;
    private boolean hasDoctor;
    private boolean isAvailable = true;

    public Ambulance(int stationNumber, int ambulanceNumber, boolean hasDoctor) {
        this.hasDoctor = hasDoctor;
        this.ID = stationNumber + "/" + (hasDoctor ? "81" : "83") + "/" + ambulanceNumber;
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
    public boolean getHasDoctor() {
        return hasDoctor;
    }

    @Override
    public void setHasDoctor(boolean hasDoctor) {
        this.hasDoctor = hasDoctor;
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
        Ambulance other = (Ambulance) obj;
        return this.ID != null && this.ID.equals(other.ID);
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    public boolean getHasDoctorStatus() {
        return hasDoctor;
    }
}
