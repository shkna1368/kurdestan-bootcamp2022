
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;

import java.util.Base64;

public class Base64Utils {

    public static String createAuthorizationHeader(String clientId, String clientSecret){
        if(StringUtils.isBlank(clientId) || StringUtils.isBlank(clientSecret))
            throw new IllegalStateException("clientId/clientSecret cannot be null");

        String message = new StringBuilder("Basic ").append(clientId)
                .append(":").append(clientSecret).toString();
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public static Pair<String , String> fetchClientIdAndSecret(String base64Message){
            String[] parts = base64Message.split(" ");
        if(StringUtils.isBlank(parts[0]) || !parts[0].trim().equalsIgnoreCase("basic")
                || StringUtils.isBlank(parts[1]))
            throw new IllegalStateException("invalid authorization header=" + base64Message);

        byte[] decodedBytes = Base64.getDecoder().decode(parts[1].trim());
        String decodedString = new String(decodedBytes);

        String[] clientIdAndSecret = decodedString.split(":");

        if(clientIdAndSecret.length != 2)
            throw new IllegalStateException("invalid authorization header=" + base64Message);

        return Pair.of(clientIdAndSecret[0] , clientIdAndSecret[1]);
    }
}
