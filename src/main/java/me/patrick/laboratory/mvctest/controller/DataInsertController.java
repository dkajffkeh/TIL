package me.patrick.laboratory.mvctest.controller;

import lombok.RequiredArgsConstructor;
import me.patrick.laboratory.finalvalue.entity.masterEntity.Board;
import me.patrick.laboratory.finalvalue.entity.masterEntity.Comment;
import me.patrick.laboratory.finalvalue.entity.masterEntity.MemberMst;
import me.patrick.laboratory.repository.MemberMasterRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DataInsertController {

    private final MemberMasterRepository memberMasterRepository;

    @GetMapping("/member/board")
    @Transactional
    public void dataInsert(){

        final List<MemberMst> members = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {

            MemberMst m = MemberMst.builder()
                    .username("유호연"+1)
                    .age(32+i)
                    .boards(new ArrayList<>())
                    .comments(new ArrayList<>())
                    .build();

            final List<Board> boards = new ArrayList<>();
            for (int boadrd = 0 ; boadrd <= 10000 ; boadrd ++) {
                Board b = Board.builder()
                        .article(""+boadrd)
                        .member(m)
                        .comments(new ArrayList<>())
                        .build();

                final List<Comment> comments = new ArrayList<>();
                for (int comment = 0; comment <=10 ; comment ++) {

                    comments.add(Comment.builder()
                                    .content("None")
                                    .board(b)
                                    .member(m)
                            .build());
                }
                b.getComments().addAll(comments);
                boards.add(b);
            }
            m.getBoards().addAll(boards);
            members.add(m);
        }
        memberMasterRepository.saveAll(members);

        /*return members;*/
    }


}
