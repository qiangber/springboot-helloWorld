package springboot.dao;

import org.apache.ibatis.annotations.*;
import springboot.domain.City;

import java.util.List;

/**
 * Created by qiangber on 18-3-29.
 */
@Mapper
public interface CityMapper {

    @Insert("INSERT city(provinceId, name, description) VALUES(#{provinceId}, #{name}, #{description})")
    Boolean addCity(City city);

    @Delete("DELETE FROM city WHERE id = #{id}")
    Boolean removeById(Long id);

    @Update("UPDATE city SET provinceId = #{provinceId}, name = #{name}, description = #{description} WHERE id = #{id}")
    Boolean updateCity(City city);

    @Select("SELECT * FROM city")
    List<City> findCitys();

    @Select("SELECT * FROM city WHERE id = #{id}")
    City findCity(Long id);
}
