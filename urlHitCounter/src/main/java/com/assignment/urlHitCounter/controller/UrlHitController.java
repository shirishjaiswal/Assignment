package com.assignment.urlHitCounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    private static int count = 0;
    private HashMap<String, Integer> userMap = new HashMap<>();
    @GetMapping("/count/{userName}")
    public String  getVisitorByUser(@PathVariable String userName) {
        if (userName != null) {
            userMap.put(userName, userMap.getOrDefault(userName, 0)+1);
            plusCount();
        }
        return "userName : " + userName + "hitcount : " + userMap.get(userName);
    }

    @GetMapping("/count")
    public String  getHits() {
        plusCount();
        return "Visitors : " + count;
    }

    public void plusCount () {
        count++;
    }

}
