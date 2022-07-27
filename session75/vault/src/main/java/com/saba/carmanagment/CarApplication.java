package com.saba.carmanagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {
    @Autowired
    private VaultTemplate vaultTemplate;
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
/*
        VaultKeyValueOperations secret = vaultTemplate
                .opsForKeyValue("secret", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);*/

/*
        VaultResponse response = vaultTemplate
                .opsForKeyValue("secret", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2).get("shababApp");
        System.out.println("Value of github.oauth2.key");
        System.out.println("-------------------------------");
        System.out.println(response.getData().get("dbusername"));
        System.out.println("-------------------------------");*/
    }
}
