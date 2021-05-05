package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
