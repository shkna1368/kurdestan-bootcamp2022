package com.kurdestan.pushnotification.clients;

import com.kurdestan.pushnotification.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "clients")
@Data
@Audited
public class Client extends BaseEntity {


    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @NotNull
    @Column(name = "family",nullable = false)
    private String family;

    @NotNull
    @Column(name = "user_name",nullable = false,unique = true)
    private String userName;

    @NotNull
    @Column(name = "password",nullable = false)
    private String password;

    @NotNull
    @Column(name = "phone",nullable = false,unique = true)
    private String phone;
    @NotNull
    @Column(name = "firebase_id",nullable = false)
    private String firebaseId;

    @NotNull
    @Column(name = "email",nullable = false,unique = true)
    private String email;


}
