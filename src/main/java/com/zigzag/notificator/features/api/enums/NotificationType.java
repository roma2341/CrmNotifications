package com.zigzag.notificator.features.api.enums;

import java.util.EnumSet;

public enum NotificationType {
    USER_CREATED(NotificationDestination.EMAIL),
    USER_DELETED;

    EnumSet<NotificationDestination>  destinations = EnumSet.allOf(NotificationDestination.class);
    NotificationType(NotificationDestination destination){
        this.destinations = EnumSet.of(destination);
    }
    NotificationType(EnumSet<NotificationDestination> destinations){
        this.destinations = destinations;
    }
    NotificationType(){

    }
}
