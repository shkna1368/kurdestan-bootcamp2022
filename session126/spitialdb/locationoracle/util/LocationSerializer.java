
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.io.IOException;

public class LocationSerializer extends StdSerializer<Point<G2D>> {

    public LocationSerializer() {
        this(null);
    }

    public LocationSerializer(Class<Point<G2D>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Point<G2D> value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("lat", value.getPosition().getLat());
        jgen.writeNumberField("lon", value.getPosition().getLon());


        jgen.writeEndObject();
    }
}