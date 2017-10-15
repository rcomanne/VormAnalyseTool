package nl.avans.businesslogic.service;

import nl.avans.domain.Shape;

import java.io.FileWriter;
import java.io.IOException;

public class TextOutService {
    private Shape shape;

    public TextOutService(Shape shape) {
        this.shape = shape;

        try {
            FileWriter fileWriter = new FileWriter("C:/Development/VormAnalyseTool/data/shapes.txt", true);
            String output = shape.toString();
            fileWriter.write(output);
            fileWriter.write("\r\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Fout met textbestand.");
            e.printStackTrace();
        }
    }
}
