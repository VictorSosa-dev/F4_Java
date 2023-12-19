package org.bedu.spoty.repository;

import org.bedu.spoty.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
