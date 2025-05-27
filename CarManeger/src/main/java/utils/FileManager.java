package utils;

import model.Car;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void save(List<Car> cars, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Car car : cars) {
                writer.write(car.getBrand() + "," + car.getModel() + "," + car.getYear() + "," + car.getPrice());
                writer.newLine();
            }
        }
    }

    public static List<Car> load(String filePath) throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                cars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
            }
        }
        return cars;
    }
}
