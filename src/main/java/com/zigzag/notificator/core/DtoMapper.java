package com.zigzag.notificator.core;

public interface DtoMapper {
    <T> T map(Object o,Class<T> clazz);
}
