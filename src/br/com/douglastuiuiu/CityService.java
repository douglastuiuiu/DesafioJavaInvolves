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

    public static List<City> search(String command) {
        List<City> result = new ArrayList<>();
        String property = buildPropertyName(command);
        String value = buildFilterValue(property, command);
        try {
            Method method = new City().getClass().getDeclaredMethod(buildMethodName(property), null);
            for (City city : Main.cities) {
                String cityValue = (String) method.invoke(city, null);
                if (isMatch(value, cityValue)) {
                    result.add(city);
                }
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Property [" + property + "] not found");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static long count() {
        return Main.cities.size();
    }

    public static long countDistinct(String property) throws NoSuchMethodException {
        HashSet<String> itens = new HashSet<>();
        try {
            Method method = new City().getClass().getDeclaredMethod(buildMethodName(property), null);
            for (City city : Main.cities) {
                String cityValue = (String) method.invoke(city, null);
                itens.add(cityValue);
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Property [" + property + "] not found");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return itens.size();
    }

    private static String buildMethodName(String property) {
        property = property.trim();
        return "get" + property.substring(0, 1).toUpperCase() + property.substring(1).toLowerCase();
    }

    private static String buildPropertyName(String command) {
        return command.substring(command.indexOf(" ") + 1, (command.substring(command.indexOf(" ")).trim().indexOf(" ") + command.indexOf(" ") + 1));
    }

    private static String buildFilterValue(String property, String command) {
        return command.substring(command.indexOf(property) + property.length() + 1);
    }

    private static boolean isMatch(String value, String cityValue) {
        String value1 = cityValue.trim().toLowerCase();
        String value2 = value.trim().toLowerCase();
        return value1.indexOf(value2) >= 0 || value2.indexOf(value1) >= 0 || value1.equals(value2);
    }

}
