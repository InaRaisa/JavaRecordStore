package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Album;
import model.Track;
import model.Artist;
import database.dao.AlbumDao;
import database.dao.ArtistDao;
import database.dao.TrackDao;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {

	private AlbumDao albumDao = new AlbumDao();
	private TrackDao trackDao = new TrackDao();
	private ArtistDao artistDao = new ArtistDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Selvit‰ mit‰ albumia halutaan n‰ytt‰‰
		long id = Long.parseLong(request.getParameter("id"));

		// 2. Lataa albumi tietokannasta
		Album album = albumDao.findAlbum(id);
		
		// 3. Lataa albumin kappaleet tietokannasta
		List<Track> tracks = trackDao.findTracksByAlbum(album);
		
		// 4. Lataa albumin artisti tietokannasta
		Artist artist = artistDao.findArtist(id);

		// 5. Tulosta albumi vastaukseen
		if (album != null) {
			request.setAttribute("album", album);
			request.setAttribute("tracks", tracks);
			request.setAttribute("artist", artist);

			request.getRequestDispatcher("/WEB-INF/views/album.jsp").include(request, response);

		} else {
			response.setStatus(404);
			response.getWriter().println("Not found");
		}
	}
}
