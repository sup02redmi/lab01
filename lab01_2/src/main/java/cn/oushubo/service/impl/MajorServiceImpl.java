package cn.oushubo.service.impl;

import cn.oushubo.mapper.DeptMapper;
import cn.oushubo.mapper.MajorMapper;
import cn.oushubo.pojo.Major;
import cn.oushubo.service.MajorService;
import cn.oushubo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MajorServiceImpl implements MajorService {
    //1.通过工具类生成SqlSession对象
    SqlSession sqlSession = MybatisUtils.getSession();

    //2.实例化Mapper接口对象
    MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
    @Override
    public int addMajor(Major major) {
        int row = majorMapper.addMajor(major);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int deleteMajorById(String majorId) {
        int row = majorMapper.deleteMajorById(majorId);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int updateMajor(Major major) {
        int row = majorMapper.updateMajor(major);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public List<Major> findAllMajor() {
        return majorMapper.findAllMajor();
    }
}
