package com.codesquad.coco.game.domain.DAO;

import com.codesquad.coco.game.domain.model.Innings;
import com.codesquad.coco.utils.mapper.InningsMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.codesquad.coco.utils.BASEBALL_SQLKt.FIND_ALL_INNINGS_SQL;

@Component
public class InningsDAO {

    private NamedParameterJdbcTemplate template;
    private InningsMapper inningsMapper = new InningsMapper();

    public InningsDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Innings> findAllById(long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        return template.query(FIND_ALL_INNINGS_SQL, parameter, inningsMapper);
    }
}
