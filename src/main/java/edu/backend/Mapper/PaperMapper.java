package edu.backend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.backend.Entity.Paper;
import edu.backend.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
    boolean addPaper(@Param("text") String text,@Param("title") String title);
    boolean deletePaper(@Param("text") String text,@Param("title") String title,@Param("author_id") int author_id);
    boolean alterPaper(@Param("text") String text,@Param("title") String title,@Param("author_id") int author_id);
    List<Paper> findAllPapers();
    Paper findPaperByName(@Param("title") String title);
    Paper findPaperByUserName(@Param("author_name") String title);
}
