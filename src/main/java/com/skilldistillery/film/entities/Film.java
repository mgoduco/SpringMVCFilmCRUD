package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private Integer filmId;
	private String title;
	private String desc;
	private Integer releaseYear;
	private Integer langId;
	private String langName;
	private Integer rentDur;
	private Double rate;
	private Integer length;
	private Double repCost;
	private String rating;
	private String features;
	private List<Actor> actorList;
	private List<Film> films;

	public Film() {
	}

	public Film(Integer filmId, String title, String desc, Integer releaseYear, Integer langId, Integer rentDur,
			Double rate, Integer length, Double repCost, String rating, String features) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(String title, String desc, Integer releaseYear, Integer langId, Integer rentDur, Double rate,
			Integer length, Double repCost, String rating, String features) {
		super();
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(String title, String desc, Integer releaseYear, Integer langId, Integer rentDur, Double rate,
			Integer length, Double repCost, String rating) {
		super();
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
	}

	public Film(Integer filmId, String title, String desc, Integer releaseYear, Integer rentDur, Double rate,
			Integer length, Double repCost, String rating, String features) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(Integer filmId, String title, String desc, Integer releaseYear, Integer langId, String langName,
			Integer rentDur, Double rate, Integer length, Double repCost, String rating, String features) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.langName = langName;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(Integer filmId, String title, String desc, Integer releaseYear, Integer langId, String langName,
			Integer rentDur, Double rate, Integer length, Double repCost, String rating, String features,
			List<Actor> actorList, List<Film> films) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.langName = langName;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
		this.actorList = actorList;
		this.films = films;
	}

	public Film(String title, String desc, Integer releaseYear, Integer langId, String langName, Integer rentDur,
			Double rate, Integer length, Double repCost, String rating, String features) {
		super();
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.langName = langName;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(String title, String desc, Integer releaseYear, Integer rentDur, Double rate, Integer length,
			Double repCost, String rating, String features) {
		super();
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	
	
	public Film(Integer filmId, String title, String desc, Integer releaseYear, Integer langId, Integer rentDur,
			Double rate, Integer length, Double repCost, String rating, String features, List<Actor> actorList) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
		this.actorList = actorList;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public Integer getRentDur() {
		return rentDur;
	}

	public void setRentDur(Integer rentDur) {
		this.rentDur = rentDur;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getRepCost() {
		return repCost;
	}

	public void setRepCost(Double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorList, desc, features, filmId, films, langId, langName, length, rate, rating,
				releaseYear, rentDur, repCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actorList, other.actorList) && Objects.equals(desc, other.desc)
				&& Objects.equals(features, other.features) && Objects.equals(filmId, other.filmId)
				&& Objects.equals(films, other.films) && Objects.equals(langId, other.langId)
				&& Objects.equals(langName, other.langName) && Objects.equals(length, other.length)
				&& Objects.equals(rate, other.rate) && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && Objects.equals(rentDur, other.rentDur)
				&& Objects.equals(repCost, other.repCost) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", desc=" + desc + ", releaseYear=" + releaseYear
				+ ", langId=" + langId + ", langName=" + langName + ", rentDur=" + rentDur + ", rate=" + rate
				+ ", length=" + length + ", repCost=" + repCost + ", rating=" + rating + ", features=" + features
				+ ", actorList=" + actorList + ", films=" + films + "]";
	}

}