import java.io.*;

class LoginSystem {

    public boolean login(String username, String password) {
        // Boundary and edge-case validation
        if (username == null || password == null) {
            return false;
        }

        // Username: 3–20 characters
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        // Password: 6–20 characters
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }

        // Example valid credentials
        return username.equals("admin") && password.equals("admin123");
    }
}

public class Task10 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        LoginSystem system = new LoginSystem();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().trim().split("\\s+");

            String username = input[0];
            String password = input[1];

            if (system.login(username, password)) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILURE");
            }
        }
    }
}