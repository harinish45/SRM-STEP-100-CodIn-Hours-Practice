package BookMyStayApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// AddOnService Class - represents optional services
class AddOnService {
    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}

// AddOnServiceManager Class - manages mapping between reservation and services
class AddOnServiceManager {
    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Attach service to reservation
    public void addService(String reservationId, AddOnService service) {
        if (!servicesByReservation.containsKey(reservationId)) {
            servicesByReservation.put(reservationId, new ArrayList<>());
        }
        servicesByReservation.get(reservationId).add(service);
    }

    // Calculate total cost of all services for a reservation
    public double calculateTotalServiceCost(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if (services == null || services.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (AddOnService service : services) {
            total += service.getCost();
        }
        return total;
    }
}

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Add-On Service Selection");
        System.out.println("=================================\n");

        // Create Add-On Service Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Create some add-on services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 800.0);
        AddOnService wifi = new AddOnService("WiFi", 200.0);

        // Add services to a reservation
        String reservationId = "Single-1";
        serviceManager.addService(reservationId, breakfast);
        serviceManager.addService(reservationId, spa);
        serviceManager.addService(reservationId, wifi);

        // Display results
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + serviceManager.calculateTotalServiceCost(reservationId));
    }
}
