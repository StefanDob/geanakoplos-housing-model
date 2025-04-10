package agents;

public class HouseholdAgent {
	private double income;
    private double wealth;
    private boolean ownsHouse;
    private double loan;

    public HouseholdAgent(double income, double initialWealth) {
        this.income = income;
        this.wealth = initialWealth;
        this.ownsHouse = false;
        this.loan = 0;
    }

    public void step() {
        // Einkommen verdienen
        wealth += income;

        // Kredit zurückzahlen
        if (loan > 0) {
            double payment = Math.min(loan, 100);  // z.B. Tilgung von 100 pro Tick
            wealth -= payment;
            loan -= payment;
        }

        // Hauskaufversuch
        if (!ownsHouse) {
            House house = Market.findAffordableHouse(this);
            if (house != null) {
                buyHouse(house);
            }
        }
    }

    public void buyHouse(House house) {
        double ltv = 0.8;  // Max. 80% Kredit
        double loanAmount = house.getPrice() * ltv;
        double downPayment = house.getPrice() - loanAmount;

        if (wealth >= downPayment) {
            wealth -= downPayment;
            loan += loanAmount;
            ownsHouse = true;
            Market.removeHouse(house);
        }
    }

    public double getWealth() {
        return wealth;
    }
}
