package com.sctp.module3project2.services;

import java.util.ArrayList;

import com.sctp.module3project2.entity.Userid;

public interface UseridService {
    Userid saveUserid(Userid userid);

    ArrayList<Userid> getAllUserid();

    Userid findUserByUserID(String userid);

    String findPassWordByUserID(String userid);
}
