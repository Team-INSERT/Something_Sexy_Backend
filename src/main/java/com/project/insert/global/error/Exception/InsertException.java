package com.project.insert.global.error.Exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsertException extends RuntimeException{
    private final ErrorCode errorCode;
}
