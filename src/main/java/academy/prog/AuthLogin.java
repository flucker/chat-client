package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class AuthLogin {
    private  String login;

    public AuthLogin(String login) {
        this.login = login;
    }

    public String auth() throws IOException {
        URL obj = new URL(Utils.getURL() + "/auth?login=" + login);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        InputStream is = conn.getInputStream();
        String cookies = "";

        Map<String, List<String>> headerFields = conn.getHeaderFields();
        List<String> setCookieHeader = headerFields.get("Set-Cookie");
        if (setCookieHeader != null) {
            StringBuilder cookieBuilder = new StringBuilder();
            for (String cookie : setCookieHeader) {
                cookieBuilder.append(cookie.split(";", 2)[0]).append("; ");
            }
            cookies = cookieBuilder.toString();
        }
        return cookies;
    }
}
