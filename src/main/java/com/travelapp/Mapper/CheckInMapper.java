package com.travelapp.Mapper;

import com.travelapp.pojo.CheckInUserInfor;
import com.travelapp.pojo.Point;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CheckInMapper {

    // For Position Information
    @Select("select pid from point_info;")
    List<String> getAllPid();

    // Save information for new check in point
    @Insert("insert into point_info(pid,pname,Lat,Lng,country,province,city,type) " +
            "values (#{pid},#{pname},#{Lat},#{Lng},#{country},#{province},#{city},#{type})")
    void savePoiInfor(Point p);


    // Update pcount for old check in point
    @Update("update point_info\n" +
            "set pcount = pcount+1\n" +
            "where pid = #{pid}")
    void addPcount(String pid);

    // Get pcount for poi
    @Select("select pcount from point_info where pid = #{pid};")
    Integer getPcountNum(String pid);


    // Save User Information after Check In
    @Select("select uid from user_checkin;")
    List<String> getAllUid();

    @Select("select pid from user_checkin;")
    List<String> getAllPid_checkin();

    // Save information for user
    @Insert("insert into user_checkin(uid,uname,pid,pname) " +
            "values (#{uid},#{uname},#{pid},#{pname})")
    void saveUserInfor(CheckInUserInfor userInfor);

    // Update Timestamp for old check in point
    @Update("update user_checkin\n" +
            "set last_checkin_date = current_timestamp()\n" +
            "where uid = #{uid} and pid = #{pid}")
    void updateTimestamp(String uid, String pid);

    // Get checkin_time and last TimeStamp
    @Select("select last_checkin_date\n" +
            "from user_checkin\n" +
            "where uid = #{uid} and pid = #{pid}")
    Timestamp getTimeStamp(String uid, String pid);
}
