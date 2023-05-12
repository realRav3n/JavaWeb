package edu.backend.Service;

import edu.backend.Entity.Paper;
import edu.backend.Mapper.PaperMapper;
import edu.backend.Mapper.UserMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {
    @Resource
    private PaperMapper paperMapper;
    public boolean addPaper(String text,  String title,  int author_id){
        return paperMapper.addPaper(text, title);
    }
    public boolean deletePaper(String text, String title,int author_id){
        return paperMapper.deletePaper(text, title, author_id);
    }
    public boolean alterPaper( String text, String title, int author_id){
        return paperMapper.alterPaper(text,title,author_id);
    }
    public List<Paper> findAllPapers(){
        return paperMapper.findAllPapers();
    }
    public Paper findPaperByName(String title){
        return paperMapper.findPaperByName(title);
    }
    public Paper findPaperByUserName(String author_name){
        return paperMapper.findPaperByUserName(author_name);
    }
}
