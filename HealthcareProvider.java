import java.util.ArrayList; 

import java.util.List; 

 

// Define the HealthcareProvider class 

class HealthcareProvider { 

    private String name; 

    private String address; 

    private String phoneNumber; 

    private double latitude; 

    private double longitude; 

    private boolean isFreeOrLowCost; 

 

    // Constructor 

    public HealthcareProvider(String name, String address, String phoneNumber, double latitude, double longitude, boolean isFreeOrLowCost) { 

        this.name = name; 

        this.address = address; 

        this.phoneNumber = phoneNumber; 

        this.latitude = latitude; 

        this.longitude = longitude; 

        this.isFreeOrLowCost = isFreeOrLowCost; 

    } 

 

    // Getters and Setters 

    // ... 

 

    // Other methods 

    // ... 

} 

 

// Backend service class 

class HealthcareLocatorService { 

    private List<HealthcareProvider> healthcareProviders; 

 

    public HealthcareLocatorService() { 

        healthcareProviders = new ArrayList<>(); 

 

        // Initialize healthcare providers (sample data) 

        healthcareProviders.add(new HealthcareProvider("Hospital A", "123 Main St, City A", "123-456-7890", 40.123, -74.456, true)); 

        healthcareProviders.add(new HealthcareProvider("Hospital B", "456 Elm St, City B", "987-654-3210", 41.789, -72.345, false)); 

        // Add more healthcare providers... 

    } 

 

    public List<HealthcareProvider> findNearbyHealthcareProviders(double userLatitude, double userLongitude, double radius) { 

        List<HealthcareProvider> nearbyProviders = new ArrayList<>(); 

 

        // Iterate through all healthcare providers 

        for (HealthcareProvider provider : healthcareProviders) { 

            // Calculate the distance between the user's location and the provider's location 

            double distance = calculateDistance(userLatitude, userLongitude, provider.getLatitude(), provider.getLongitude()); 

 

            // Check if the provider is within the specified radius 

            if (distance <= radius) { 

                nearbyProviders.add(provider); 

            } 

        } 

 

        return nearbyProviders; 

    } 

 

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) { 

        // Calculate the distance between two latitude-longitude coordinates 

        // You can use any suitable algorithm or library for this calculation 

 

        // Example calculation using Haversine formula 

        double earthRadius = 6371; // in kilometers 

 

        double dLat = Math.toRadians(lat2 - lat1); 

        double dLon = Math.toRadians(lon2 - lon1); 

 

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) 

                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 

                * Math.sin(dLon / 2) * Math.sin(dLon / 2); 

 

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); 

 

        return earthRadius * c; 

    } 

} 

 

// Example usage 

public class Main { 

    public static void main(String[] args) { 

        // Create an instance of the HealthcareLocatorService 

        HealthcareLocatorService locatorService = new HealthcareLocatorService(); 

 

        // User's current location (sample coordinates) 

        double userLatitude = 40.456; 

        double userLongitude = -73.123; 

 

        // Radius for nearby providers (in kilometers) 

        double radius = 10; 

 

        // Find nearby healthcare providers 

        List<HealthcareProvider> nearbyProviders = locatorService.findNearbyHealthcareProviders(userLatitude, userLongitude, radius); 

 

        // Print the nearby healthcare providers 

        for (HealthcareProvider provider : nearbyProviders) { 

            System.out.println("Name: " + provider.getName()); 

            System.out.println("Address: " + provider.getAddress()); 

            System.out.println("Phone: " + provider.getPhoneNumber()); 

            System.out.println("Is Free or Low Cost: " + (provider.isFreeOrLowCost() ? "Yes" : "No")); 

            System.out.println("--------------------------------------"); 

        } 

    } 

}  

 

 

 
