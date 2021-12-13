package com.zigzag.notificator.core;

import com.zigzag.notificator.features.api.EmailSender;
import com.zigzag.notificator.features.api.NotificationOutboundAdapter;
import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;
import com.zigzag.notificator.features.api.model.Notification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailNotificationOutboundAdapter implements NotificationOutboundAdapter {

    @Autowired
    EmailSender sender;

    @Override
    public void handle(Notification notification) {
        notification.getRecipients().forEach((recipient)->{
            sender.sendTemplate(getTemplateName(notification),recipient.getDestination(),notification.getModel());
        });
        notification.getModel();
        notification.getRecipients();
    }

    public NotificationDestination getNotificationDestination(){
        return NotificationDestination.EMAIL;
    }

    protected String getTemplateName(Notification notification){
        return StringUtils.lowerCase(notification.getType().name());
    }
}
