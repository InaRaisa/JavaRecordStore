package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import database.dao.TrackDao;
import model.Album;
import model.Artist;
import model.Track;

@WebServlet("/artistSearch")
public class ArtistSearchServlet extends HttpServlet {

	private ArtistDao artistDao = new ArtistDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/searchForm.jsp").include(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String artistName = request.getParameter("artistName");
		if (artistName == null || "".equals(artistName)) {
			request.setAttribute("error", "No name given");
			doGet(request, response);
		} else {
			Artist artist = new Artist(0, artistName);
			artistDao.findArtistsByName(artistName);
			response.sendRedirect("/RecordStore/artist?Name=" + artist.getName());
		}
	
}
}