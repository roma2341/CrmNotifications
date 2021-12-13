package com.zigzag.notificator.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CoreAuthorEntity {
    String name;
    List<CoreBookEntity> books;
}
