package com.nt.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String rollNumber;
    private String year;
    private String phone;
    private String title;
    private String filePath; // path to uploaded file
    private String videofilePath; // path to second uploaded file
    @Lob
    private String description;

    @Lob
    private byte[] file;

    @Lob
    private String technologiesStack; // new

    @Lob
    private String developmentSteps; // new

    private String projectUrl; // new, optional

	/*
	 * @Lob private String imagePaths; // new, comma-separated paths
	 */
}
