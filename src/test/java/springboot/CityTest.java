package springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.dao.CityMapper;
import springboot.domain.City;

/**
 * Created by qiangber on 18-3-29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityTest {

    @Autowired
    CityMapper cityMapper;

    @Test
    public void addCity() {
        City city = new City(1L, "mianyang", "science city");
        Assert.assertTrue(cityMapper.addCity(city));
    }

    @Test
    public void deleteCity() {
        Assert.assertTrue(cityMapper.removeById(2L));
    }

    @Test
    public void updateCity() {
        City city = cityMapper.findCity(1L);
        city.setDescription("there are many pandas");
        Assert.assertTrue(cityMapper.updateCity(city));
    }

    @Test
    public void findCitys() {
        cityMapper.findCitys().forEach(System.out::println);
        Assert.assertEquals(cityMapper.findCitys().size(), 2);
    }

    @Test
    public void findCity() {
        Assert.assertEquals(cityMapper.findCity(1L).getName(), "chengdu");
    }

}
