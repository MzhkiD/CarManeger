package gui;

import model.Car;
import utils.FileManager;
import utils.MergeSort;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CarShowroomGUI extends JFrame {
    private JTable carTable;
    private DefaultTableModel tableModel;
    private java.util.List<Car> carList = new ArrayList<>();

    public CarShowroomGUI() {
        setTitle("Автосалон");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        String[] columns = {"Марка", "Модел", "Година", "Цена"};
        tableModel = new DefaultTableModel(columns, 0);
        carTable = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(carTable);
        scroll.setBounds(20, 20, 740, 300);
        add(scroll);

        JButton addButton = new JButton("Добави");
        addButton.setBounds(20, 340, 100, 30);
        addButton.addActionListener(e -> addCar());
        add(addButton);

        JButton deleteButton = new JButton("Изтрий");
        deleteButton.setBounds(140, 340, 100, 30);
        deleteButton.addActionListener(e -> deleteCar());
        add(deleteButton);

        JButton sortButton = new JButton("Сортирай по цена");
        sortButton.setBounds(260, 340, 150, 30);
        sortButton.addActionListener(e -> {
            MergeSort.sort(carList);
            refreshTable();
        });
        add(sortButton);

        JButton saveButton = new JButton("Запази");
        saveButton.setBounds(430, 340, 100, 30);
        saveButton.addActionListener(e -> {
            try {
                FileManager.save(carList, "cars.txt");
            } catch (Exception ex) {
                showError("Грешка при запис.");
            }
        });
        add(saveButton);

        JButton loadButton = new JButton("Зареди");
        loadButton.setBounds(550, 340, 100, 30);
        loadButton.addActionListener(e -> {
            try {
                carList = FileManager.load("cars.txt");
                refreshTable();
            } catch (Exception ex) {
                showError("Грешка при зареждане.");
            }
        });
        add(loadButton);

        setVisible(true);
    }

    private void addCar() {
        try {
            String brand = JOptionPane.showInputDialog("Марка:");
            String model = JOptionPane.showInputDialog("Модел:");
            int year = Integer.parseInt(JOptionPane.showInputDialog("Година:"));
            double price = Double.parseDouble(JOptionPane.showInputDialog("Цена:"));

            Car car = new Car(brand, model, year, price);
            carList.add(car);
            refreshTable();
        } catch (Exception e) {
            showError("Невалидни данни.");
        }
    }

    private void deleteCar() {
        int index = carTable.getSelectedRow();
        if (index >= 0) {
            carList.remove(index);
            refreshTable();
        } else {
            showError("Моля, изберете автомобил.");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Car car : carList) {
            tableModel.addRow(new Object[]{car.getBrand(), car.getModel(), car.getYear(), car.getPrice()});
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Грешка", JOptionPane.ERROR_MESSAGE);
    }
}
