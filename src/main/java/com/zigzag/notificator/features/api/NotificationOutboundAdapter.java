package com.zigzag.notificator.features.api;

import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.model.Notification;

public interface NotificationOutboundAdapter {
    public void handle(Notification notification);
    public NotificationDestination getNotificationDestination();
}
