package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private DatabaseAccessor db;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "getFilm.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView getFilmById(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = db.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/getFilm.jsp");
		return mv;
	}

	@RequestMapping(path = { "/", "createFilmForm.do" })
	public String createFilmForm() {
		return "WEB-INF/views/createFilm.jsp";
	}

//	@RequestMapping(path = "getFilm.do", params = "filmId", method = RequestMethod.POST)
//	public ModelAndView createFilm() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("film", film);
//		mv.setViewName("WEB-INF/views/getFilm.jsp");
//		return mv;
//	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public String createFilm(String title, String description, short release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating,
			RedirectAttributes redir) throws SQLException {

		Film film = new Film(title, description, release_year, language_id, rental_duration, rental_rate, length,
				replacement_cost, rating);

		film = db.createFilm(film);

		redir.addFlashAttribute("film", film);
		return "redirect:displayFilm.do";
	}

	@RequestMapping(path = "displayFilm.do", method = RequestMethod.GET)
	private ModelAndView displayFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/getFilm.jsp");
		return mv;
	}

	// TODO A user can choose to add a new film. They can enter all the properties
	// of the film.
	// Their input will be used to create Film object, which the DAO implementation
	// will save in the database.
	// If the insert fails, the user is informed of this.

	// TODO When a user retrieves a film, they have the option of deleting it. If
	// they delete the film, it is removed from the database. If the delete fails
	// (such as, due to child records), the user is informed of this.

	// TODO When a user retrieves a film, they have the option of editing it. If
	// they choose this, all the film's current properties are displayed in a form,
	// allowing them to change any property except the film's ID. When they submit
	// the form, that film's record is updated in the database. If the update fails,
	// the user is informed of this.

	// TODO A user can search for films by keyword/pattern in title or description.
	// From the resulting list of films, the user can choose to update or delete a
	// record.

	// TODO When a film's details are displayed, its actors and categories are also
	// listed.

}