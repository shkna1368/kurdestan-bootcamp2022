
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Utils {


    public static UUID strToUuid(String uuid) {
        UUID id;

        if (uuid.length() < 32) {
            throw new IllegalArgumentException(StringResource.invalid_uuid_FA);
        }

        try {
            id = UUID.fromString(uuid);
        } catch (Exception e) {
            throw new IllegalArgumentException(StringResource.invalid_uuid_FA);
        }
        return id;
    }


    // Generic function to convert set to list
    public static <T> List<T> convertSetToList(Set<T> set) {
        return new ArrayList<>(set);
    }


}
