package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.Artist;
import database.dao.ArtistDao;
import database.dao.AlbumDao;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

	private ArtistDao artistDao = new ArtistDao();
	private AlbumDao albumDao = new AlbumDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Selvit‰ mit‰ artistia halutaan n‰ytt‰‰
		long id = Long.parseLong(request.getParameter("id"));

		// 2. Lataa artisti tietokannasta
		Artist artist = artistDao.findArtist(id);

		// 3. Lataa artistin albumit tietokannasta
		List<Album> albums = albumDao.findAlbumsByArtist(artist);

		// 4. Tulosta artisti (ja albumit) vastaukseen
		if (artist != null) {
			request.setAttribute("artist", artist);
			request.setAttribute("albums", albums);

			request.getRequestDispatcher("/WEB-INF/views/artist.jsp").include(request, response);

		} else {
			response.setStatus(404);
			response.getWriter().println("Not found");
		}
	}

}
