package com.nt.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entiry.Project;
import com.nt.repository.ProjectRepository;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping({"/", "/student-project-hub"})
    public String index() {
        return "index";
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam String name,
                         @RequestParam String rollNumber,
                         @RequestParam String year,
                         @RequestParam String phone,
                         @RequestParam String title,
                         @RequestParam String description,
                         @RequestParam String technologiesStack,
                         @RequestParam String developmentSteps,
                         @RequestParam(required = false) String projectUrl,
                         @RequestParam("file") MultipartFile file,
                         @RequestParam("videofilePath") MultipartFile videofilePath) throws IOException {

        java.nio.file.Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
        if (Files.notExists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filePath1 = null;
        if (!file.isEmpty()) {
            String fileName1 = file.getOriginalFilename();
            filePath1 = uploadPath + File.separator + fileName1;
            Files.copy(file.getInputStream(), Paths.get(filePath1), StandardCopyOption.REPLACE_EXISTING);
        }
        
        

        String filePath2 = null;
        if (!videofilePath.isEmpty()) {
            String fileName2 = videofilePath.getOriginalFilename(); // <-- use videofilePath
            filePath2 = uploadPath + File.separator + fileName2;
            Files.copy(videofilePath.getInputStream(), Paths.get(filePath2), StandardCopyOption.REPLACE_EXISTING);
        }

        

        Project p = new Project();
        p.setName(name);
        p.setRollNumber(rollNumber);
        p.setYear(year);
        p.setPhone(phone);
        p.setTitle(title);
        p.setDescription(description);
        p.setFilePath(filePath1);
        p.setVideofilePath(filePath2);
        p.setTechnologiesStack(technologiesStack);
        p.setDevelopmentSteps(developmentSteps);
        p.setProjectUrl(projectUrl);

        repo.save(p);

        return "redirect:/projects";
    }

    @GetMapping("/projects")
    public String showProjects(Model model) {
        model.addAttribute("projects", repo.findAll());
        return "showProjects";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("project", repo.findById(id).orElse(null));
        return "viewDetails";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<FileSystemResource> download(@PathVariable int id) {
        Project p = repo.findById(id).orElse(null);
        if (p == null || p.getFilePath() == null) {
            return ResponseEntity.notFound().build();
        }

        File file = new File(p.getFilePath());
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        FileSystemResource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    
    @GetMapping("/download-supporting/{id}")
    public ResponseEntity<FileSystemResource> downloadSupporting(@PathVariable int id) {
        Project p = repo.findById(id).orElse(null);
        if (p == null || p.getVideofilePath() == null) {
            return ResponseEntity.notFound().build();
        }
        File file = new File(p.getVideofilePath());
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        FileSystemResource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    
    
}
