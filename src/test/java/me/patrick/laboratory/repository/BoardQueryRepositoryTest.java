package me.patrick.laboratory.repository;

import me.patrick.laboratory.finalvalue.entity.masterEntity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardQueryRepositoryTest {

    @Autowired
    private BoardQueryRepository boardQueryRepository;

    @Test
    void test() {

        List<Board> boards = boardQueryRepository.findAllByBoard();
        System.out.println("Done");

    }

}