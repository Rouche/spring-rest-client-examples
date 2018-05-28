package com.resolutech.springrestclient.api.domain;

import java.io.Serializable;
import java.util.List;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserData implements Serializable {
    private List<User> data;
}