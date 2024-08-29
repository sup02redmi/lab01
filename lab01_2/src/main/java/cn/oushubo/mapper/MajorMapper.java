package cn.oushubo.mapper;


import cn.oushubo.pojo.Major;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

public interface MajorMapper {
    //添加专业
    @Insert("insert into tb_major values(#{majorId},#{majorName},#{tuition},#{deptId})")
    public int addMajor(Major major);

    //更新专业
    @Update("update tb_major set major_name = #{majorName} where major_id = #{majorId}")
    public int updateMajor(Major major);

    //删除专业
    @Delete("delete from tb_major where major_id = #{majorId}")
    public int deleteMajorById(String majorId);

    //根据专业id查询专业
    @Select("select * from tb_major where major_id = #{majorId}")
    public Major findMajorById(String majorId);

    //查询所有专业
    @Select("select * from tb_major")
    public List<Major> findAllMajor();

    //根据专业名称模糊查找专业信息
    @Select("select * from tb_major where major_name like concat('%',#{majorName},'%')")
    @Results({
            @Result(id=true,column="major_id",property="majorId"),
            @Result(column="major_name",property="majorName"),
            @Result(property="tuition",column="tuition"),
            //方式一：嵌套查询
            //一对一：@One注解-使用select属性引入另外一条SQL语句
            @Result(property="dept",column="dept_id",
                    one=@One(select="cn.oushubo.mapper.DeptMapper.findDeptById",
                            fetchType= FetchType.LAZY))
    })
    public List<Major> findByMajorName(String majorName);

    @Select("select * from tb_major where dept_id=#{dept_id}")
    @Results({
            @Result(id = true, column = "major_id", property = "majorId"),
            @Result(column = "major_name", property = "majorName"),
            @Result(property = "tuition", column = "tuition")
    })
    public List<Major> findMajorByDeptId(Integer dept_id);
}
