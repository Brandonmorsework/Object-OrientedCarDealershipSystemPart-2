package com.pluralsight;

import java.io.*;


public class ContractFileManager {

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

