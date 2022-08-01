package com.github.anglepengcoding.take_album_lib.exception;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 */
public class NotException extends RuntimeException {
    public NotException(String message) {
        super(message);
    }

    public NotException(String message, Throwable cause) {
        super(message, cause);
    }
}
