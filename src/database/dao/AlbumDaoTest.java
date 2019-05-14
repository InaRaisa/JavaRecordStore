package database.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Album;

class AlbumDaoTest {

	@Test
	public void testSearchingByKeyword() {
		AlbumDao dao = new AlbumDao();
		
		List<Album> albums = dao.findAlbumsByTitle("pill");
		
		assertEquals("Jagged Little Pill", albums.get(0).getTitle());
	}

}
