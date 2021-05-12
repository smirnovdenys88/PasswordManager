package com.project.password.manager.service.impl;

import com.project.password.manager.service.RecordService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RecordServiceImpl implements RecordService {
    @Override
    public Page<Object> getAllRecordsByFilter(HttpServletRequest request, int page, int size) {
        return null;
    }
}
