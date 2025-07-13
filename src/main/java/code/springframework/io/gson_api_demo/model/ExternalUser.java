package code.springframework.io.gson_api_demo.model;

public class ExternalUser {

    private int id;
    private String name;
    private String username;
    private String email;

    public ExternalUser(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
