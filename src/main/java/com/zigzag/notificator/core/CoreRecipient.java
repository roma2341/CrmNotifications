package com.zigzag.notificator.core;

import com.zigzag.notificator.features.api.model.NotificationRecipient;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Destination;

@Getter
@Setter
public class CoreRecipient implements NotificationRecipient {
    String destination;
    public static CoreRecipient of(String destination) {
        var rec = new CoreRecipient();
        rec.setDestination(destination);
        return rec;
    }
}
