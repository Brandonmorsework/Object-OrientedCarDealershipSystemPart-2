package com.pluralsight;

import java.util.ArrayList;

public class ContractDataManager {

    public static void main(String[] args) {

        ArrayList<Contract> contracts = new ArrayList<>();

        contracts.add(new SalesContract());
        contracts.add(new LeaseContract());

        for (int i = 0; i < 2; i++) {

            if (contracts.get(i) instanceof SalesContract) {
                contracts.add()
            }
            if (contracts.get(i) instanceof LeaseContract) {
                contracts.add();
            }
        }
    }

}
