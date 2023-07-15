package com.travelapp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInUserInfor {
    private String uid;
    private String uname;
    private String pid;
    private String pname;
    private Timestamp last_checkin_date;
}
