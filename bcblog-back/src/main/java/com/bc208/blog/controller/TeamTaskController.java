package com.bc208.blog.controller;

import com.bc208.blog.pojo.TeamTask;
import com.bc208.blog.pojo.UserTask;
import com.bc208.blog.service.TeamTaskService;
import com.bc208.blog.utils.ParamsException;
import com.bc208.blog.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bc208/api")
public class TeamTaskController {
    @Autowired
    private TeamTaskService teamTaskService;

    @RequestMapping(method = RequestMethod.GET,value = "/teamtasks")
    @ResponseBody
    public ResultInfo ShowAllTasks(){
        ResultInfo resultInfo =new ResultInfo();
        List<TeamTask> teamTasks = teamTaskService.teamTodolist(0);



        try{
            resultInfo.setResult(teamTasks);
        }catch(ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("查找失败");
        }
        System.out.println(resultInfo);
        System.out.println(teamTasks);

        return resultInfo;

    }

    @RequestMapping("/insert_teamtask")
    @ResponseBody
    public ResultInfo insertTask(@RequestParam("task_content")String task_content){

        ResultInfo resultInfo = new ResultInfo();


        try{
            List<TeamTask> teamTask= teamTaskService.insertTeamTask(task_content);
            System.out.println(teamTask);
            resultInfo.setResult(teamTask);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("任务添加失败");
            resultInfo.setCode(500);
            resultInfo.setMsg("任务添加失败");
        }



        return resultInfo;
    }
}
