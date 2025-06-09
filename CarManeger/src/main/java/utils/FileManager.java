package utils;

import model.Car;
import model.CarList;
import java.io.*;


public class FileManager {
    public static void save(CarList<Car> cars, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Car car : cars) {
                writer.write(car.getBrand() + "," + car.getModel() + "," + car.getYear() + "," + car.getPrice());
                writer.newLine();
            }
        }
    }

    public static CarList<Car> load(String filePath) throws IOException {
        CarList<Car> cars = new CarList<>();
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
