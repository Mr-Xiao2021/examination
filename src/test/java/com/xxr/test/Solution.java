package com.xxr.test;

import com.alibaba.fastjson.JSON;
import com.xxr.mapper.BankMapper;
import com.xxr.mapper.MajorMapper;
import com.xxr.mapper.QuestionMapper;
import com.xxr.pojo.*;
import com.xxr.service.*;
import com.xxr.service.impl.*;
import com.xxr.utils.PaperQuestionUtils;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 13:05
 * @Version 1.0
 */
public class Solution {
    private StudentService ss = new StudentServiceImpl();
    private TeacherService ts = new TeacherServiceImpl();
    private MajorService ms = new MajorServiceImpl();
    private BankService bs = new BankServiceImpl();
    private QuestionService qs = new QuestionServiceImpl();
    private PaperService ps = new PaperServiceImpl();
    private PaperQuestionService pqs = new PaperQuestionServiceImpl();

    @Test
    public void testSelectAll() {
//        ss.selectAll().forEach(System.out::println);
//        ts.selectAll().forEach(System.out::println);
//        ms.selectAll().forEach(System.out::println);

        String jsonString = JSON.toJSONString(ms.selectAll());
        System.out.println(jsonString);
    }

    @Test
    public void testSelectById() {
        int id = 1;
        Student student = ss.selectStuById(id);
        System.out.println(student);
    }

    @Test
    public void testAddStudent() {
        int studentId = 11;
        String name = "test_man";
        String password = "test@java";
        String email = "test@163.com";
        int teacherId = 234;
        int majorId = 1;

        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        map.put("name", name);
        map.put("password", password);
        map.put("email", email);
        map.put("teacherId", teacherId);
        map.put("majorId", majorId);

        Student s = ss.selectStuById(studentId);
        if (s != null) {
            System.out.println("Exist!");
        } else {

//            ss.addStudent(map);
        }
        ss.selectAll().forEach(System.out::println);
    }


    @Test
    public void testLogin() {
        boolean isStu = true;

        Student student = new Student();
//        student.setStudentId(1);
        student.setName("xxr");
        student.setPassword("xxr@java");
        Student loginStu = ss.login(student);
        System.out.println(loginStu);

        Teacher teacher = new Teacher();
        teacher.setTeacherId(123);
        teacher.setPassword("12345678901");
        Teacher loginTeacher = ts.login(teacher);
        System.out.println(loginTeacher);
    }


    @Test
    public void testSelectTeacherById() {
        int id = 789;
        System.out.println(ts.selectTeacherById(id));
    }

    @Test
    public void testSelectMajorById() {
        int id = 2;
        System.out.println(ms.selectMajorById(id));
    }

    @Test
    public void testJsonStr() {
        boolean isExist = false;
        HashMap<String, Object> map = new HashMap<>();
        map.put("isExist", isExist);
        String s = JSON.toJSONString(map);
        System.out.println(s);
    }

    @Test
    public void testConditionSelect() {
        String email = "%qq.com%";
        String name = "xxr";
        int tId = 234;
        int majorId = 1;
        Student student = new Student();
        student.setEmail(email);
//        student.setName(name);
//        student.setTeacherId(tId);
//        student.setMajorId(majorId);

        ss.selectByCondition(student).forEach(System.out::println);
    }


    @Test
    public void testReg() {
        String studentIdStr = "-1";
        String reg = "^[0-9]*[1-9][0-9]*$";
        System.out.println(studentIdStr.matches(reg));
    }

    @Test
    public void testCount() {
//        System.out.println(ss.selectStuCount());
        Student s = new Student();
        s.setName("%n%");
        System.out.println(ss.selectStuCountByCondition(null));

    }

    @Test
    public void testMap() {
//        Map<String, Object> map = ss.getByStudentIdToMap(1);
//        System.out.println(map);
        Student s = new Student();
        s.setName("n");
//        s.setEmail("%t%");
        List<Map<String, Object>> list = ss.getStuByCdtToList(s);
        list.forEach(k -> {
            k.forEach((key, value) -> System.out.println(key + "-->\t" + value));
            System.out.println("#########################");
        });
    }

    @Test
    public void testBank() {
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
//        Bank bank = new Bank(3, "xxr", "bye bye", new Date());
//        bs.deleteByName(bank);
//        bankMapper.getAllName().forEach(System.out::println);

//        System.out.println(bs.getCurrentId());
//        List<String> allName = bs.getAllName();
//        String jsonString = JSON.toJSONString(allName);
//        System.out.println(jsonString);
    }


