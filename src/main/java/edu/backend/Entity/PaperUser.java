package edu.backend.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("paper_user")
public class PaperUser {
    @TableId(type = IdType.AUTO)
    private int id;
    private int author_id;
    private int paper_id;
    private Date last_alter_time;

}
