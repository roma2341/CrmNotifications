package com.zigzag.notificator.usecase.user;

import com.zigzag.notificator.core.CoreNotification;
import com.zigzag.notificator.core.CoreRecipient;
import com.zigzag.notificator.core.CoreUser;
import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;
import com.zigzag.notificator.helper.NotificationHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCreatedUsecaseV2 {
    @Autowired
    NotificationHelper notificationHelper;

    public void handle() {
        var user = new CoreUser();
        var notification = CoreNotification.builder()
                .type(NotificationType.USER_CREATED)
                .destinations(EnumSet.of(NotificationDestination.EMAIL))
                .recipients(List.of(CoreRecipient.of("zigzag2341@gmail.com")))
                .model(UserNotificationModelBuilder(user))
                .build();
        notificationHelper.sendNotification(notification);
    }

    /*
    Allows to update body if required (if we modified template we can recreate previous models to have additional
     properties, but we can't use entity in migration, so we have to migrate data after spring run), we can involve version attribute.
     */
    static Map<String,Object> UserNotificationModelBuilder(CoreUser user){
        Map<String,Object> map = new HashMap<>();
        map.put("user_name",user.getName());
        map.put("user_id",user.getId());
        return map;
    }
}
