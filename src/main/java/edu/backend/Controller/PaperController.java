package edu.backend.Controller;

import edu.backend.Entity.Paper;
import edu.backend.Service.LoginService;
import edu.backend.Service.PaperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @PostMapping("add")
    boolean addPaper(@RequestParam String text, @RequestParam String title, @RequestParam int author_id){
        return paperService.addPaper(text, title, author_id);
    }
    @PostMapping("delete")
    boolean deletePaper(@RequestParam String text, @RequestParam String title, @RequestParam int author_id){
        return paperService.deletePaper(text, title, author_id);
    }
    @PostMapping("alter")
    boolean alterPaper(@RequestParam String text,@RequestParam String title,@RequestParam int author_id){
        return paperService.alterPaper(text, title, author_id);
    }
    @PostMapping("findAllPaper")
    List<Paper> findAllPapers(){
        return paperService.findAllPapers();
    }
    @PostMapping("findPaperByName")
    Paper findPaperByName(@RequestParam String title){
        return paperService.findPaperByName(title);
    }
    @PostMapping("findPaperByUserName")
    Paper findPaperByUserName(@RequestParam String user_name){
        return paperService.findPaperByUserName(user_name);
    }

}
