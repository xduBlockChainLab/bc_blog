package com.bc208.blog.service;

import com.bc208.blog.pojo.TeamTask;
import com.bc208.blog.pojo.UserTask;

import java.util.List;

public interface TeamTaskService {
     public List<TeamTask> teamTodolist( Integer type);
     public List<TeamTask> insertTeamTask(String task_content);
     public List<TeamTask> deleteTeamTask(int task_id,int task_type);
     public TeamTask  findById(int task_id);

}
