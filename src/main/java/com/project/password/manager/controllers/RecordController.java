package com.project.password.manager.controllers;

import com.project.password.manager.service.RecordService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("/record")
public class RecordController {

    private RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(value = "all-data", params = {"page", "size"})
    public Page<Object> getAllData(HttpServletRequest request,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size){
        return recordService.getAllRecordsByFilter(request, page, size);
    }
}