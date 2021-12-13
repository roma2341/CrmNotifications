package com.zigzag.notificator.usecase.user;

import com.zigzag.notificator.core.CoreNotification;
import com.zigzag.notificator.core.CoreRecipient;
import com.zigzag.notificator.core.CoreUser;
import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;
import com.zigzag.notificator.features.api.model.Notification;
import com.zigzag.notificator.helper.NotificationHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class UserCreatedUsecase {
    @Autowired
    NotificationHelper notificationHelper;

    public void handle() {
        var user = new CoreUser();
        var notification = CoreNotification.builder()
                .type(NotificationType.USER_CREATED)
                .destinations(EnumSet.of(NotificationDestination.EMAIL))
                .recipients(List.of(CoreRecipient.of("zigzag2341@gmail.com")))
                .model(Map.of(
                        "user_name",user.getName(),
                        "user_id",user.getId()
                ))
                .build();
        notificationHelper.sendNotification(notification);
    }
}
