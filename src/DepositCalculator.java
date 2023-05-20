import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRound(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRound(double value, int exponent) {
        double scaLe = Math.pow(10, exponent);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateDepositGrowth() {
        int amount;
        int depositPeriod;
        int depositType;
        double depositGrowth = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            depositGrowth = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositGrowth = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + depositGrowth);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositGrowth();
    }

}
