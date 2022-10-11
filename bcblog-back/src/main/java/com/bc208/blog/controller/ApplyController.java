package com.bc208.blog.controller;


import com.bc208.blog.dao.ApplyMapper;
import com.bc208.blog.pojo.Apply;
import com.bc208.blog.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apply")
@RestController
public class ApplyController {


    @Autowired
    ApplyMapper applyMapper;

    @RequestMapping("/submit")
    public ResultInfo apply(@RequestBody Apply apply){

        ResultInfo resultInfo = new ResultInfo();
        applyMapper.insertApply(apply);
        resultInfo.setResult("success");
        return resultInfo;

    }
}
