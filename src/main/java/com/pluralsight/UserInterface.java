package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Sell/Lease a Vehicle");
            System.out.println("99. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "0":
                    addLeaseOrSale();
                    break;
                case "99":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processGetByPriceRequest() {

        System.out.println("Please Enter the Minimum Price of the Vehicle:");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Please Enter the Maximum Price of the Vehicle:");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(" ");

        List<Vehicle> availableVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        if (availableVehicles.isEmpty()) {
            System.out.println("No Vehicles With This Price Range Found...");

        } else {
            System.out.printf("Here Are The Available Vehicles Between $%.2f and $%.2f%n", minPrice, maxPrice);
            System.out.println(" ");
            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

            }
        }
    }

    public void processGetByMakeModelRequest() {

        System.out.println("Please Enter the Make of the Vehicle:");
        String make = scanner.nextLine();

        System.out.println("Please Enter the Model of the Vehicle:");
        String model = scanner.nextLine();
        System.out.println(" ");

        List<Vehicle> availableVehicles = dealership.getVehiclesByMakeModel(make, model);

        if (availableVehicles.isEmpty()) {
            System.out.println("No Vehicles With This Make/Model Found...");

        } else {
            System.out.printf("Here Are The Available Vehicles with the Make of " + make + " and Model "+ model);
            System.out.println(" ");
            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        }
    }

    public void processGetByYearRequest() {

        System.out.println("Please Enter the Earliest Year of the Vehicle:");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please Enter the Latest Year of the Vehicle:");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");

        List<Vehicle> availableVehicles = dealership.getVehiclesByYear(minYear, maxYear);

        if (availableVehicles.isEmpty()) {
            System.out.println("No Vehicles With This Year Range Found...");

        } else {
            System.out.printf("Here Are The Available Vehicles Between: " + minYear + " and " + maxYear);
            System.out.println(" ");
            /*System.out.printf("%-12s %-10s %-35s %-30s %-30s %-30s %-30s %-10s\n", "VIN" , "Year", "Make", "Model", "Vehicle Type", "Color", "Odometer", "Price");*/
            System.out.println(" ");

            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

            }
        }
    }

    public void processGetByColorRequest() {

        System.out.println("Please Enter the Color of the Vehicle:");
        String color = scanner.nextLine();

        List<Vehicle> availableVehicles = dealership.getVehiclesByColor(color);

        if (availableVehicles.isEmpty()) {
            System.out.println("No Vehicles With This Color Found...");

        } else {
            System.out.println("Here Are The Available Vehicles in the Color " + color);
            System.out.println(" ");
            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        }
    }


    public void processGetByMileageRequest() {

        System.out.println("Please Enter the Least Amount of Mileage of the Vehicle:");
        int minMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please Enter the Most Amount of Mileage of the Vehicle:");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");

        List<Vehicle> availableVehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        if (availableVehicles.isEmpty()) {

            System.out.println("No Vehicles With This Mileage Range Found...");
            System.out.println("Returning Home...");

        } else {
            System.out.println("Here Are The Available Vehicles With Mileages Between: " + minMileage + " and " + maxMileage);
            System.out.println(" ");

            System.out.println(" ");

            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

            }
        }
    }

    public void processGetByVehicleTypeRequest() {

        System.out.println("Please Enter the Type of the Vehicle:");
        String vehicleType = scanner.nextLine();

        List<Vehicle> availableVehicles = dealership.getVehiclesByType(vehicleType);

        if (availableVehicles.isEmpty()) {
            System.out.println("No Vehicles With This Type Found...");

        } else {
            System.out.println("Here Are The Available Vehicles in the " + vehicleType + " Category");
            System.out.println(" ");
            for (Vehicle vehicle : availableVehicles) {
                System.out.printf("%-12s | %-10s | %-30s | %-20s | %-20s | %-20s | %-20s | $%10.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        }
    }

    public void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {

        int vin = 0;
        int year = 0;
        String make = null;
        String model = null;
        String vehicleType = null;
        String color = null;
        int odometer = 0;
        double price = 0.0;

        while (vin == 0) {
            try {
                System.out.println("(1 / 8) Please Enter The 5 Digit Vehicle Identification Number:");
                int userVinInput = scanner.nextInt();
                scanner.nextLine();

                if (userVinInput >= 10000 && userVinInput <= 99999) {
                    vin = userVinInput;
                } else {

                    System.out.println("The VIN Must Be a Value Between 10000 and 99999!");

                }

            } catch (Exception e) {

                System.out.println("Invalid! Please Enter a 5-Digit VIN");
                scanner.nextLine();
            }
        }

        while (year == 0) {
            try {
                System.out.println("(2 / 8) Please Enter The Year of The Vehicle:");
                int userYearInput = scanner.nextInt();
                scanner.nextLine();

                if (userYearInput >= 1885 && userYearInput <= 2025) {
                    year = userYearInput;
                } else {

                    System.out.println("The Year Must Be a Value Between 1885 and 2025!");

                }

            } catch (Exception e) {

                System.out.println("Invalid! Please Enter a 4 Digit Year Value");
                scanner.nextLine();
            }
        }


        while (make == null || make.trim().isEmpty()) {

            System.out.println("(3 / 8) Please Enter The Make of The Vehicle:");
            make = scanner.nextLine().trim();

            if (make.isEmpty()) {
                System.out.println("Make Should Not be Empty!");
                make = null;

            }
        }

        while (model == null || model.trim().isEmpty()) {

            System.out.println("(4 / 8) Please Enter The Model of The Vehicle:");
            model = scanner.nextLine().trim();

            if (model.isEmpty()) {

                System.out.println("Model Should Not be Empty!");
                model = null;

            }
        }

        while (vehicleType == null || vehicleType.trim().isEmpty()) {

            System.out.println("(5 / 8) Please Enter The Type of Vehicle:");
            vehicleType = scanner.nextLine().trim();

            if (vehicleType.isEmpty()) {
                System.out.println("Vehicle Type Cannot be Empty!");
                vehicleType = null;

            }
        }

        while (color == null || color.trim().isEmpty()) {

            System.out.println("(6 / 8) Please Enter The Color of The Vehicle");
            color = scanner.nextLine().trim();

            if (color.isEmpty()) {
                System.out.println("Color Cannot be Empty!");
                color = null;
            }
        }

        while (odometer == 0) {
            try {
                System.out.println("(7 / 8) Please Enter The Number of Miles The Vehicle Has:");
                int userOdometerInput = scanner.nextInt();
                scanner.nextLine();

                if (userOdometerInput >= 1 && userOdometerInput <= 999999) {
                    odometer = userOdometerInput;

                } else {

                    System.out.println("The Mileage Must Be a Value Between 1 and 99999!");

                }

            } catch (Exception e) {

                System.out.println("Invalid! Please Enter a Number Between 1 and 999999!");
                scanner.nextLine();
            }
        }

        while (price == 0.0) {

            System.out.println("(8 / 8) Please Enter The Price of The Vehicle:");
            price = scanner.nextDouble();
            scanner.nextLine();

            if (price <= 0) {
                System.out.println("Price of The Vehicle Cannot be $0 or less!!!");
                price = 0.0;
            }
        }


        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = scanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    private void addLeaseOrSale() {

       String leaseOrSale = null;

        while (leaseOrSale == null) {

            try {

                System.out.print("Enter vehicle ID: ");
                int vin = scanner.nextInt();
                scanner.nextLine();

                Vehicle vehicle = dealership.getVehiclesById(vin);
                if (vehicle == null) {
                    System.out.println("No vehicle found with This ID...");
                    continue;
                }

                int year = vehicle.getYear();

                System.out.println("Is this a Lease or Sale?");
                String leaseOrSaleInput = scanner.nextLine();


                if (leaseOrSaleInput.equalsIgnoreCase("lease")) {
                    if (LocalDate.now().getYear() - year <= 3) {
                        leaseOrSale = "lease";
                        System.out.println("Leasing is Available for this Vehicle!");
                        System.out.println(" ");

                    } else {
                        System.out.println(" ");
                        System.out.println("Apologies, Leasing is Not Available for This Vehicle since it is Older Than 3 Years...");
                        System.out.println(" ");

                    }
                } else if (leaseOrSaleInput.equalsIgnoreCase("sale")) {
                    System.out.println("Vehicle Sale: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid Entry");
            }
        }

        System.out.println("Please Enter Your Name: ");
        String userName = scanner.nextLine();

        System.out.println("Please Enter Your Email: ");
        String userEmail = scanner.nextLine();

        System.out.println("Will You Finance This Purchase?  Y / N ? ");
        String financeOption = scanner.nextLine();

        if (financeOption.equalsIgnoreCase("yes") || financeOption.equalsIgnoreCase("y")) {

        }

    }

}
