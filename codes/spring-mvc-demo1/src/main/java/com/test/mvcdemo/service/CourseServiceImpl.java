package com.test.mvcdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.mvcdemo.model.Chapter;
import com.test.mvcdemo.model.Course;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

  public Course getCourseById(Integer courseId) {
    Course course = new Course();
    
    course.setCourseId(courseId);
    course.setTitle("����Java MVC����");
    course.setImgPath("http://tuchong.pstatp.com/1000000/f/273942758.jpg");
    course.setLearningNum(51122);
    course.setLevel(2);
    course.setLevelDesc("�м�");
    course.setDuration(7200l);
    course.setDesc("��֮�ǽ��ܣ�һ�仰˵�������˵����");
    
    List<Chapter> chapterList = new ArrayList<Chapter>();
    
    warpChaterList(courseId, chapterList);
    
    course.setChapterList(chapterList);
    
    return course;
  }

  private void warpChaterList(Integer courseId, List<Chapter> chapterList) {
    Chapter chapter = new Chapter();
    chapter.setId(1);
    chapter.setCourseId(courseId);
    chapter.setOrder(1);
    chapter.setTitle("��1�� ���̱߳���֪ʶ����");
    chapter.setDesc("���½���������̱߳����صı�������");
    chapterList.add(chapter);
    
    chapter = new Chapter();
    chapter.setId(2);
    chapter.setCourseId(courseId);
    chapter.setOrder(2);
    chapter.setTitle("��2�� ���̱߳���֪ʶ����");
    chapter.setDesc("Ϊ������balbalbabalblalb�����½���������̱߳����صı�������");
    chapterList.add(chapter);
  }

}
