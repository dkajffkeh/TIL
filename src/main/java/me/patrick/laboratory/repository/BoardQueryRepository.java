package me.patrick.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.patrick.laboratory.finalvalue.entity.masterEntity.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.patrick.laboratory.finalvalue.entity.masterEntity.QBoard.board;
import static me.patrick.laboratory.finalvalue.entity.masterEntity.QComment.comment;
import static me.patrick.laboratory.finalvalue.entity.masterEntity.QMemberMst.memberMst;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Board> findAllByBoard() {

        return jpaQueryFactory.selectFrom(board)
                .join(board.member, memberMst).fetchJoin()
                .join(board.comments, comment).fetchJoin()
                .fetch();
    }
}
