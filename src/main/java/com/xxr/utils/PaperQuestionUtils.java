package com.xxr.utils;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Paper;
import com.xxr.pojo.PaperQuestion;
import com.xxr.pojo.Question;
import com.xxr.service.PaperQuestionService;
import com.xxr.service.QuestionService;
import com.xxr.service.impl.PaperQuestionServiceImpl;
import com.xxr.service.impl.QuestionServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName PaperQuestionUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 9:01
 * @Version 1.0
 */
public class PaperQuestionUtils {

    private static final QuestionService QUESTION_SERVICE = new QuestionServiceImpl();
    private static final PaperQuestionService PAPER_QUESTION_SERVICE = new PaperQuestionServiceImpl();

    /**
     * 生成单张paper对应的题目编号，一对多的关系
     *
     * @description:
     * @param: brieflyNum majors
     * @return: java.util.Map<java.lang.String, java.util.List < com.xxr.pojo.Question>>
     * @author
     * @date: 9:06 2022/7/19
     */
    public static String generatePaperQuestionsJSON(boolean isAdd,int brieflyNum, Paper paper, int[] majors) {
        int judgeNum = paper.getJudgeNum();
        int multiNum = paper.getMulNum();
        int singleNum = paper.getSingleNum();
        //列出所有可供选择的题目选项
        List<Question> single = QUESTION_SERVICE.getTargetAll(0, majors);
        List<Question> multiple = QUESTION_SERVICE.getTargetAll(1, majors);
        List<Question> judge = QUESTION_SERVICE.getTargetAll(2, majors);
        List<Question> briefly = QUESTION_SERVICE.getTargetAll(3, majors);
        //随机索引生成器
        Random random = new Random();
        //存储questionIds的总容器
        List<Integer> totalIds = new ArrayList<>();

        int judgeSize = judge.size();
        int multipleSize = multiple.size();
        int singleSize = single.size();
        int brieflySize = briefly.size();

        if (judgeNum > judgeSize || multiNum > multipleSize || singleNum > singleSize || brieflyNum > brieflySize) {
            //数量超出限制，故舍弃
            return null;
        }
        int judgeRandom = random.nextInt(judgeSize);
        int multipleRandom = random.nextInt(judgeSize);
        int singleRandom = random.nextInt(singleSize);
        int brieflyRandom = random.nextInt(brieflySize);

        for (int i = 0; i < judgeNum; i++) {
            int index = (judgeRandom + i) % judgeSize;
            totalIds.add(judge.get(index).getId());
        }
        for (int i = 0; i < multiNum; i++) {
            int index = (multipleRandom + i) % multipleSize;
            totalIds.add(multiple.get(index).getId());
        }
        for (int i = 0; i < singleNum; i++) {
            int index = (singleRandom + i) % singleSize;
            totalIds.add(single.get(index).getId());
        }
        for (int i = 0; i < brieflyNum; i++) {
            int index = (brieflyRandom + i) % brieflySize;
            totalIds.add(briefly.get(index).getId());
        }


        insertPaperQuestions(totalIds, paper.getPaperId());
        return getPaperJsonByPaperId(paper.getPaperId(),isAdd);
    }


    /**
     * 将paper和question对应关系存储至数据库
     *
     * @description:
     * @param: map paperId
     * @return: void
     * @author
     * @date: 9:26 2022/7/19
     */
    private static void insertPaperQuestions(List<Integer> ids, int paperId) {
        List<PaperQuestion> paperQuestions = new ArrayList<>();
        for (Integer singleId : ids) {
            paperQuestions.add(new PaperQuestion(paperId, singleId));
        }
        PAPER_QUESTION_SERVICE.batchAddPaperQuestion(paperQuestions);
    }


    /**
     * @description: 根据得到的question_id集合得出question集合，并对其进行json格式化
     * @param: paperId
     * @return: java.lang.String
     * @author
     * @date: 10:12 2022/7/19
     */
    public static String getPaperJsonByPaperId(int paperId,boolean isAdd) {
        List<Integer> questionIds = PAPER_QUESTION_SERVICE.selectQuestionIdByPaperId(paperId);
        List<Question> questions = QUESTION_SERVICE.getQuestionsByIds(questionIds);

        List<Question> singleList = questions.stream().filter(e -> e.getType() == 0).collect(Collectors.toList());
        List<Question> multipleList = questions.stream().filter(e -> e.getType() == 1).collect(Collectors.toList());
        List<Question> judgeList = questions.stream().filter(e -> e.getType() == 2).collect(Collectors.toList());
        List<Question> brieflyList = questions.stream().filter(e -> e.getType() == 3).collect(Collectors.toList());

        Map<String, Object> mapQuestion = new HashMap<>(50);
        mapQuestion.put("paperId",paperId);
        if(!isAdd){

            mapQuestion.put("单选题", singleList);
            mapQuestion.put("多选题", multipleList);
            mapQuestion.put("对错题", judgeList);
            mapQuestion.put("简答题", brieflyList);
        }

        return JSON.toJSONString(mapQuestion);
    }


}
