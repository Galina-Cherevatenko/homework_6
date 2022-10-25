package homework_6.task_5;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateStr;
        System.out.println("Введите дату в формате yyyy-mm-dd");
        dateStr = in.nextLine();
        LocalDate date = LocalDate.parse(dateStr);
        String dayOfWeak = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
        if (checkHoliday(date) != null)
            System.out.println("Праздник! " + checkHoliday(date));
        switch (dayOfWeak) {
            case "суббота", "воскресенье":
                System.out.println("Выходной!");
                break;

            case "пятница":
                System.out.println("Пятница - это день, когда работа заканчивается и можно уйти с работы пораньше");
                break;
            case "четверг":
                System.out.println("Четверг - это маленькая пятница");
                break;
            default:
                System.out.println("Будний день");
                break;

        }
    }

    public static String checkHoliday (LocalDate date) {
        String holiday = null;
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        if (day == 1 && month == 1)
            holiday = "International Hangover Day";
        if (day == 1 && month == 9)
            holiday = "День знаний";
        if (day == 5 && month == 10)
            holiday = "День учителя";
        if (day == 31 && month == 12)
            holiday = "Новый год";

        return holiday;
    }

    }

