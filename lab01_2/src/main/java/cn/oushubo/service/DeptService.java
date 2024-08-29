package cn.oushubo.service;



import cn.oushubo.pojo.Dept;

import java.util.List;

public interface DeptService {
    Dept findMajorById(Integer dept_id);
    int  deleteDept(Dept dept);
    int  updateDept(Dept d);
    int insertDept(Dept d);
    List<Dept> findByCondition(String deptName);
    List<Dept> findAllDept();
    Dept findDeptById(Integer deptId);

}
