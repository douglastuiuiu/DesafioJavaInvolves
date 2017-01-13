package br.com.douglastuiuiu.test;

import br.com.douglastuiuiu.FileUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by douglasg on 12/01/2017.
 */
public class FileUtilsTest {

    @Test
    public void testLoadCsvData() {
        String[] cityOne = "1100015,RO,Alta Floresta D'Oeste,,-61.9998238963,-11.9355403048,Alta Floresta D'Oeste,,Cacoal,Leste Rondoniense".split(FileUtils.COMMA);
        String[] cityTwo = "1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense".split(FileUtils.COMMA);
        String[] cityTree = "1100031,RO,Cabixi,,-60.5443135812,-13.4997634597,Cabixi,,Colorado do Oeste,Leste Rondoniense".split(FileUtils.COMMA);
        String[] cityFour = "1100049,RO,Cacoal,,-61.4429442118,-11.4338650287,Cacoal,,Cacoal,Leste Rondoniense".split(FileUtils.COMMA);
        String[] cityFive = "1100056,RO,Cerejeiras,,-60.8184261647,-13.195033032,Cerejeiras,,Colorado do Oeste,Leste Rondoniense".split(FileUtils.COMMA);
        Object[] expected = new Object[5];
        expected[0] = FileUtils.parseCityData(cityOne).toString();
        expected[1] = FileUtils.parseCityData(cityTwo).toString();
        expected[2] = FileUtils.parseCityData(cityTree).toString();
        expected[3] = FileUtils.parseCityData(cityFour).toString();
        expected[4] = FileUtils.parseCityData(cityFive).toString();

        Object[] received = new Object[5];
        received[0] = FileUtils.loadCitiesData().get(0).toString();
        received[1] = FileUtils.loadCitiesData().get(1).toString();
        received[2] = FileUtils.loadCitiesData().get(2).toString();
        received[3] = FileUtils.loadCitiesData().get(3).toString();
        received[4] = FileUtils.loadCitiesData().get(4).toString();
        Assert.assertEquals("Deveria retornar uma lista com as primeiras cinco cidade do arquivo.", expected, received);
    }
}
