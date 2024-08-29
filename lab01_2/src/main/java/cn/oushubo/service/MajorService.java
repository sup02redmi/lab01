package cn.oushubo.service;

import cn.oushubo.pojo.Major;

import java.util.List;

public interface MajorService {
    int addMajor(Major major);
    int deleteMajorById(String majorId);
    int updateMajor(Major major);
    List<Major> findAllMajor();
}
