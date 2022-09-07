package me.patrick.laboratory.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ResultEntity<T> {

    private String code;

    private String message;

    private T data;
}
