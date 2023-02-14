package com.wsy.wsy.library.log;

public interface HiLogFormatter<T> {

    String format(T data);
}