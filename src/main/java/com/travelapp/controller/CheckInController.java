package com.travelapp.controller;

import com.travelapp.pojo.CheckInUserInfor;
import com.travelapp.pojo.Point;
import com.travelapp.pojo.Result;
import com.travelapp.service.CheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
@Slf4j
public class CheckInController {
    @Autowired
    CheckInService checkInService;

    @GetMapping("checkInPoi")
    public Result savePoi(Point p) {
        log.info("Save Poi information after Check In");
        checkInService.savePoi(p);
        return Result.success();
    }

    @GetMapping("getPcountForPoi")
    public Result getPcount(String pid) {
        log.info("getPcount Num before check in");
        Integer pcount = checkInService.getPcount(pid);
        return Result.success(pcount);
    }

    @GetMapping("saveUserInfo")
    public Result saveUser(CheckInUserInfor userInfor) {
        log.info("Save User Information after Check In");
        checkInService.saveUserInfor(userInfor);
        return Result.success();
    }

    @GetMapping("getCheckInTime")
    public Result getCheckInTime(String uid, String pid) {
        log.info("getCheckInTimeStamp after check in");
        Timestamp checkinTime = checkInService.getCheckInTimeStamp(uid, pid);
        return Result.success(checkinTime);
    }
}
