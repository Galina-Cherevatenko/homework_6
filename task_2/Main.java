package homework_6.task_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateStr;
        LocalDate date, dateNow;
        int age = -1;
        dateNow = LocalDate.now();
        System.out.println("Введите дату рождения в формате yyyy-mm-dd");
        dateStr = in.nextLine();
        DateValidatorUsingLocalDate dateValid = new DateValidatorUsingLocalDate(DateTimeFormatter.ISO_LOCAL_DATE);
        if (dateValid.isValid(dateStr)) {
            date = LocalDate.parse(dateStr);
        }
        else {
            Boolean chek;
                        do {
                System.out.println("Введенные данные некорректны.");
                System.out.println("Введите дату рождения в формате yyyy-mm-dd");
                dateStr = in.nextLine();
                chek = dateValid.isValid(dateStr);
            }
            while (!chek);
            date = LocalDate.parse(dateStr);

        }
        for (int year = date.getYear(); year<= dateNow.getYear(); year = year +1) {
            age = age +1;
            if (year%4==0 && year%100 !=0 || year%400==0) {
                System.out.println(date.getDayOfMonth() + " "+ date.getMonth()+ " " + year + " " + age +" лет");
            }
        }


    }
}

