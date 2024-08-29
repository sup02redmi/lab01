package cn.oushubo.service.impl;


import cn.oushubo.mapper.DeptMapper;
import cn.oushubo.pojo.Dept;
import cn.oushubo.service.DeptService;
import cn.oushubo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    //1.通过工具类生成SqlSession对象
    SqlSession sqlSession = MybatisUtils.getSession();

    //2.实例化Mapper接口对象
    DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);

    /**
     * 1.根据系别编号查询系别信息
     */
    @Override
    public Dept findMajorById(Integer id) {
        Dept dept = deptMapper.findMajorById(id);
        System.out.println(dept.toString());
        //关闭方法Session
        sqlSession.close();
        return dept;
    }

    /**
     * 2.添加系别信息
     */
    @Override
    public int insertDept(Dept d) {
        //方法Session执行Mapper接口中定义的方法，并返回映射结果
        int rows = deptMapper.insertDept(d);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    @Override
    public List<Dept> findByCondition(String DeptName) {
        List<Dept> depts = deptMapper.findByCondition(DeptName);
        System.out.println(depts);
        sqlSession.close();
        return depts;
    }

    /**
     * 3.修改系别信息
     */
    @Override
    public int updateDept(Dept d) {
        //执行方法Session的更新方法，返回的是方法语句影响的行数
        int rows = deptMapper.updateDept(d);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    /**
     * 4.删除系别
     */
    @Override
    public int deleteDept(Dept d) {
        int rows = deptMapper.deleteDept(d);
        //提交事务
        sqlSession.commit();
        //关闭方法Session
        sqlSession.close();
        return  rows;
    }

    /**
     * 4.查询所有系别
     */
    @Override
    public List<Dept> findAllDept() {
        //方法Session执行Mapper接口中定义的方法，并返回映射结果
        List<Dept> dept = deptMapper.findAllDept();
        System.out.println(dept.size());
        //关闭方法Session
        sqlSession.close();
     return dept;
    }
    /**
     * 5.根据dept_id查询的所有专业信息
     */
    @Override
    public Dept findDeptById(Integer deptId) {
        //方法Session执行Mapper接口中定义的方法，并返回映射结果
        Dept dept = deptMapper.findDeptById(deptId);
        sqlSession.close();
        return dept;
    }
}
