package edu.backend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.backend.Entity.PaperUser;
import edu.backend.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperUserMapper extends BaseMapper<PaperUser> {
    List<PaperUser> findAllRecord();
}
