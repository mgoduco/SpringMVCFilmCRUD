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
import com.skilldistillery.film.entities.Actor;
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
	@RequestMapping(path = "getFilmByKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) throws SQLException {
		System.out.println("GET FILM BY KEYWORD MAPPING TEST");
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
		if (film == null) {
			mv.setViewName("WEB-INF/views/error.jsp");
		} else {
			mv.setViewName("WEB-INF/views/getFilm.jsp");
		}
		return mv;
	}

	@RequestMapping(path = { "/", "createFilmForm.do" })
	public String createFilmForm() {
		return "WEB-INF/views/createFilm.jsp";
	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public String createFilm(String title, String description, Integer release_year, Integer language_id,
			Integer rental_duration, Double rental_rate, Integer length, Double replacement_cost, String rating,
			RedirectAttributes redir) throws SQLException {

		Film film = new Film(title, description, release_year, language_id, rental_duration, rental_rate, length,
				replacement_cost, rating);

		film = db.createFilm(film);

		redir.addFlashAttribute("film", film);
		return "redirect:displayFilm.do";
	}

	@RequestMapping(path = "deleteFilm.do", params = "filmId")
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film localFilm = db.findFilmById(filmId);

		if (localFilm != null) {
			Film deletedFilm = db.deleteFilm(localFilm);
			mv.addObject(localFilm);

			if (deletedFilm == null) {
				mv.setViewName("WEB-INF/views/error.jsp");
				return mv;
			}
		}

		mv.setViewName("WEB-INF/views/deleteFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("filmId") Integer filmId, Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();

		db.saveFilm(film);

		mv.addObject(film);
		mv.setViewName("WEB-INF/views/getFilm.jsp");
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
		mv.setViewName("WEB-INF/views/getFilm.jsp");
		return mv;
	}

	// TODO A user can search for films by keyword/pattern in title or description.
	// From the resulting list of films, the user can choose to update or delete a
	// record.

	// TODO When a film's details are displayed, its actors and categories are also
	// listed.

}