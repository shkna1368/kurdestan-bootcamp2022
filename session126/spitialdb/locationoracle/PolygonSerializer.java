
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Polygon;

import java.io.IOException;

public class PolygonSerializer extends StdSerializer<Polygon<G2D>> {

    public PolygonSerializer() {
        this(null);
    }

    public PolygonSerializer(Class<Polygon<G2D>> t) {
        super(t);
    }

    @Override
    public void serialize(Polygon<G2D> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        int positions = value.getNumPositions();
        for (int i = 0; i < positions; i++) {

            G2D point = value.getPositionN(i);

            jgen.writeNumberField("lat", point.getLat());
            jgen.writeNumberField("lon", point.getLon());
        }

        jgen.writeEndObject();

    }
}