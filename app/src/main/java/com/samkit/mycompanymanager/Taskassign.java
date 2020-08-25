package com.samkit.mycompanymanager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taskassign {
    public Taskassign(Integer headId, Integer employeeId, String taskDetails) {
        this.headId = headId;
        this.employeeId = employeeId;
        this.taskDetails = taskDetails;
    }

    @SerializedName("head_id")
    @Expose
    private Integer headId;
    @SerializedName("employee_id")
    @Expose
    private Integer employeeId;
    @SerializedName("task_details")
    @Expose
    private String taskDetails;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}