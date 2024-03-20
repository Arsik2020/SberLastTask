package ru.intern.sberutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ru.intern.sberutils.bean.City;

public abstract class ProcessCity {

    public List<City> doProcess(String pathToFile) throws IllegalArgumentException {
        try (Scanner scanner = new Scanner(
                new File(pathToFile))) {

            List<City> allCities = new ArrayList<>();

            while (scanner.hasNext()) {
                City city = new City();
                String[] cityInfo;
                cityInfo = scanner.nextLine().split(";");
                city.setId(cityInfo[0]);
                city.setName(cityInfo[1]);
                city.setRegion(cityInfo[2]);
                city.setDistrict(cityInfo[3]);
                city.setPopulation(Integer.parseInt(cityInfo[4]));
                if (cityInfo.length > 5) {
                    city.setFoundation(cityInfo[5]);
                }
                allCities.add(city);
            }
            return allCities;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    public abstract void doAction(String path);
}
