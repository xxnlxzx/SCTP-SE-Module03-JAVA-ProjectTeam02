package com.sctp.module3project2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.Userid;
import com.sctp.module3project2.exception.ShippingRouteNotFoundException;
import com.sctp.module3project2.repository.UseridRepository;


@Service
public class UseridServiceImpl implements UseridService {
    private UseridRepository useridRepository;

    public UseridServiceImpl(UseridRepository useridRepository){
        this.useridRepository = useridRepository;
    }
    @Override
    public Userid saveUserid(Userid userid) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid.getUserid());
        if (wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("User ID already in system");
        }

        Userid newUserid = useridRepository.save(userid);
        return newUserid;
    }

    @Override
    public ArrayList<Userid> getAllUserid() {
        ArrayList<Userid> allUserid = (ArrayList<Userid>) useridRepository.findAll();
        return allUserid; 
    }
    @Override
    public Userid findUserByUserID(String userid) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid);
        
        return wrappedUserid.get();
    }
    @Override
    public String findPassWordByUserID(String userid) {
        Optional<Userid> wrappedUserid = ((UseridRepository) useridRepository).findByUserid(userid);
        if (!wrappedUserid.isPresent()){
            throw new ShippingRouteNotFoundException("User ID not found");
        }

        Userid useridFound = wrappedUserid.get();
        return useridFound.getPassword();
    }
    
}
