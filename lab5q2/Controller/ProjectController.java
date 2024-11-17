package com.example.lab5q2.Controller;

import com.example.lab5q2.ApiResponse.ApiResponse;
import com.example.lab5q2.Module.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project added successfully");
    }

    @GetMapping("/display")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("Project updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Project deleted successfully");
    }

    @PutMapping("/change-status/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        projects.get(index).setStatus(!projects.get(index).isStatus());
        return new ApiResponse("Project status changed successfully");
    }

    @GetMapping("/search/{title}")
    public String getProjectByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return project.getTitle();
            }
        }
        return "Project not found";
    }

    @GetMapping("/display-by-company/{companyName}")
    public ArrayList<Project> displayProjectsByCompanyName(@PathVariable String companyName) {
        ArrayList<Project> projectsByCompany = new ArrayList<>();

        for (Project project : projects) {
            if (project.getCompanyName().equals(companyName)) {
                projectsByCompany.add(project);
            }
        }
        return projectsByCompany;
    }
}
