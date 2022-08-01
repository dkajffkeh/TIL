package me.patrick.laboratory.finalvalue.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@ToString
@RequiredArgsConstructor
public class RecursionPayload {

    private String a;
    private String b;
    private final List<RecursionPayload> recursionPayloads = new ArrayList<>();

}
