package cn.oushubo.service.impl;

import cn.oushubo.pojo.Major;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DeptServiceImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    MajorServiceImpl majorServiceImpl = context.getBean("majorServiceImpl", MajorServiceImpl.class);
    @Test
    public void addTest() {
        Major major = new Major("31", "法语", 26000);
        major.setDeptId(402);
        majorServiceImpl.addMajor(major);
    }
    @Test
    public void updateTest() {
        Major major = new Major();
        major.setMajorId("31");
        major.setMajorName("俄语");
        majorServiceImpl.updateMajor(major);
    }
    @Test
    public void delTest() {
        majorServiceImpl.deleteMajorById("31");
    }

    @Test
    public void findAllMajorTest() {
        List<Major> allMajor = majorServiceImpl.findAllMajor();
        allMajor.forEach(System.out::println);
    }
}