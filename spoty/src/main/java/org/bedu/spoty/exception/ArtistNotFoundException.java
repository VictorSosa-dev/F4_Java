package org.bedu.spoty.exception;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(long artistId) {
        super("ERR_DATA_NOT_FOUND", "No se encontró el artista especificado", artistId);
    }
}
