// Adaptee interface representing any class that generates a payload in a specific format (e.g., XML, CSV, etc.).
public interface PayloadAdaptee {
    
    // Generates the payload in a specific format (e.g., XML).
    String generatePayload();
}
