package com.pluralsight;

import java.io.*;


public class ContractFileManager {

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv"))) {

        String date = contract.getDate();
        String name = contract.getName();
        String email = contract.getEmail();
        boolean isSold = contract.isVehicleSold();
        Vehicle vehicle = contract.getVehicle();

        String vehicleInfo = String.format("%s|%d|%s|%s|%s|%s|%d|%.2f",
            vehicle.getVin(),
            vehicle.getYear(),
            vehicle.getMake(),
            vehicle.getModel(),
            vehicle.getVehicleType(),
            vehicle.getColor(),
            vehicle.getOdometer(),
            vehicle.getPrice());

            if (contract instanceof SalesContract) {
            SalesContract sc = (SalesContract) contract;

            String scLine = String.format("SALE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%s|%.2f|%.2f",
            date,
            name,
            email,
            isSold,
            vehicleInfo,
            sc.getSalesTaxAmount(),
            sc.getRecordingFee(),
            sc.getProcessingFee(),
            sc.isFinanceOption(),
            sc.getTotalPrice(),
            sc.getMonthlyPayment());

        } else if (contract instanceof LeaseContract){

            }

            System.out.println("Contract saved successfully to contracts.csv.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

