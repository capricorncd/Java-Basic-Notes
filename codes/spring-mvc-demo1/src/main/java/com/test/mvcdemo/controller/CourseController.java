package com.test.mvcdemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mvcdemo.model.Course;
import com.test.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
// /courses/*
public class CourseController {
  
  private static Logger log = LoggerFactory.getLogger(CourseController.class);
  
  private CourseService courseService;
  
  @Autowired
  public void setCourseServiceImpl(CourseService courseService) {
    this.courseService = courseService;
  }
  
  // ������������ /course/view?courseId=123
  @RequestMapping(value="/view", method=RequestMethod.GET)
  public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
    
    log.debug("In viewCourse, courseId = {}", courseId);
    
    Course course = courseService.getCourseById(courseId);
    model.addAttribute(course);
    // ����jsp���ļ���
    return "course-overview";
  }
  
  // /courses/view2/{courseId}
  @RequestMapping(value="/view2/{courseId}", method=RequestMethod.GET)
  public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
    log.debug("In viewCourse2, courseId = {}", courseId);
    Course course = courseService.getCourseById(courseId);
    model.put("course", course);
    return "course-overview";
  }
  
  // /course/view?courseId=333
  @RequestMapping("view3")
  public String viewCourse3(HttpServletRequest request) {
    Integer courseId = Integer.valueOf(request.getParameter("courseId"));
    Course course = courseService.getCourseById(courseId);
    request.setAttribute("course", course);
    return "course-overview";
  }
  
  @RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
  public String createCourse() {
    return "admin/edit";
  }
  
  // ���մ�����������
  @RequestMapping(value="/save", method=RequestMethod.POST)
//  public String doSave(Course course) {
  public String doSave(@ModelAttribute Course course) {
    
    log.debug("Info of Course");
    log.debug(ReflectionToStringBuilder.toString(course));
    
    System.out.println(course.toString());
    
    // �ڴ˽���ҵ��������������ݿ�־û�
    course.setCourseId(555);
    return "redirect:view2/" + course.getCourseId();
  }
}