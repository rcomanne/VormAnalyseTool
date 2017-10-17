package nl.avans.businesslogic.service;

import nl.avans.domain.Shape;

import java.io.*;

public class DataFileOutService {
    boolean fileExists;

    public DataFileOutService(Shape shape) throws IOException {
       try {
           new File("data").mkdir();
           fileExists = new File("data/shapes.data").exists();
           FileOutputStream fileOutputStream = new FileOutputStream("data/shapes.data", true);
           ObjectOutputStream objectOutputStream = fileExists ?
                   new ObjectOutputStream(fileOutputStream) {
                       protected void writeStreamHeader() throws IOException {
                            reset();
                       }
                   } : new ObjectOutputStream(fileOutputStream);
           objectOutputStream.writeObject(shape);
           objectOutputStream.close();
           fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Fout opgetreden bij openen, maken of sluiten van bestand");
            e.printStackTrace();
        }
    }
}
