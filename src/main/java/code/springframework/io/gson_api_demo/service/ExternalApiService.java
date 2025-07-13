package code.springframework.io.gson_api_demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import code.springframework.io.gson_api_demo.model.ExternalUser;

@Service
public class ExternalApiService {

    private final Gson gson = new Gson();

    public ExternalUser getUserFromExternalApi(int userId) {
        try {
            String url = "https://jsonplaceholder.typicode.com/users/" + userId;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                return gson.fromJson(response.toString(), ExternalUser.class);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error calling external API", e);
        }
    }
}
