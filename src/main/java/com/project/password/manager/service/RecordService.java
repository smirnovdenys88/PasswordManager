package com.project.password.manager.service;

import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;

public interface RecordService {
    Page<Object> getAllRecordsByFilter(HttpServletRequest request, int page, int size);
}
