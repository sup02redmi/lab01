package cn.oushubo.service.impl;

import cn.oushubo.pojo.Major;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DeptServiceImplTest {
    @Test
    public void addTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MajorServiceImpl majorServiceImpl = context.getBean("majorServiceImpl", MajorServiceImpl.class);
        Major major = new Major("31", "法语", 26000);
        major.setDeptId(402);
        majorServiceImpl.addMajor(major);
    }

    @Test
    public void delTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MajorServiceImpl majorServiceImpl = context.getBean("majorServiceImpl", MajorServiceImpl.class);
        majorServiceImpl.deleteMajorById("31");
    }
}