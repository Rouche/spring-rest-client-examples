package com.resolutech.springrestclient.api.domain;

import java.io.Serializable;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @Important When using Builder we have to tell Lombok to generate both No Args and All Args
 */
@Data
@Slf4j
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User implements Serializable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String phone;
    private Job job;
    private Billing billing;
    private String language;
    private String currency;
}