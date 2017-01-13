package br.com.douglastuiuiu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by douglasg on 06/01/2017.
 */
public class FileUtils {

    public static final String COMMA = ",";

    private static List<String> loadCsvData() {
        List<String> result = new ArrayList<String>();
        File file = new File("resources/cidades.csv");
        final FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                result.add(bufferedReader.readLine());
            }
            result.remove(0);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static City parseCityData(String[] columns) {
        City city = new City();
        city.setIbgeid(columns[0]);
        city.setUf(columns[1]);
        city.setName(columns[2]);
        city.setCapital(columns[3]);
        city.setLon(columns[4]);
        city.setLat(columns[5]);
        city.setNoaccents(columns[6]);
        city.setAlternativenames(columns[7]);
        city.setMicroregion(columns[8]);
        city.setMesoregion(columns[9]);
        return city;
    }

    public static List<City> loadCitiesData() {
        List<City> result = new ArrayList<City>();
        List<String> csvData = loadCsvData();

        for (String cityData : csvData) {
            String[] columns = cityData.split(COMMA);
            City city = parseCityData(columns);
            result.add(city);
        }

        return result;
    }


}