    @Test
    public void testQuestion() {
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
//        System.out.println(JSON.toJSONString(questionMapper.getAllQuestion()));
//        sqlSession.close();
        Question question = qs.getAllQuestion().get(0);
        question.setId(7);
        qs.deleteById(question);
    }

    @Test
    public void testUpdate() {
        Student student = new Student(6, "asasa", "21312141", "asda@adsa.com", null, null, "女");
        ss.updateStudent(student);
//        ss.selectAll().forEach(System.out::println);
    }

    @Test
    public void testUpdateBank() {
        Bank bank = new Bank(2, "hah", "asdasda", new Date());

        String s = JSON.toJSONString(bs.getAllName());
        System.out.println(s);
    }

    @Test
    public void test45() {
        Student student = new Student(null, "hahaaa", "asdasd", "asas@asa.cn", 123, 23, "男");
        ss.addStudent(student);
    }

    @Test
    public void test46() {
//        Bank bank = new Bank(3, "asda", "test", new Date());
//        bs.insert(bank);
        System.out.println(JSON.toJSONString(bs.getAllName()));
    }

    @Test
    public void test67() {
//        System.out.println(ms.selectAll());
//        System.out.println();
//        bs.getAllName().forEach(System.out::println);

        List<Question> allQuestion = qs.getAllQuestion();

        System.out.println(allQuestion);

//        System.out.println(bs.getNameById(1));
//
//        System.out.println(ms.getNameById(2));
    }


    @Test
    public void t1() {
        Student student = new Student(1, "xxr0", "xxr0@java", "xxr0@xmu", 2, 1, "女");
        ss.updateStudent(student);
    }


    @Test
    public void t2() {
        Teacher teacher = new Teacher(123, "Test", "xxr");
        ts.update(teacher);
    }

    @Test
    public void testPapers() {
//        System.out.println(JSON.toJSONString(ps.selectById(1)));
//        Paper p = new Paper(null, "Test", 10, 8, 10, 1, null);
//        int i = ps.addPaper(p);
//        System.out.println(i);
        qs.getTargetAll(3, new int[]{1}).forEach(System.out::println);
//        qs.getAllQuestion().forEach(System.out::println);

//        System.out.println(ps.selectByPaperId(17));


    }

    @Test
    public void testRandom() {
        Random random = new Random();
//        getTarget(3,2,3,3,new int[]{1});
        int judgeRandom = random.nextInt(5);
        int multipleRandom = random.nextInt(6);
        int singleRandom = random.nextInt(8);
        int brieflyRandom = random.nextInt(4);

        System.out.println(judgeRandom);
        System.out.println(multipleRandom);
        System.out.println(singleRandom);
        System.out.println(brieflyRandom);

        int judgeNum = 3;
        int multiNum = 4;
        int singleNum = 5;
        int brieflyNum = 2;


        for (int i = 0; i < judgeNum; i++) {
            int index = (judgeRandom + i) % 5;
            System.out.println(judgeRandom + "----5--judge----" + index);
        }
        System.out.println();
        for (int i = 0; i < multiNum; i++) {
            int index = (multipleRandom + i) % 6;
            System.out.println(multipleRandom + "----6--multiple----" + index);
        }
        System.out.println();
        for (int i = 0; i < singleNum; i++) {
            int index = (singleRandom + i) % 8;
            System.out.println(singleRandom + "----8--single----" + index);
        }
        System.out.println();
        for (int i = 0; i < brieflyNum; i++) {
            int index = (brieflyRandom + i) % 4;
            System.out.println(brieflyRandom + "----4--briefly----" + index);
        }
    }


    private Map<String, List<Question>> getTarget(int judgeNum, int multiNum, int singleNum, int brieflyNum, int[] majors) {
        Map<String, List<Question>> mapQuestion = new HashMap<>();
        List<Question> singleList = new ArrayList<>();
        List<Question> multipleList = new ArrayList<>();
        List<Question> judgeList = new ArrayList<>();
        List<Question> brieflyList = new ArrayList<>();
        //根据选择的题目数量及其majors数组随机生成题目组合
        List<Question> single = qs.getTargetAll(0, majors);
        List<Question> multiple = qs.getTargetAll(1, majors);
        List<Question> judge = qs.getTargetAll(2, majors);
        List<Question> briefly = qs.getTargetAll(3, majors);
        //随机生成器
        Random random = new Random();

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
            judgeList.add(judge.get(index));
        }
        for (int i = 0; i < multiNum; i++) {
            int index = (multipleRandom + i) % multipleSize;
            multipleList.add(multiple.get(index));
        }
        for (int i = 0; i < singleNum; i++) {
            int index = (singleRandom + i) % singleSize;
            singleList.add(single.get(index));
        }
        for (int i = 0; i < brieflyNum; i++) {
            int index = (brieflyRandom + i) % brieflySize;
            brieflyList.add(briefly.get(index));
        }

