package com.ants.impl.feedback;

import com.ants.dao.feedback.FeedbackDao;
import com.ants.entity.feedback.Feedback;
import com.ants.service.feedback.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理用户反馈的service实现类
 *
 * @Author czd
 * @Date:createed in 2019/10/11
 * @Version: V1.0
 */
@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    /**
     * 将用户进行反馈的信息添加到数据库中
     * @param feedback
     * @return
     */
    public int insertFeedback(Feedback feedback){

        return feedbackDao.insertFeedback(feedback);
    }
}
