package springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.dao.CityMapper;
import springboot.domain.City;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiangber on 18-3-29.
 */
@Api("城市信息模块")
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityMapper cityMapper;

    @ApiOperation(value = "添加一个城市信息")
    @ApiImplicitParam(name = "city", value = "城市信息实体", required = true, dataType = "City")
    @PostMapping
    public Map<String, String> addCity(@RequestBody City city) {
        Boolean isSuccess = cityMapper.addCity(city);
        Map<String, String> result = new HashMap<>();
        if (isSuccess) {
            result.put("result", "success");
        } else {
            result.put("result", "fail");
        }
        return result;
    }

    @ApiOperation(value = "删除一个城市信息")
    @ApiImplicitParam(name = "id", value = "城市ID",  required = true, paramType = "path", dataType = "Long")
    @DeleteMapping("/{id}")
    public Map<String, String> removeCity(@PathVariable Long id) {
        Boolean isSuccess = cityMapper.removeById(id);
        Map<String, String> result = new HashMap<>();
        if (isSuccess) {
            result.put("result", "success");
        } else {
            result.put("result", "fail");
        }
        return result;
    }

    @ApiOperation(value = "修改某个城市信息")
    @ApiImplicitParam(name = "city", value = "城市信息实体", required = true, dataType = "City")
    @PutMapping
    public Map<String, String> updateCity(@RequestBody City city) {
        Boolean isSuccess = cityMapper.updateCity(city);
        Map<String, String> result = new HashMap<>();
        if (isSuccess) {
            result.put("result", "success");
        } else {
            result.put("result", "fail");
        }
        return result;
    }

    @ApiOperation(value = "获取城市信息", notes = "根据城市id来获取城市信息")
    @ApiImplicitParam(name = "id", value = "城市ID",  required = true, paramType = "path", dataType = "Long")
    @GetMapping("/{id}")
    public City findCity(@PathVariable("id") Long id) {
        return cityMapper.findCity(id);
    }



}
