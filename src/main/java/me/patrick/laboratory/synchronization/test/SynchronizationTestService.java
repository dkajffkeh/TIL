package me.patrick.laboratory.synchronization.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Service
@Slf4j
@RequiredArgsConstructor
public class SynchronizationTestService {

    private String traceHolder = "";

    public String returnAfterAdd1000(String trace){

        this.traceHolder = trace;

        try {
            testSleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return traceHolder;
    }

    private void testSleep() throws InterruptedException {

        sleep(5000);

    }
}
