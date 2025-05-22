// Adapter class that adapts XMLPayloadAdaptee to the PayloadGenerator interface (which produces JSON)
public class JSONPayloadAdapter implements PayloadGenerator {

    // Reference to the adaptee (existing XML payload generator)
    private PayloadAdaptee payloadAdaptee;

    // Constructor accepts an instance of XMLPayloadAdaptee to delegate XML generation
    public JSONPayloadAdapter(PayloadAdaptee payloadAdaptee) {
        this.payloadAdaptee = payloadAdaptee;
    }

    // Implementation of the generate() method from PayloadGenerator interface
    @Override
    public String generate() {
        // Obtain XML payload from the adaptee
        String payload = payloadAdaptee.generatePayload();

        // Here, parse the XML payload to extract necessary information
        // and convert it into JSON format.
        // For simplicity, hardcoded JSON is returned as an example.
        String jsonPayload = "{ \"name\": \"Abhishek\", \"age\": 25 }";

        return jsonPayload;
    }
}
