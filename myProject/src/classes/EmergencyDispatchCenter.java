package classes;

import interfaces.I_EmergencyDispatchCenter;

public class EmergencyDispatchCenter implements I_EmergencyDispatchCenter {
    private List<FireStation> fireStations;
    private List<Emergency> emergencies;

    public EmergencyDispatchCenter() {
        this.fireStations = new List<>();
        this.emergencies = new List<>();
    }

    private <T> boolean appendToList(List<T> list, T item) {
        Node<T> newNode = new Node<>(item);
        return list.append(newNode);
    }

    @Override
    public List<FireStation> getFireStations() {
        return fireStations;
    }

    @Override
    public void setFireStations(List<FireStation> fireStations) {
        this.fireStations = fireStations;
    }

    @Override
    public List<Emergency> getEmergencies() {
        return emergencies;
    }

    @Override
    public void setEmergencies(List<Emergency> emergencies) {
        this.emergencies = emergencies;
    }

    @Override
    public boolean addFireStation(FireStation station) {
        return appendToList(fireStations, station);
    }

    @Override
    public Emergency newCall(String location, EmergencyKinds kind, int patients, int patientsDoc) {
        return new Emergency(location, kind, patients, patientsDoc);
    }

    @Override
    public boolean addCalltoList(Emergency call) {
        return appendToList(emergencies, call);
    }
    @Override
    public void sortCalls() {
        for (int i = 0; i < emergencies.getSize() - 1; i++) {
            for (int j = 0; j < emergencies.getSize() - i - 1; j++) {
                Emergency e1 = emergencies.get(j).getContent();
                Emergency e2 = emergencies.get(j + 1).getContent();
                if (e1.getKind().ordinal() < e2.getKind().ordinal()) {
                    emergencies.swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortVehicles() {
        for (int i = 0; i < fireStations.getSize(); i++) {
            fireStations.get(i).getContent().sortVehicles();
        }
    }

    @Override
    public void printRespondingVehicles(Emergency call) {
        System.out.println("To " + call.getKind() + " in " + call.getLocation() + " is responding:");
        classes.List<FireTruck> fireTrucks = call.getRespondingFireTrucks();
        classes.List<Ambulance> ambulances = call.getRespondingAmbulances();

        for (int i = 0; i < fireTrucks.getSize(); i++) {
            FireTruck truck = fireTrucks.get(i).getContent();
            System.out.println(truck.getID() + " - " + truck.getKind());
        }

        for (int i = 0; i < ambulances.getSize(); i++) {
            Ambulance ambulance = ambulances.get(i).getContent();
            System.out.println(ambulance.getID() + " - Ambulance" + 
                (ambulance.getHasDoctor() ? " (with Doctor)" : ""));
        }
    }

    @Override
    public boolean addVehicle(int station, boolean hasDoctor) {
        if (station >= 1 && station <= fireStations.getSize()) {
            FireStation fs = fireStations.get(station - 1).getContent();
            Ambulance ambulance = new Ambulance(station, fs.getAmbulances().getSize() + 1, hasDoctor);
            return fs.addVehicle(ambulance);
        }
        return false;
    }

    @Override
    public boolean addVehicle(int station, FireTruckKinds kind) {
        if (station >= 1 && station <= fireStations.getSize()) {
            FireStation fs = fireStations.get(station - 1).getContent();
            FireTruck fireTruck = new FireTruck(station, fs.getFireTrucks().getSize() + 1, kind);
            return fs.addVehicle(fireTruck);
        }
        return false;
    }

    @Override
    public boolean removeVehicle(String ID) {
        for (int i = 0; i < fireStations.getSize(); i++) {
            FireStation station = fireStations.get(i).getContent();
            if (station.removeVehicle(ID)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean dispatchVehicles() {
        if (emergencies.getSize() == 0 || fireStations.getSize() == 0) {
            return false;
        }

        sortCalls(); // Assuming this sorts emergencies based on priority
        sortVehicles(); // Assuming this sorts available vehicles

        for (int i = 0; i < emergencies.getSize(); i++) {
            Emergency emergency = emergencies.get(i).getContent();

            switch (emergency.getKind()) {
                case FireSmall:
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 1);
                    break;
                case TechnicalEmergencySmall:
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.LadderTruck, 1);
                    break;
                case HazmatEmergencySmall:
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 2);
                    break;
                case FireMiddle:
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 3);
                    dispatchFireTruck(emergency, FireTruckKinds.LadderTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case TechnicalEmergencyMiddle:
                    dispatchFireTruck(emergency, FireTruckKinds.RescueTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 2);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case HazmatEmergencyMiddle:
                    dispatchFireTruck(emergency, FireTruckKinds.HazmatTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.RescueTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 2);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case FireLarge:
                    dispatchFireTruck(emergency, FireTruckKinds.RescueTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 5);
                    dispatchFireTruck(emergency, FireTruckKinds.LadderTruck, 2);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case TechnicalEmergencyLarge:
                    dispatchFireTruck(emergency, FireTruckKinds.RescueTruck, 2);
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 4);
                    dispatchFireTruck(emergency, FireTruckKinds.LadderTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case HazmatEmergencyLarge:
                    dispatchFireTruck(emergency, FireTruckKinds.HazmatTruck, 2);
                    dispatchFireTruck(emergency, FireTruckKinds.RescueTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.FireEngine, 4);
                    dispatchFireTruck(emergency, FireTruckKinds.LadderTruck, 1);
                    dispatchFireTruck(emergency, FireTruckKinds.CommandVehicle, 1);
                    break;
                case MedicalEmergency:
                    int casualties = emergency.getCasualties();
                    for (int j = 0; j < casualties; j++) {
                        boolean needsDoctor = emergency.getCasualtiesNeedsDoctor() > 0;
                        if (needsDoctor) {
                            dispatchAmbulance(emergency, true);
                            emergency.decreaseCasualtiesNeedsDoctor();
                        } else {
                            dispatchAmbulance(emergency, false);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }


    private void dispatchFireTruck(Emergency emergency, FireTruckKinds kind, int count) {
        int dispatched = 0;
        for (int i = 0; i < fireStations.getSize() && dispatched < count; i++) {
            FireStation station = fireStations.get(i).getContent();
            int available = station.getAvailableVehicleCount(kind);
            for (int j = 0; j < available && dispatched < count; j++) {
                FireTruck truck = station.dispatchFireTruck(kind);
                if (truck != null) {
                    emergency.addRespondingFireTruck(truck);
                    dispatched++;
                }
            }
        }
    }

    private void dispatchAmbulance(Emergency emergency, boolean needsDoctor) {
        for (int i = 0; i < fireStations.getSize(); i++) {
            FireStation station = fireStations.get(i).getContent();
            if (station.getAvailableAmbulanceCount(needsDoctor) > 0) {
                Ambulance ambulance = station.dispatchAmbulance(needsDoctor);
                if (ambulance != null) {
                    emergency.addRespondingAmbulance(ambulance);
                    return;
                }
            }
        }
    }
    
}