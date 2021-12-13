package com.zigzag.notificator.features.api.model;

import com.zigzag.notificator.features.api.enums.NotificationDestination;
import com.zigzag.notificator.features.api.enums.NotificationType;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public interface Notification {
    /*
     * Reasons to store model like that - We wouldn't use it in Java code, we need only prepare it once
     * and then use this model on Angular side or Freemarker templates.
     * Should always use simple model. Flat is better, because lesser chance of NPE.
     * Because we can't foresee future changes in notification we should use DTO's when display enties-related info.
     * Should we ? Or we just add simple fields when required (it's make sense, but what about
     * future modifications of events templates, maybe some fields will be added, but old models doesn't have them)
     * Points:
     * 1. What about notifications versioning
     * 2. Entity->Dto
     * 3. Flat model structure
     * @return
     */
    Map<String,Object> getModel();

    List<NotificationRecipient> getRecipients();

    EnumSet<NotificationDestination> getDestinations();

    NotificationType getType();
}
