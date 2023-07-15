package com.travelapp.service;

import com.travelapp.pojo.CheckInUserInfor;
import com.travelapp.pojo.Point;

import java.sql.Timestamp;


public interface CheckInService {

    public void savePoi(Point poi);

    Integer getPcount(String pid);

    public void saveUserInfor(CheckInUserInfor userInfor);

    Timestamp getCheckInTimeStamp(String uid, String pid);
}
