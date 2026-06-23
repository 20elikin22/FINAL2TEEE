package util;

import model.User;

import java.io.*;

public class PreferenceManager {

    public static void save(User user) {

        try (ObjectOutputStream out =
                 new ObjectOutputStream(
                     new FileOutputStream(
                         "serialized/userPreferences.ser"))) {

            out.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}