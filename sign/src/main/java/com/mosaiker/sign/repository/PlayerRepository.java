package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
