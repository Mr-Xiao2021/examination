package com.xxr.pojo;

/**
 * @ClassName PaperQuestion
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 8:17
 * @Version 1.0
 */
public class PaperQuestion {
    private Integer paperId;
    private Integer questionId;


    public PaperQuestion() {
    }

    public PaperQuestion(Integer paperId, Integer questionId) {
        this.paperId = paperId;
        this.questionId = questionId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "PaperQuestion{" +
                "paperId=" + paperId +
                ", questionId=" + questionId +
                '}';
    }
}
