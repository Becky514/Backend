package com.travelapp.service.impl;

import com.travelapp.Mapper.CheckInMapper;
import com.travelapp.pojo.CheckInUserInfor;
import com.travelapp.pojo.Point;
import com.travelapp.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    CheckInMapper checkInMapper;

    @Override
    public void savePoi(Point poi) {
        List<String> allPid = checkInMapper.getAllPid();
        int flag=0;
        for (int i=0; i<allPid.size(); i++) {
            if (poi.getPid().equals(allPid.get(i))) {
                flag=1;
                checkInMapper.addPcount(poi.getPid());
                break;
            }
        }
        if (flag == 0) {
            checkInMapper.savePoiInfor(poi);
        }
    }

    @Override
    public Integer getPcount(String pid) {
        Integer pcount = checkInMapper.getPcountNum(pid);
        return pcount;
    }


    @Override
    public void saveUserInfor(CheckInUserInfor userInfor) {
        List<String> allUid = checkInMapper.getAllUid();
        List<String> allPid = checkInMapper.getAllPid_checkin();
        int flag = 0;
        for (int i=0; i<allUid.size(); i++) {
            if (userInfor.getUid().equals(allUid.get(i))) {
                for (int j=0; j<allPid.size(); j++) {
                    if (userInfor.getPid().equals(allPid.get(j))) {
                        checkInMapper.updateTimestamp(userInfor.getUid(), userInfor.getPid());
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                break;
            }
        }
        if (flag == 0) {
            checkInMapper.saveUserInfor(userInfor);
        }
    }

    @Override
    public Timestamp getCheckInTimeStamp(String uid, String pid) {
        Timestamp timestamp = checkInMapper.getTimeStamp(uid, pid);
        return timestamp;
    }
}
