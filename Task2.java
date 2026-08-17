import java.util.*;
import java.util.stream.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Reading> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();

            readings.add(new Reading(sensorId, temperature));
        }

        readings.stream()
                // 1. Filter temperatures greater than 50
                .filter(r -> r.temperature > 50)

                // 2 & 3. Group by sensor ID and calculate average
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))

                // 4. Sort by average temperature descending
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Double.compare(b.getValue(), a.getValue());

                    // If averages are equal, sort by SensorID
                    if (result == 0) {
                        return a.getKey().compareTo(b.getKey());
                    }

                    return result;
                })

                // Print result
                .forEach(e ->
                        System.out.println(e.getKey() + " " + e.getValue())
                );

        sc.close();
    }

    static class Reading {
        String sensorId;
        double temperature;

        Reading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
}