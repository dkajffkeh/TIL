package me.patrick.laboratory.synchronization.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SynchronizationTestController {


    private final SynchronizationTestService synchronizationTestService;

    @GetMapping("/sync/test/{trace}")
    public String testMethod(@PathVariable(name = "trace") String trace){
        return synchronizationTestService.returnAfterAdd1000(trace);
    }

}
