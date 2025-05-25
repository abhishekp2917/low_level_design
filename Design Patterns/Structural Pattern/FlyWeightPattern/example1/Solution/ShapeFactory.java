import java.util.HashMap;

/**
 * ShapeFactory class implements the Flyweight design pattern.
 * It maintains a cache (HashMap) of Shape (specifically Circle) objects
 * and returns existing instances based on intrinsic attributes (radius, color).
 */
public class ShapeFactory {

    /**
     * A map to store Circle objects.
     * Key is generated based on intrinsic properties (shape name, radius, color),
     * ensuring that shapes with the same intrinsic state are reused.
     */
    private static final HashMap<String, Shape> shapeMap = new HashMap<>();

    /**
     * Returns a Shape instance based on the provided intrinsic and extrinsic data.
     * If an instance with the same radius and color already exists, it is reused.
     * Otherwise, a new Shape object is created and cached.
     *
     */
    public static Shape getShape(String shape, double radius, Color color, double xCoordinate, double yCoordinate) {
        String key = getKey(shape, radius, color);
        Shape shapeObj = shapeMap.get(key);

        // If not found in cache, create and store a new Shape object
        if (shapeObj == null) {
            if(shape.equals("CIRCLE")) {
                shapeObj = new Circle(radius, color);
            }
            shapeMap.put(key, shapeObj);
        }

        // Set extrinsic data
        shapeObj.setPosition(xCoordinate, yCoordinate);
        return shapeObj;
    }

    /**
     * Generates a unique key for the shape using its intrinsic attributes.
     * This key is used to determine object reuse.
     * 
     */
    private static String getKey(String shape, double radius, Color color) {
        return shape + "_" + radius + "_" + color.name();
    }
}
