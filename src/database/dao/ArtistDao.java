package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ChinookDatabase;
import model.Artist;

public class ArtistDao {
	private ChinookDatabase db = new ChinookDatabase();

	public Artist findArtist(long id) {
		Connection conn = db.connect();

		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			statement = conn.prepareStatement("SELECT * FROM Artist WHERE artistId = ?");
			statement.setLong(1, id);

			results = statement.executeQuery();

			if (results.next()) {
				String name = results.getString("Name");
				long artistId = results.getLong("ArtistId");

				return new Artist(artistId, name);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}
	}

	public List<Artist> findAllArtists() {
		Connection conn = db.connect();

		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> artists = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM Artist ORDER BY Name");

			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");

				Artist a = new Artist(id, name);

				artists.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return artists;
	}

	public List<Artist> findArtistsByName(String keyword) {
		Connection conn = db.connect();

		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> artists = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM Artist WHERE Name LIKE ?");
			statement.setString(1, "%" + keyword + "%");
			
			results = statement.executeQuery();

			while (results.next()) {
				String artistName = results.getString("Name");
				long artistId = results.getLong("ArtistId");

				Artist a = new Artist(artistId, artistName);

				artists.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return artists;
	}

	public void storeArtist(Artist artist) {
		Connection conn = db.connect();
		
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = conn.prepareStatement("INSERT INTO Artist(Name) VALUES(?)");
			statement.setObject(1, artist);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}
	}
}
