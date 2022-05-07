package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "filmInfo.do", params = "filmId", method = RequestMethod.GET)

	public Film getFilmById(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film f = e.printStackTrace();
		return mv;

	}

//	public ModelAndView getStateByAbbreviation(String filmId) {
//		ModelAndView mv = new ModelAndView();
//		
//		
//		Film f = stateDAO.getStateByAbbreviation(abbr);
//		mv.addObject("state", s);
//		mv.setViewName("WEB-INF/solutions/result.jsp");
//		return mv;
}