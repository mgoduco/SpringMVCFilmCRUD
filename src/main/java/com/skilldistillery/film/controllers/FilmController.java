package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	// CURRENT STORY
	@RequestMapping(path = "getFilmByKeyword.do", params = "keyword")
	public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword, Model model) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> films = db.getFilmByKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/getFilmByKeyword.jsp");
		return mv;
	}

	@RequestMapping(path = { "/", "getFilmByKeywordForm.do" })
	public String getFilmByKeyword() {
		return "WEB-INF/views/getFilmByKeyword.jsp";
	}

	@RequestMapping(path = "getFilm.do", params = "filmId")
	public ModelAndView getFilmById(Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = db.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/getfilm.jsp");
		return mv;
	}

	@RequestMapping(path = { "/", "createFilmForm.do" })
	public String createFilmForm() {
		return "WEB-INF/views/createFilm.jsp";
	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.GET)
	public String createFilm(String title, String description, Integer release_year, Integer language_id,
			Integer rental_duration, Double rental_rate, Integer length, Double replacement_cost, String rating,
			RedirectAttributes redir) throws SQLException {

		Film film = new Film(title, description, release_year, language_id, rental_duration, rental_rate, length,
				replacement_cost, rating);

		film = db.createFilm(film);

		redir.addFlashAttribute("film", film);
		return "redirect:displayFilm.do";
	}

	@RequestMapping(path = "deleteFilm.do")
	public ModelAndView deleteFilm(int id) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film localFilm = db.findFilmById(id);

		if (localFilm != null) {
			db.deleteFilm(localFilm);
			mv.addObject(localFilm);
		}

		mv.setViewName("WEB-INF/views/deleteFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("filmId") Integer filmId, Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();

		db.saveFilm(film);

		mv.addObject(film);
		mv.setViewName("WEB-INF/views/getfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFilmForm.do", method = RequestMethod.GET)
	private ModelAndView displayFilmForm(@RequestParam("filmId") Integer filmId, Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("filmId", filmId);
		mv.setViewName("WEB-INF/views/updateFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "displayFilm.do", method = RequestMethod.GET)
	private ModelAndView displayFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/getfilm.jsp");
		return mv;
	}

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