package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ChinookDatabase;
import model.Album;
import model.Track;

public class TrackDao {
	private ChinookDatabase db = new ChinookDatabase();

	public List<Track> findTracksByAlbum(Album album) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		List<Track> tracks = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM Track WHERE albumId = ?");
			statement.setLong(1, album.getId());

			results = statement.executeQuery();

			while (results.next()) {
				long trackId = results.getLong("TrackId");
				String trackName = results.getString("Name");

				tracks.add(new Track(trackId, trackName));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return tracks;
	}
}