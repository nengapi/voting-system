package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashInput {

    private String hashInput = null;

    public HashInput(String password) {
        this.hashInput = getSHA_256(password);
    }

    public String getHashInput() {
        return hashInput;
    }

    public void setHashInput(String hashInput) {
        this.hashInput = hashInput;
    }

    public static String getSHA_256(String input) {

        String generateInput = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generateInput = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generateInput;
    }

}
