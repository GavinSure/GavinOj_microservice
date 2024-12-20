package com.gavin.gavinojbackendquestionservice.service;


import com.Gavin.gavinojbackendmodel.dto.questionsubmit.QuestionSubmitAddRequest;
import com.Gavin.gavinojbackendmodel.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import com.Gavin.gavinojbackendmodel.entity.User;
import com.Gavin.gavinojbackendmodel.vo.QuestionSubmitVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author sms
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2024-04-13 13:54:25
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
