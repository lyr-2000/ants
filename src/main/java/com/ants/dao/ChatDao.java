package com.ants.dao;

import com.ants.entity.ChatContactor;
import com.ants.entity.ChatUserBase;
import com.ants.entity.ChatUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:56
 * @Version V1.0
 **/
@Repository
public interface ChatDao {

    //根据学号查询对应的姓名
    ChatUserBase userQuery(int id);

    //查询id以及联系人对应的消息
    ChatUtil queryContactor(ChatUtil chatUtilDTO);

    //给某个id添加对应的联系人
    int insertcontactor(ChatUtil chatUtilDTO);

    //查询某个id对应的所有联系人
    List<ChatContactor> queryAllContactor(int id);

    //插叙id以及对应联系人的历史消息
    ChatContactor queryInformation(ChatUtil chatUtilDTO);

    //保存单个历史聊天消息
    int appendmsg(ChatContactor chatContactorDTO);
}
