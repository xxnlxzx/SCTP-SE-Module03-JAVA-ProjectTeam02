package com.sctp.module3project2.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.entity.Userid;
import com.sctp.module3project2.services.UseridService;

@RestController
@RequestMapping("/users")
public class UseridController {
    private UseridService useridService;

    public UseridController(UseridService useridService){
        this.useridService = useridService;
    }

    @PostMapping("")
    public ResponseEntity<Userid> saveUserid(@RequestBody Userid userid){
        Userid newUserid = useridService.saveUserid(userid);
        return new ResponseEntity<>(newUserid, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Userid>> getAllUserid() {
        ArrayList<Userid> allUserid = useridService.getAllUserid();
        return new ResponseEntity<>(allUserid, HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Userid> getUseridByUserid(@PathVariable String userid) {
        Userid foundUserid = useridService.findUserByUserID(userid);
        return new ResponseEntity<>(foundUserid,HttpStatus.OK);
    }
    @GetMapping("/password/{userid}")
    public ResponseEntity<String> findPassWordByUserID(@PathVariable String userid) {
        String foundPassword = useridService.findPassWordByUserID(userid);
        return new ResponseEntity<>(foundPassword,HttpStatus.OK);
    }
}
