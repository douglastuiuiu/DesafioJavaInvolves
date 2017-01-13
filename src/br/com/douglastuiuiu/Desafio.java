package br.com.douglastuiuiu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by douglasg on 06/01/2017.
 */
public class Desafio {

    public static void main(String[] args) {

        CityService.loadCitiesData();

        Map<CommandEnum, String> commands = new HashMap<>();
        commands.put(CommandEnum.COUNT, "count *");
        commands.put(CommandEnum.DISTINCT_COUNT, "count distinct");
        commands.put(CommandEnum.FILTER, "filter");
        commands.put(CommandEnum.EXIT, "exit");

        try {
            System.err.println("\n-- INITIATED APPLICATION --\n");
            Thread.sleep(500);
            Boolean isRunning = true;
            while (isRunning) {
                initConsole(commands);
                String command = startReadCommand();

                if (command.equalsIgnoreCase(commands.get(CommandEnum.COUNT))) {
                    System.out.println("RESULT:" + CityService.count());
                } else if (command.contains(commands.get(CommandEnum.FILTER).toLowerCase())) {
                    List<City> result = CityService.filter(command);
                    System.out.println("RESULT:");
                    for (City city : result) {
                        System.out.println(city);
                    }
                    System.out.println("ITENS: " + result.size());
                } else if (command.contains(commands.get(CommandEnum.DISTINCT_COUNT).toLowerCase())) {
                    String property = command.substring(command.lastIndexOf(" ")).trim();
                    System.out.println("RESULT:\n" + CityService.countDistinct(property));
                } else if (command.equalsIgnoreCase(CommandEnum.EXIT.toString().toLowerCase())) {
                    isRunning = false;
                    System.exit(0);
                } else {
                    System.err.println("Incorrect syntax! Type correctly one of the following commands:");
                    System.err.println("('count *', 'count distinct [property]', 'filter [property] [value]', 'exit')");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static String startReadCommand() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);
        return keyboard.readLine();
    }

    private static void initConsole(Map<CommandEnum, String> commands) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("     SUPORTED COMMANDS: " + commands.values());
        System.out.println("     COLUMNS: ibgeid, uf, name, capital, lon, lat, noaccents, alternativenames, microregion, mesoregion");
        System.out.println("WRITE THE COMMANDS:");
    }

}
