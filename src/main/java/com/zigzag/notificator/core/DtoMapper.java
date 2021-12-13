package com.zigzag.notificator.core;

public interface CoreDtoMapper {
    <T> T map(Object o,Class<T> clazz);
}
