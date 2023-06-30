package com.geekster.hospitalAPI.service;

import com.geekster.hospitalAPI.dao.StatusDao;
import com.geekster.hospitalAPI.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    StatusDao statusDao;

    public int saveStatus(Status statusData) {
        return statusDao.save(statusData).getStatusId();
    }
}
