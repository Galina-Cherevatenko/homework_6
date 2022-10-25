package homework_6.task_3;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println("Текущая: "+ time);
        System.out.println(time.getZone().getId());
        Set<String> zone = ZoneId.getAvailableZoneIds();
        List<String> list = new ArrayList<>();
        list.addAll(zone);
        System.out.println("Первые 10: ");
        for (int i = 0; i< 10; i++) {
            if (!list.get(i).contains(time.getZone().getId())) {
                ZoneId zoneId = ZoneId.of(list.get(i));
                ZonedDateTime timeZone = ZonedDateTime.now(zoneId);
                System.out.println(timeZone);
            }
        }

    }
}
