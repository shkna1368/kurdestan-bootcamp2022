package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_file_attachments")
@Data
public class FileAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "personal_image")
    private String personalImage;


    @NotNull
    @Column(name = "last_license_image")
    private String lastLicenseImage;

    @OneToOne
    @JoinColumn(name = "employee_id",unique = true)
    private Employee employee;



}
