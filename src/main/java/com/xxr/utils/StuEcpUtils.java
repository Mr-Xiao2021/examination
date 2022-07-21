package com.xxr.utils;

import com.xxr.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

/**根据传入的request封装Student对象
 * @ClassName StuEcpUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 21:49
 * @Version 1.0
 */
public class StuEcpUtils {
    @SafeVarargs
    public static Student getStuInstance(HttpServletRequest request, Map<String,Object>... maps){
        Map<String, String[]> map = request.getParameterMap();

        int studentId = Integer.parseInt(map.get("student_id")[0]);
        int teacherId = Integer.parseInt(map.get("teacher_id")[0]);
        int majorId = Integer.parseInt(map.get("major_id")[0]);
        String name = map.get("name")[0];
        String password = map.get("password")[0];
        String email = map.get("email")[0];

        if(maps.length == 1){
            maps[0].put("studentId",studentId);
            maps[0].put("teacherId",teacherId);
            maps[0].put("majorId",majorId);
            maps[0].put("name",name);
            maps[0].put("password",password);
            maps[0].put("email",email);

        }

        return new Student(studentId,name,password,email,teacherId,majorId,null);
    }

    public static Map<String, Object> getStuMap(HttpServletRequest request) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        getStuInstance(request,map);
        return map;
    }
}
