package com.zigzag.notificator.features.api;

import java.util.Map;

public interface EmailSender {
    void sendTemplate(String template,String email, Map<String,Object> model);
}
