package com.xyy.dubbo.fileservice.mapper;

import com.xyy.dubbo.client.mudule.FileInfo;
import com.xyy.dubbo.client.mudule.FileInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileInfoMapper {
    long countByExample(FileInfoExample example);

    int deleteByExample(FileInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    List<FileInfo> selectByExample(FileInfoExample example);

    FileInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

    int updateByExample(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
}