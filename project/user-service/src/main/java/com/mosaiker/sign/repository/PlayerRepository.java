package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    @Modifying
    @Transactional
    public void deletePlayerByPhone(Long phone);
}
