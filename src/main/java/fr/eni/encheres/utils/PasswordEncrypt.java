package fr.eni.encheres.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {

    public static String encryptPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Hacher le mot de passe en bytes
            byte[] hashedPassword = md.digest(password.getBytes());
            // Convertir les bytes hachés en format hexadécimal
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hashedPassword.length; i++) {
                String hex = Integer.toHexString(0xff & hashedPassword[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            // Retourner le mot de passe haché en format hexadécimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Gérer l'exception en cas de fonction de hachage inexistante
            e.printStackTrace();
        }
        return null;
    }

}
