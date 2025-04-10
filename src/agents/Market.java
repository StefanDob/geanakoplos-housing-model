package agents;

import java.util.ArrayList;
import java.util.List;

public class Market {
	private static List<House> houseList = new ArrayList<>();

    public static void initMarket() {
        // z. B. 50 Häuser zu Beginn
        for (int i = 0; i < 50; i++) {
            houseList.add(new House(100_000 + Math.random() * 50_000));
        }
    }

    public static House findAffordableHouse(HouseholdAgent buyer) {
        for (House house : houseList) {
            double ltv = 0.8;
            double downPayment = house.getPrice() * (1 - ltv);
            if (buyer.getWealth() >= downPayment) {
                return house;
            }
        }
        return null;
    }

    public static void removeHouse(House house) {
        houseList.remove(house);
    }

}
