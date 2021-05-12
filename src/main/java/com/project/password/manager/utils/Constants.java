package com.project.password.manager.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Constants {

    public static final String DEFAULT_VALUE_NONE = "None";

    @Value("${prop.url.base.front}")
    public String urlFront;
}
