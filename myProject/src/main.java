import classes.*;
import tests.*;
public class main {
    public static void main(String[] args) {
    	/*
    	Ambulance ambulance1 = new Ambulance(1, 101, true); 
        
        System.out.println("Initial Attributes of ambulance1:");
        System.out.println("Ambulance ID: " + ambulance1.getID()); 
        System.out.println("Has Doctor: " + ambulance1.getHasDoctor()); 
        System.out.println("Is Available: " + ambulance1.isAvailable());
        
        ambulance1.setID("2/83/202");
        ambulance1.setHasDoctor(false); 
        ambulance1.setAvailable(false); 
        
        System.out.println("\nUpdated Attributes of ambulance1:");
        System.out.println("Updated Ambulance ID: " + ambulance1.getID()); 
        System.out.println("Updated Has Doctor: " + ambulance1.getHasDoctor()); 
        System.out.println("Updated Is Available: " + ambulance1.isAvailable()); 
        
        Ambulance ambulance2 = new Ambulance(1, 101, true); 
        
        System.out.println("\nComparing ambulance1 with ambulance2:");
        System.out.println("Are they equal? " + ambulance1.equals(ambulance2)); 
        System.out.println("ambulance1 hashCode: " + ambulance1.hashCode());
        System.out.println("ambulance2 hashCode: " + ambulance2.hashCode());
        
    	
    	EmergencyKinds emergencyKind = EmergencyKinds.FireSmall;

        Emergency emergency = new Emergency("123 Main Street", emergencyKind, 10, 5);

        System.out.println("Initial Emergency Attributes:");
        System.out.println("Location: " + emergency.getLocation());
        System.out.println("Emergency Kind: " + emergency.getKind());
        System.out.println("Casualties: " + emergency.getCasualties());
        System.out.println("Casualties Needing Doctor: " + emergency.getCasualtiesNeedsDoctor());

        switch (emergencyKind) {
            case FireSmall:
                emergency.addRespondingFireTruck(new FireTruck(1, 101, FireTruckKinds.FireEngine));
                break;

            case TechnicalEmergencySmall:
                emergency.addRespondingFireTruck(new FireTruck(1, 102, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 103, FireTruckKinds.LadderTruck));
                break;

            case HazmatEmergencySmall:
                emergency.addRespondingFireTruck(new FireTruck(1, 104, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 105, FireTruckKinds.FireEngine));
                break;

            case FireMiddle:
                emergency.addRespondingFireTruck(new FireTruck(1, 106, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 107, FireTruckKinds.LadderTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 108, FireTruckKinds.CommandVehicle));
                break;

            case TechnicalEmergencyMiddle:
                emergency.addRespondingFireTruck(new FireTruck(1, 109, FireTruckKinds.RescueTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 110, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 111, FireTruckKinds.CommandVehicle));
                break;

            case HazmatEmergencyMiddle:
                emergency.addRespondingFireTruck(new FireTruck(1, 112, FireTruckKinds.HazmatTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 113, FireTruckKinds.RescueTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 114, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 115, FireTruckKinds.FireEngine));
                break;

            case FireLarge:
                emergency.addRespondingFireTruck(new FireTruck(1, 116, FireTruckKinds.RescueTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 117, FireTruckKinds.FireEngine));
                emergency.addRespondingFireTruck(new FireTruck(1, 118, FireTruckKinds.LadderTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 119, FireTruckKinds.CommandVehicle));
                break;

            case TechnicalEmergencyLarge:
                emergency.addRespondingFireTruck(new FireTruck(1, 120, FireTruckKinds.RescueTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 121, FireTruckKinds.RescueTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 122, FireTruckKinds.FireEngine));
                break;

            case HazmatEmergencyLarge:
                emergency.addRespondingFireTruck(new FireTruck(1, 123, FireTruckKinds.HazmatTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 124, FireTruckKinds.HazmatTruck));
                emergency.addRespondingFireTruck(new FireTruck(1, 125, FireTruckKinds.CommandVehicle));
                break;

            case MedicalEmergency:
                break;
        }

        System.out.println("\nResponding Fire Trucks: " + emergency.getRespondingFireTrucks().getSize());
        System.out.println("Responding Ambulances: " + emergency.getRespondingAmbulances().getSize());
    	
    	
        FireTruck fireTruck1 = new FireTruck(1, 101, FireTruckKinds.FireEngine);

        System.out.println("Fire Truck ID: " + fireTruck1.getID());
        System.out.println("Fire Truck Kind: " + fireTruck1.getKind());
        System.out.println("Is Fire Truck Available: " + fireTruck1.isAvailable());

        fireTruck1.setAvailable(false);
        System.out.println("Is Fire Truck Available (After Update): " + fireTruck1.isAvailable());

        FireTruck fireTruck2 = new FireTruck(2, 202, FireTruckKinds.LadderTruck);
        System.out.println("Fire Truck 2 ID: " + fireTruck2.getID());
        System.out.println("Fire Truck 2 Kind: " + fireTruck2.getKind());
        
    	
        Node<Integer> node1 = new Node<>(10);
        Node<Integer> node2 = new Node<>(20);
        Node<Integer> node3 = new Node<>(30);

        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);

        System.out.println("First Node Content: " + node1.getContent());

        System.out.println("Next of node1: " + node1.getNext().getContent());
        System.out.println("Prev of node3: " + node3.getPrev().getContent());

        System.out.println("Is node1 equals to node2? " + node1.equals(node2));
        System.out.println("Is node2 equals to node2? " + node2.equals(node2));
        
    	
    	FireStation station101 = new FireStation(101, "Downtown");
        
        FireTruck fireTruck1 = new FireTruck(101, 1, FireTruckKinds.FireEngine);
        FireTruck fireTruck2 = new FireTruck(101, 2, FireTruckKinds.LadderTruck);
        Ambulance ambulance1 = new Ambulance(101, 1, true);
        
        station101.addVehicle(fireTruck1);
        station101.addVehicle(fireTruck2);
        station101.addVehicle(ambulance1);
        
        System.out.println("Vehicles before adding:");
        station101.printVehicles();
        
        station101.sortVehicles();
        
        System.out.println("\nVehicles after sorting:");
        station101.printVehicles();
        
        int availableFireEngines = station101.getAvailableVehicleCount(FireTruckKinds.FireEngine);
        System.out.println("\nAvailable fire engines: " + availableFireEngines);
        
        int availableAmbulances = station101.getAvailableAmbulanceCount(true);
        System.out.println("Available doctor ambulances: " + availableAmbulances);
        
        FireTruck dispatchedFireTruck = station101.dispatchFireTruck(FireTruckKinds.FireEngine);
        System.out.println("\nDispatched fire truck ID: " + dispatchedFireTruck.getID());
        
        Ambulance dispatchedAmbulance = station101.dispatchAmbulance(true);
        System.out.println("Dispatched ambulance ID: " + dispatchedAmbulance.getID());
        
        System.out.println("\nVehicles after dispatch:");
        station101.printVehicles();
        
        station101.removeVehicle(fireTruck1);
        System.out.println("\nVehicles after fire truck removal:");
        station101.printVehicles();
        
        station101.removeVehicle(ambulance1.getID());
        System.out.println("\nVehicles after ambulance removal:");
        station101.printVehicles();
        
    	
    	List<String> myList = new List<>();

        Node<String> node1 = new Node<>("FireEngine");
        Node<String> node2 = new Node<>("LadderTruck");
        Node<String> node3 = new Node<>("Ambulance");

        myList.append(node1);
        myList.append(node2);
        myList.append(node3);

        System.out.println("List after appending nodes:");
        System.out.println(myList);

        Node<String> node4 = new Node<>("RescueTruck");
        myList.insert(1, node4);  

        System.out.println("List after inserting at index 1:");
        System.out.println(myList);

        myList.remove(2);  
        
        System.out.println("List after removing node at index 2:");
        System.out.println(myList);

        myList.remove("FireEngine");  
        
        System.out.println("List after removing 'FireEngine':");
        System.out.println(myList);

        myList.swap(0, 1);  

        System.out.println("List after swapping nodes at index 0 and 1:");
        System.out.println(myList);

        Node<String> nodeAtIndex1 = myList.get(1);  
        System.out.println("Node at index 1: " + nodeAtIndex1.getContent());

        System.out.println("List size: " + myList.getSize());

        List<String> anotherList = new List<>();
        anotherList.append(new Node<>("RescueTruck"));
        anotherList.append(new Node<>("LadderTruck"));

        System.out.println("Is myList equal to anotherList? " + myList.equals(anotherList));
        */
        
    	
    	
    	/*
    	 List<Character> list = new List<>();
    	    Node<Character> node1 = new Node<>('a');
    	    Node<Character> node2 = new Node<>('b');
    	    Node<Character> node3 = new Node<>('c');

    	    // Listeye node ekle
    	    list.append(node1);
    	    list.append(node2);
    	    list.append(node3);

    	    System.out.println("List before removal: " + list);  // List before removal: [a, b, c]

    	    // 'b' node'unu silmeyi dene
    	    boolean removed = list.remove('b');
    	    System.out.println("Node 'b' removed: " + removed);  // Node 'b' removed: true
    	    System.out.println("List after removal: " + list);  // List after removal: [a, c]
    	    
    	    // 'b' node'unu tekrar silmeyi dene (false döndürmeli)
    	    removed = list.remove('b');
    	    System.out.println("Node 'b' removed again: " + removed);  // Node 'b' removed again: false
    		*/
    	
    	// Emergency Dispatch Center oluşturuluyor
        EmergencyDispatchCenter dispatchCenter = new EmergencyDispatchCenter();

        // FireStation'lar oluşturuluyor
        FireStation station1 = new FireStation(1, "Downtown");
        FireStation station2 = new FireStation(2, "Uptown");

        // FireStation'lar EmergencyDispatchCenter'a ekleniyor
        dispatchCenter.addFireStation(station1);
        dispatchCenter.addFireStation(station2);

        // FireTruck araçları ekleniyor
        dispatchCenter.addVehicle(1, FireTruckKinds.FireEngine);  // Station 1 - FireEngine
        dispatchCenter.addVehicle(1, FireTruckKinds.LadderTruck); // Station 1 - LadderTruck
        dispatchCenter.addVehicle(2, FireTruckKinds.FireEngine);  // Station 2 - FireEngine

        // Ambulanslar ekleniyor
        dispatchCenter.addVehicle(1, "81", 1);  // Station 1, Ambulance with Doctor (ID: 1/81/1)
        dispatchCenter.addVehicle(1, "83", 2);  // Station 1, Ambulance without Doctor (ID: 1/83/2)
        dispatchCenter.addVehicle(2, "81", 1);  // Station 2, Ambulance with Doctor (ID: 2/81/1)

        // Emergency (Acil Durum) olayları oluşturuluyor
        Emergency fireEmergency = dispatchCenter.newCall("Location A", EmergencyKinds.FireSmall, 2, 1);
        Emergency medicalEmergency = dispatchCenter.newCall("Location B", EmergencyKinds.MedicalEmergency, 1, 1);

        // Acil durumlar listeye ekleniyor
        dispatchCenter.addCalltoList(fireEmergency);
        dispatchCenter.addCalltoList(medicalEmergency);

        // Araçlar acil durumlara göre tahsis ediliyor
        dispatchCenter.dispatchVehicles();

        // Araçları yazdırıyoruz (fireEmergency ve medicalEmergency için)
        System.out.println("Responding vehicles for Fire Emergency:");
        dispatchCenter.printRespondingVehicles(fireEmergency);

        System.out.println("\nResponding vehicles for Medical Emergency:");
        dispatchCenter.printRespondingVehicles(medicalEmergency);

        // Durum kontrolü: FireEngine kaldırılıyor
        dispatchCenter.removeVehicle("1/49/1"); // FireEngine - Station 1
        System.out.println("\nAfter removing FireEngine from Station 1:");

        // Kalan araçları yazdırma
        dispatchCenter.printRespondingVehicles(fireEmergency);  // Fire emergency'ye kalan araçları gösterir
        dispatchCenter.printRespondingVehicles(medicalEmergency);  // Medical emergency'ye kalan araçları gösterir
    }
}
