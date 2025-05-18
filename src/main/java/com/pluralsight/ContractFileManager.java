package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("contracts.csv"))) {

            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");

                    String type = fields[0];
                    int contractDate = Integer.parseInt(fields[1]);
                    String name = fields[2];
                    String email = fields[3];
                    int carId = Integer.parseInt(fields[5]);
                    int year = Integer.parseInt(fields[6]);
                    String make = fields[7];
                    String model = fields[8];
                    String vehicleType = fields[9];
                    String color = fields[10];
                    int odometer = Integer.parseInt(fields[11]);
                    double price = Double.parseDouble(fields[12]);
                    double salesTax = Double.parseDouble(fields[13]);
                    double recordingFee = Double.parseDouble(fields[14]);
                    double processingFee = Double.parseDouble(fields[15]);
                    double totalCost = Double.parseDouble(fields[16]);
                    double finance = Double.parseDouble(fields[17]);
                    double monthlyPayment = Double.parseDouble(fields[18]);

                    Vehicle vehicle = new Vehicle(type, contractDate, name, email, carId, year, make, model, vehicleType, color, odometer, price, salesTax, recordingFee, processingFee, totalCost, finance, monthlyPayment);
                    vehicles.add(vehicle);
                }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dealership != null) {
            for (Vehicle vehicle : vehicles) {
                dealership.addVehicle(vehicle);
            }
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv"))) {

            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                        + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                        + "|" + vehicle.getPrice());
                bw.newLine();
            }

            System.out.println("Contract saved successfully to contracts.csv.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

