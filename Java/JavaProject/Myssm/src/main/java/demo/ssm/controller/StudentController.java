package demo.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import demo.ssm.bean.Student;
import demo.ssm.service.ClazzService;
import demo.ssm.service.StudentService;
import demo.ssm.util.UploadFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    // 注入业务对象
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;

    //存储预返回页面的数据对象
    private Map<String, Object> result = new HashMap<>();

    @GetMapping("/goStudentListView")
    public ModelAndView goStudentListView(ModelAndView modelAndView) {
        //向页面发送一个存储着Clazz的List对象
        modelAndView.addObject("clazzList", clazzService.selectAll());
        modelAndView.setViewName("student/studentList");
        return modelAndView;
    }


    @PostMapping("/getStudentList")
    @ResponseBody
    public Map<String, Object> getStudentList(Integer page, Integer rows, String studentname, String clazzname) {

        //存储查询的studentname,clazzname信息
        Student student = new Student(studentname, clazzname);
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //根据班级与学生名获取指定或全部学生信息列表
        List<Student> list = studentService.selectList(student);
        //封装信息列表
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Student> studentList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", studentList);

        return result;
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public Map<String, Object> addStudent(Student student) {
        //判断学号是否已存在
        if (studentService.fingBySno(student) != null) {
            result.put("success", false);
            result.put("msg", "该学号已经存在! 请修改后重试!");
            return result;
        }
        //添加学生信息
        if (studentService.insert(student) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "添加失败!服务器端发生异常!");
        }

        return result;
    }

    @PostMapping("/editStudent")
    @ResponseBody
    public Map<String, Object> editStudent(Student student) {
        if (studentService.update(student) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "添加失败!服务器端发生异常!");
        }
        return result;
    }

    @PostMapping("/deleteStudent")
    @ResponseBody
    public Map<String, Object> deleteStudent(@RequestParam(value = "ids[]", required = true) Integer[] ids) {

        if (studentService.deleteById(ids) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }

    @PostMapping("/uploadPhoto")
    @ResponseBody
    public Map<String, Object> uploadPhoto(MultipartFile photo, HttpServletRequest request) {
        //存储头像的本地目录
        final String dirPath = request.getServletContext().getRealPath("/upload/student_portrait/");
        //存储头像的项目发布目录
        final String portraitPath = request.getServletContext().getContextPath() + "/upload/student_portrait/";
        //返回头像的上传结果
        return UploadFile.getUploadResult(photo, dirPath, portraitPath);
    }
}