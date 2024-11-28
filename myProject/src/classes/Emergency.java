package classes;

import interfaces.I_Emergency;

public class Emergency implements I_Emergency {
    private String location;
    private EmergencyKinds kind;
    private int casualties;
    private int casualtiesNeedsDoctor;
    private List<FireTruck> respondingFireTrucks;  
    private List<Ambulance> respondingAmbulances;  

    public Emergency(String location, EmergencyKinds kind, int casualties, int casualtiesNeedsDoctor) {
        this.location = location;
        this.kind = kind;
        this.casualties = casualties;
        this.casualtiesNeedsDoctor = casualtiesNeedsDoctor;
        this.respondingFireTrucks = new List<>();
        this.respondingAmbulances = new List<>();
        }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public EmergencyKinds getKind() {
        return kind;
    }

    @Override
    public void setKind(EmergencyKinds kind) {
        this.kind = kind;
    }

    @Override
    public int getCasualties() {
        return casualties;
    }

    @Override
    public void setCasualties(int casualties) {
    	if (casualties < 0) {
            throw new IllegalArgumentException("Casualties cannot be negative.");
        }
        this.casualties = casualties;

        if (this.casualtiesNeedsDoctor > casualties) {
            this.casualtiesNeedsDoctor = casualties;
        }
    }

    @Override
    public int getCasualtiesNeedsDoctor() {
        return casualtiesNeedsDoctor;
    }

    @Override
    public void setCasualtiesNeedsDoctor(int casualtiesNeedsDoctor) {
        this.casualtiesNeedsDoctor = casualtiesNeedsDoctor;
    }
    

    public List<FireTruck> getRespondingFireTrucks() {
        return respondingFireTrucks;
    }

    public List<Ambulance> getRespondingAmbulances() {
        return respondingAmbulances;
    }

    public void addRespondingFireTruck(FireTruck truck) {
        if (truck != null) {
            this.respondingFireTrucks.append(truck);  
        }
    }

    public void addRespondingAmbulance(Ambulance ambulance) {
        if (ambulance != null) {
            this.respondingAmbulances.append(ambulance);  
        }
    }
    
    public void decreaseCasualtiesNeedsDoctor() {
        if (casualtiesNeedsDoctor > 0) {
            casualtiesNeedsDoctor--;
        }
    }
    
    public void removeRespondingFireTruck(FireTruck truck) {
        if (truck != null) {
            this.respondingFireTrucks.remove(truck);
        }
    }
    
    public void removeRespondingAmbulance(Ambulance ambulance) {
        if (ambulance != null) {
            this.respondingAmbulances.remove(ambulance);
        }
    }
}