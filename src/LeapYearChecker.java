import java.time.LocalDate;

public class LeapYearChecker {

    public static void printLeapYearStatus(int year) {
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isLeap) {
            System.out.println(year + " год — високосный год");
        } else {
            System.out.println(year + " год — невисокосный год");
        }
    }


    public static void suggestAppVersion(int osType, int releaseYear) {
        int currentYear = LocalDate.now().getYear();

        String osName;
        if (osType == 0) {
            osName = "iOS";
        } else if (osType == 1) {
            osName = "Android";
        } else {
            System.out.println("Некорректный тип ОС. Допустимые значения: 0 (iOS), 1 (Android).");
            return;
        }

        if (releaseYear > currentYear) {
            System.out.println(osName + ": некорректный год выпуска (будущее). Проверьте данные.");
            return;
        }

        if (releaseYear < currentYear) {
            System.out.println("Для " + osName + " рекомендуем установить облегчённую версию приложения.");
        } else {
            System.out.println("Для " + osName + " можно установить обычную версию приложения.");
        }
    }

    public static int calculateDeliveryDays(int distance) {
        if (distance <= 0) {
            return 0;
        }
        if (distance > 100) {
            return -1;
        }

        int days = 1;
        if (distance > 20) {
            days += 1;
        }
        if (distance > 60) {
            days += 1;
        }

        return days;
    }

    public static void main(String[] args) {
        // Задача 1
        System.out.println("Задача 1");
        printLeapYearStatus(2024);
        printLeapYearStatus(1992);
        printLeapYearStatus(2012);
        printLeapYearStatus(2021);

        // Задача 2
        System.out.println("Задача 2");
        suggestAppVersion(0, 2019);
        suggestAppVersion(1, 2023);
        suggestAppVersion(0, LocalDate.now().getYear());
        suggestAppVersion(2, 2020);

        // Задача 3
        System.out.println("Задача 3");
        int deliveryDistance = 95;
        int days = calculateDeliveryDays(deliveryDistance);

        if (days == -1) {
            System.out.println("Доставка на расстояние более 100 км не осуществляется.");
        } else {
            System.out.println("Потребуется дней: " + days);
        }
    }
}