package com.resolutech.springrestclient.api.domain;

import java.io.Serializable;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Billing implements Serializable {

    private Card card;
}