        mapQuestion.put("单选题", singleList);
        mapQuestion.put("多选题", multipleList);
        mapQuestion.put("对错题", judgeList);
        mapQuestion.put("简答题", brieflyList);

        return mapQuestion;
    }


    @Test
    public void test223() {
//        System.out.println(qs.getQuestionById(199));
        Map<String, List<Question>> map = getTarget(2, 2, 3, 2, new int[]{1, 6});
//        map.forEach((k,v)-> {
//            System.out.println(k);
//            v.forEach(System.out::println);
//            System.out.println("#####################################");
//        });

        System.out.println(JSON.toJSONString(map));
//        System.out.println(qs.getQuestionById(151));
    }

    @Test
    public void getPaperQuestion() {
        List<PaperQuestion> paperQuestions = new ArrayList<>();
        paperQuestions.add(new PaperQuestion(1, 1));
        paperQuestions.add(new PaperQuestion(2, 1));
        paperQuestions.add(new PaperQuestion(1, 2));
        paperQuestions.add(new PaperQuestion(1, 3));
        paperQuestions.add(new PaperQuestion(1, 4));
        paperQuestions.add(new PaperQuestion(1, 5));
        paperQuestions.add(new PaperQuestion(2, 2));
        paperQuestions.add(new PaperQuestion(2, 3));
        paperQuestions.add(new PaperQuestion(2, 4));

        pqs.batchAddPaperQuestion(paperQuestions);
//        pqs.addPaperQuestion(new PaperQuestion(1,1));
    }


    @Test
    public void test121() {
//        Paper paper = new Paper();
//        paper.setPaperId(3);
//        paper.setSingleNum(3);
//        paper.setMulNum(4);
//        paper.setJudgeNum(3);
//        String s1 = PaperQuestionUtils.generatePaperQuestionsJSON(2,paper,new int[]{1,2,3});
//        String s2 = PaperQuestionUtils.getPaperJsonByPaperId(paper.getPaperId());
//        System.out.println(s2);
//        System.out.println(s1.equals(s2));
//        String path = Thread.currentThread().getContextClassLoader().getResource("testPath.txt").getPath();
//        System.out.println(path);
//        System.out.println("map-JSONs----");
//        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void test454() {
//        System.out.println(PaperQuestionUtils.getPaperJSONByPaperId(2));
//        System.out.println(PaperQuestionUtils.getPaperJsonByPaperId(3));
//        ps.selectById(3).forEach(System.out::println);
        int currentPage = 7;
        int pageSize = 6;
//        System.out.println(ps.selectTotalCount());
        PageBean<Paper> paperPageBean = ps.selectPaperByPage(currentPage, pageSize);
//        System.out.println(paperPageBean);
        System.out.println("count---"+paperPageBean.getTotalCount());
        paperPageBean.getRows().stream().map(Paper::getPaperId).forEach(System.out::println);
    }


    @Test
    public void loginTest(){
//        Student s = new Student();
//        s.setStudentId(2);
//        s.setPassword("wjhwjh123");
//
//        Student login = ss.login(s);
//        System.out.println(login);

        Teacher t = new Teacher();
        t.setTeacherId(12);
        t.setPassword("123123123");
        System.out.println(ts.login(t));

    }

    @Test
    public void test78(){
//        PageBean<Paper> paperPageBean = ps.selectPaperByPage(1, 5);
//        paperPageBean.getRows().forEach(System.out::println);
//        PageBean<Question> questionPageBean = qs.selectPaperByPage(1, 5);
//        questionPageBean.getRows().forEach(System.out::println);

        ps.selectAll().forEach(System.out::println);
//        System.out.println(ss.selectStuById(1));
    }

    @Test
    public void test789(){
//        PageBean<Paper> paperPageBean = ps.selectPaperByPage(1, 5);
//        paperPageBean.getRows().forEach(System.out::println);
//        PageBean<Question> questionPageBean = qs.selectPaperByPage(1, 5);
//        questionPageBean.getRows().forEach(System.out::println);

//        ps.selectAll().forEach(System.out::println);
//        System.out.println(ss.selectStuById(1));

//        ps.updateGrade(0,"99");
        System.out.println(ps.selectByPaperId(5));
    }

}
