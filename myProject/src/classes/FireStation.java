package classes;

import interfaces.I_FireStation;

public class FireStation implements I_FireStation {
    private int number;
    private String district;
    private List<FireTruck> fireTrucks;
    private List<Ambulance> ambulances;

    public FireStation(int number, String district) {
        this.number = number;
        this.district = district;
        this.fireTrucks = new List<>();
        this.ambulances = new List<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<FireTruck> getFireTrucks() {
        return fireTrucks;
    }

    public void setFireTrucks(List<FireTruck> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }

    public List<Ambulance> getAmbulances() {
        return ambulances;
    }

    public void setAmbulances(List<Ambulance> ambulances) {
        this.ambulances = ambulances;
    }

    public boolean addVehicle(FireTruck truck) {
        return fireTrucks.append(new Node<>(truck));
    }

    public boolean addVehicle(FireTruckKinds kind) {
        return addVehicle(new FireTruck(this.number, fireTrucks.getSize() + 1, kind));
    }

    public boolean addVehicle(Ambulance ambulance) {
        return ambulances.append(new Node<>(ambulance));
    }

    public boolean addVehicle(boolean hasDoctor) {
        return addVehicle(new Ambulance(this.number, ambulances.getSize() + 1, hasDoctor));
    }

    public boolean removeVehicle(FireTruck truck) {
        for (Node<FireTruck> current = fireTrucks.getHead(); current != null; current = current.getNext()) {
            if (current.getContent().equals(truck)) {
                fireTrucks.remove(current.getContent());  
                reorderFireTruckIds();  
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Ambulance ambulance) {
        for (Node<Ambulance> current = ambulances.getHead(); current != null; current = current.getNext()) {
            if (current.getContent().equals(ambulance)) {
                ambulances.remove(current.getContent());
                reorderAmbulanceIds();  
                return true;
            }
        }
        return false;  
    }

    public boolean removeVehicle(String ID) {
        for (Node<FireTruck> current = fireTrucks.getHead(); current != null; current = current.getNext()) {
            if (current.getContent().getID().equals(ID)) {
                fireTrucks.remove(current.getContent());  
                reorderFireTruckIds();  
                return true;
            }
        }
        for (Node<Ambulance> current = ambulances.getHead(); current != null; current = current.getNext()) {
            if (current.getContent().getID().equals(ID)) {
                ambulances.remove(current.getContent());  
                reorderAmbulanceIds();  
                return true;
            }
        }
        return false;
    }

    private void reorderFireTruckIds() {
        int index = 1;
        for (Node<FireTruck> current = fireTrucks.getHead(); current != null; current = current.getNext()) {
            current.getContent().setID("101/49/" + index++);
        }
    }

    private void reorderAmbulanceIds() {
        int index = 1;
        for (Node<Ambulance> current = ambulances.getHead(); current != null; current = current.getNext()) {
            current.getContent().setID("101/83/" + index++);
        }
    }


    public void printVehicles() {
        for (Node<FireTruck> current = fireTrucks.getHead(); current != null; current = current.getNext()) {
            System.out.println(current.getContent().getID() + " - " + current.getContent().getKind());
        }
        for (Node<Ambulance> current = ambulances.getHead(); current != null; current = current.getNext()) {
            System.out.println(current.getContent().getID() + " - Ambulance");
        }
    }

    public void sortVehicles() {
        for (int i = 0; i < fireTrucks.getSize(); i++) {
            for (int j = 0; j < fireTrucks.getSize() - 1; j++) {
                if (fireTrucks.get(j).getContent().getID().compareTo(
                        fireTrucks.get(j + 1).getContent().getID()) > 0) {
                    fireTrucks.swap(j, j + 1);
                }
            }
        }
        for (int i = 0; i < ambulances.getSize(); i++) {
            for (int j = 0; j < ambulances.getSize() - 1; j++) {
                if (ambulances.get(j).getContent().getID().compareTo(
                        ambulances.get(j + 1).getContent().getID()) > 0) {
                    ambulances.swap(j, j + 1);
                }
            }
        }
    }
    
    public int getAvailableVehicleCount(FireTruckKinds kind) {
        int count = 0;
        for (int i = 0; i < fireTrucks.getSize(); i++) {
            FireTruck truck = fireTrucks.get(i).getContent();
            if (truck.getKind() == kind && truck.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public int getAvailableAmbulanceCount(boolean needsDoctor) {
        int count = 0;
        for (int i = 0; i < ambulances.getSize(); i++) {
            Ambulance ambulance = ambulances.get(i).getContent();
            if (ambulance.isAvailable() && (!needsDoctor || ambulance.getHasDoctor())) {
                count++;
            }
        }
        return count;
    }

    public FireTruck dispatchFireTruck(FireTruckKinds kind) {
        for (int i = 0; i < fireTrucks.getSize(); i++) {
            FireTruck truck = fireTrucks.get(i).getContent();
            if (truck.getKind() == kind && truck.isAvailable()) {
                truck.setAvailable(false);
                return truck;
            }
        }
        return null;
    }


    public Ambulance dispatchAmbulance(boolean needsDoctor) {
        for (int i = 0; i < ambulances.getSize(); i++) {
            Ambulance ambulance = ambulances.get(i).getContent();
            if (ambulance.isAvailable() && (!needsDoctor || ambulance.getHasDoctor())) {
                ambulance.setAvailable(false);  
                return ambulance;
            }
        }
        return null; 
    }

}