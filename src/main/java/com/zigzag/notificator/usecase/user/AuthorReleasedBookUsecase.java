package com.zigzag.notificator.usecase.user;

import com.zigzag.notificator.core.*;
import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;
import com.zigzag.notificator.helper.NotificationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
-Need to mention that all logic for sending specific notifications could be handled by single class.
-Also we can make common class for them.
 */
public class AuthorReleasedBookUsecase {
    @Autowired
    NotificationHelper notificationHelper;
    @Autowired
    DtoMapper dtoMapper;

    /*
    * Behaviour is more obvious, so fewer pitfalls (And no LazyInitialization Exceptions)
    * */
    @Transactional(readOnly = true)
    public void handle(CoreAuthorEntity user) {

        //send notifications
        var notification = CoreNotification.builder()
                .type(NotificationType.AUTHOR_RELEASED_BOOK)
                .destinations(EnumSet.of(NotificationDestination.EMAIL))
                .recipients(List.of(CoreRecipient.of("zigzag2341@gmail.com")))
                .model(UserNotificationModelBuilder(user))
                .build();
        notificationHelper.sendNotification(notification);
    }

    Map<String,Object> UserNotificationModelBuilder(CoreAuthorEntity author){
        var dto = dtoMapper.map(author,CoreAuthorDto.class);
        return Map.of("author",dto);
    }
}
