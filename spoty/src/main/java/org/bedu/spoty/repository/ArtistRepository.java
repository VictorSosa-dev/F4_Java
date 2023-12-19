package org.bedu.spoty.repository;

import org.bedu.spoty.model.Artist;
import org.bedu.spoty.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // JPQL
    // De todas las interpretaciones "i", obten la canción (i.song),
    // dónde el id del artista (i.artist.id) sea igual al parámetro "artistId"
    @Query("SELECT i.song FROM Interpretation i WHERE i.artist.id = :artistId")
    List<Song> findAllSongsByArtistId(long artistId);
}
