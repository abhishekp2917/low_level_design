// Existing legacy class that generates payloads in XML format
// Adapter will use this Adaptee to generate required result by client
public class XMLPayloadAdaptee implements PayloadAdaptee {
    
    // Method to generate XML payload as a String
    @Override
    public String generatePayload() {
        // Sample XML payload representing user data
        String xmlPayload = "<user><name>Abhishek</name><age>25</age></user>"; 
        return xmlPayload;
    }
}
