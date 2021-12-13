package com.zigzag.notificator.helper;

import com.zigzag.notificator.features.api.NotificationOutboundAdapter;
import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.model.Notification;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;

/*
 *I think that notification service should be separate module
 * Notifications shouldn't depend on business logic
 */
public class NotificationHelper {
    Map<NotificationDestination,NotificationOutboundAdapter> notificationAdapters;
    NotificationHelper(List<NotificationOutboundAdapter> adapters){
        notificationAdapters = adapters.stream().collect(Collectors.toMap(NotificationOutboundAdapter::getNotificationDestination, identity()));
    }
    public void sendNotification(Notification notification){
        notification.getDestinations().forEach(destination -> {
            var outputAdapter = notificationAdapters.get(destination);
            outputAdapter.handle(notification);
        });
    }
}
