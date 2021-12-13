package com.zigzag.notificator.core;

import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;
import com.zigzag.notificator.features.api.model.Notification;
import com.zigzag.notificator.features.api.model.NotificationRecipient;
import lombok.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoreNotification implements Notification {
    Map<String, Object> model;
    List<NotificationRecipient> recipients;
    EnumSet<NotificationDestination> destinations;
    NotificationType type;
}
