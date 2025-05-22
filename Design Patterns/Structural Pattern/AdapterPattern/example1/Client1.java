public class Client1 {
    
    public static void main(String[] args) {
        
        // Create an instance of the existing legacy class that generates XML payloads
        XMLPayloadAdaptee xmlPayloadAdaptee = new XMLPayloadAdaptee();
        
        // Create an adapter that adapts the XML payload generator to the JSON payload generator interface
        // This adapter internally uses the XMLPayloadAdaptee instance
        PayloadGenerator payloadGenerator = new JSONPayloadAdapter(xmlPayloadAdaptee);
        
        // Generate the payload in JSON format through the adapter
        String jsonPayload = payloadGenerator.generate();
        
        // Print the JSON payload to the console
        System.out.println(jsonPayload);
    }
}
