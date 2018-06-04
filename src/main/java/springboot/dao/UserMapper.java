package springboot.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import springboot.domain.User;

import java.util.List;

/**
 * Created by qiangber on 18-4-12.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



}
