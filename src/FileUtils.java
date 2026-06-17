<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class FileUtils {
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return lines;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename + " -> " + e.getMessage());
        }
        return lines;
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileUtils {
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList();
        File file = new File(filename);
        if (!file.exists()) {
            return lines;
        } else {
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + filename + " -> " + e.getMessage());
            }

            return lines;
        }
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }

    public static void writeFile(String filename, List<String> lines, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append))) {
<<<<<<< HEAD
            for (String line : lines) {
=======
            for(String line : lines) {
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + filename + " -> " + e.getMessage());
        }
<<<<<<< HEAD
    }

    public static boolean exists(String filename) {
        return new File(filename).exists();
    }

=======

    }

    public static boolean exists(String filename) {
        return (new File(filename)).exists();
    }
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
}
