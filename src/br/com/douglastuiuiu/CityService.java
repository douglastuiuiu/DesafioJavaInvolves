package br.com.douglastuiuiu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by douglasg on 11/01/2017.
 */
public class CityService {

    private static List<City> cities = Main.cities;

    public static List<City> search(String prop, String value) {
        List<City> result = new ArrayList<>();
        try {
            City cityClass = new City();
            Method method = cityClass.getClass().getDeclaredMethod(buildMethodName(prop), null);
            for (City city : cities) {
                String cityValue = (String) method.invoke(city, null);
                if (isMatch(value, cityValue)) {
                    result.add(city);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String buildMethodName(String prop) {
        prop = prop.trim();
        return "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1).toLowerCase();
    }

    public static String buildPropertyName(String command) {
        return command.substring(command.indexOf(" ") + 1, (command.substring(command.indexOf(" ")).trim().indexOf(" ") + command.indexOf(" ") + 1));
    }

    public static String buildFilterValue(String property, String command) {
        return command.substring(command.indexOf(property) + property.length() + 1);
    }

    private static boolean isMatch(String value, String cityValue) {
        String value1 = cityValue.trim().toLowerCase();
        String value2 = value.trim().toLowerCase();
        return value1.indexOf(value2) >= 0 || value2.indexOf(value1) >= 0 || value1.equals(value2);
    }

    public static long count() {
        return cities.size();
    }

    public static long countDistinct(String property) {
        HashSet<String> alreadyExists = new HashSet<>();
        try {
            City cityClass = new City();
            Method method = cityClass.getClass().getDeclaredMethod(buildMethodName(property), null);
            for (City city : cities) {
                String cityValue = (String) method.invoke(city, null);
                alreadyExists.add(cityValue);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return alreadyExists.size();
    }
}
