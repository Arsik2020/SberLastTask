package ru.intern.sbercountcityinregion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.intern.sberutils.ProcessCity;
import ru.intern.sberutils.bean.City;

public class SberCountCityInRegion extends ProcessCity {

    @Override
    public void doAction(String path) {
        List<City> allCities = super.doProcess(path);
        String region = allCities.get(0).getRegion();
        Map<String, Integer> result = new HashMap<>();

        for (City city : allCities) {
            region = city.getRegion().equals(region) ? region : city.getRegion();
            result.put(region, result.getOrDefault(region, 0) + 1);
        }

        result.forEach((key, value) -> System.out.println(key + " - " + value));
    }

}
