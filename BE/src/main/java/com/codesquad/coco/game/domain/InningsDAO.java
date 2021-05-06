package com.codesquad.coco.game.domain;

import com.codesquad.coco.game.domain.model.Innings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class InningsDAO {

    private JdbcTemplate template;

    public InningsDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Innings> findAllById(long id) {
        String sql = "select i.id, i.score, i.score_board from innings i where i.score_board =" + id + " order by score_board_key";

        List<Innings> innings = new ArrayList<>();

        template.query(sql, (rs, rowNum) -> {
            innings.add(new Innings(
                    rs.getLong("id"),
                    rs.getLong("score_board"),
                    rs.getInt("score")
            ));
            return null;
        });

        return innings;
    }
}
