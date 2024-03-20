package ru.intern.sbercountcityinregion;

import ru.intern.sberutils.ProcessCity;
import ru.intern.sberutils.Utils;

public class Starter {

    public static void main(String[] args) {
        if (Utils.validate(args)) {
            ProcessCity city = new SberCountCityInRegion();
            city.doAction(args[0]);
        }
    }
}
