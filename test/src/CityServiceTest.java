package br.com.douglastuiuiu.test;

import br.com.douglastuiuiu.CityService;
import br.com.douglastuiuiu.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by douglasg on 12/01/2017.
 */
public class CityServiceTest {

    @Before
    public void loadCitiesData() {
        System.out.println("started");
        CityService.loadCitiesData();
    }

    @Test
    public void testCount() {
        Assert.assertEquals("A quantidade deveria ser 5565.", 5565, CityService.count());
    }

    @Test
    public void testCountDistinct() {
        Assert.assertEquals("A quantidade deveria ser 27.", 27, CityService.countDistinct("uf"));
    }

    @Test
    public void testFilter() {
        String[] cityOne = "3100609,MG,Água Boa,,-42.3896432301,-17.9910530496,Agua Boa,,Peçanha,Vale do Rio Doce".split(FileUtils.COMMA);
        String[] cityTwo = "5100201,MT,Água Boa,,-52.1589152986,-14.0490868003,Agua Boa,,Canarana,Nordeste Mato-Grossense".split(FileUtils.COMMA);
        Object[] expected = new Object[2];
        expected[0] = FileUtils.parseCityData(cityOne).toString();
        expected[1] = FileUtils.parseCityData(cityTwo).toString();

        Object[] received = new Object[2];
        received[0] = CityService.filter("filter name água boa").get(0).toString();
        received[1] = CityService.filter("filter name água boa").get(1).toString();
        Assert.assertEquals("Deveria retornar uma lista de cidades com as cidade de nome 'Água Boa'.", expected, received);
    }

}
