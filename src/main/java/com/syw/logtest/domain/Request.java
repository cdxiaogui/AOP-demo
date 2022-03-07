package com.syw.logtest.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {
    String appId;

    String pin;

    Long jd;

}
