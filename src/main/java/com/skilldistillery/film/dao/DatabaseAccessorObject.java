package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Use the user's input to create a new Film object, passing it to your DAO's
	// createFilm(), then prints the added film.
	//
	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLangId());
			stmt.setInt(5, film.getRentDur());
			stmt.setDouble(6, film.getRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getRepCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getFeatures());
			try {
				int updateCount = stmt.executeUpdate();
				conn.commit(); // COMMIT TRANSACTION
				System.out.println(updateCount + " added new film");
				ResultSet rs = stmt.getGeneratedKeys();
				while (rs.next()) {
					System.out.println("New film: " + rs.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println("Error creating film");
				e.getErrorCode();
			}
//		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
//			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	// Modify createFilm() so it retrieves the ID of the newly-inserted film object,
	// and assigns it to the original Film object before returning it.
	//
	@Override
	public Film saveFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=?, release_year=?, rental_duration=?, rental_rate=?, "
					+ "length=?, replacement_cost=?, rating=?, special_features=?  "
					+ " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getReleaseYear() == null ? 0 : film.getReleaseYear());
			stmt.setInt(4, film.getRentDur() == null ? 0 : film.getRentDur());
			stmt.setDouble(5, film.getRate() == null ? 0 : film.getRate());
			stmt.setInt(6, film.getLength() == null ? 0 : film.getLength());
			stmt.setDouble(7, film.getRepCost() == null ? 0 : film.getRepCost());
			stmt.setString(8, film.getRating());
			stmt.setString(9, film.getFeatures());
			stmt.setInt(10, film.getFilmId() == null ? 0 : film.getFilmId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
//				sql = "DELETE FROM film WHERE film_id = ?";
//				stmt = conn.prepareStatement(sql);
//				stmt.setInt(1, film.getFilmId());
//				updateCount = stmt.executeUpdate();
//				sql = "INSERT INTO film (film_id) VALUES = ?";
				stmt = conn.prepareStatement(sql);
				if (film.getActorList() != null) {
					
				for (Actor actor : film.getActorList()) {
					stmt.setInt(1, film.getFilmId());
					updateCount = stmt.executeUpdate();
				}
			}
				conn.commit(); // COMMIT TRANSACTION
				System.out.println(updateCount + "edited film");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return null;
		}
		return film;
	}

	// Make sure your existing Film class and DAO film query methods include film.id
	// in their SELECTs, and include the id as an attribute in the returned Film
	// objects.
	//
	// Implement deleteFilm() in your DAO that takes a Film as its parameter.
	@Override
	public Film deleteFilm(Film film) {

		Connection conn = null;
		Film filmToDelete = film;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, film.getFilmId());
			int updateCount = stmt.executeUpdate();
			System.out.println(updateCount + "deleted");
			ResultSet keys = stmt.getGeneratedKeys();

			while (keys.next()) {
				System.out.println("deleted film id: " + keys.getInt(1));
			}

//			sql = "DELETE FROM film WHERE title = ?";
//			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, film.getFilmId());
//			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return null;
		}
		return filmToDelete;
	}

	@Override
	public Film findFilmById(Integer filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT *, language.name 'language' FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("film.id");
				String title = rs.getString("film.title");
				String desc = rs.getString("film.description");
				Integer releaseYear = rs.getInt("film.release_year");
				Integer langId = rs.getInt("film.language_id");
				Integer rentDur = rs.getInt("film.rental_duration");
				Double rate = rs.getDouble("film.rental_rate");
				Integer length = rs.getInt("film.length");
				Double repCost = rs.getDouble("film.replacement_cost");
				String rating = rs.getString("film.rating");
				String features = rs.getString("film.special_features");

				film = new Film(id, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating, features);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(Integer actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = " select * from actor where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorIds = rs.getInt("actor.id");
				String firstName = rs.getString("actor.first_name");
				String lastName = rs.getString("actor.last_name");
				actor = new Actor(actorIds, firstName, lastName);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(Integer filmId) {
		List<Actor> actorList = new ArrayList<>();
		Actor actor = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor "
					+ "JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON "
					+ "film_actor.film_id = film.id where film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorIds = rs.getInt("actor.id");
				String firstName = rs.getString("actor.first_name");
				String lastName = rs.getString("actor.last_name");
				actor = new Actor(actorIds, firstName, lastName);
				actorList.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;
	}

	@Override
	public List<Film> findFilmByKeyword(String searchWord) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT *,language.name 'language_name' FROM film JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchWord + "%");
		stmt.setString(2, "%" + searchWord + "%");
		ResultSet rs = stmt.executeQuery();
		List<Film> films = new ArrayList<Film>();
		if (rs.next() == false) {
			return null;
		} else {
			do {
				Film film = new Film();
				film.setFilmId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDesc(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setRentDur(rs.getInt("rental_duration"));
				film.setRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setRepCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setFeatures(rs.getString("special_features"));
				film.setActorList(findActorsByFilmId(rs.getInt("id")));
				film.setLangName(rs.getString("language_name"));
				films.add(film);
			} while (rs.next());
		}
		return films;
	}

}
//if (updateCount == 1) {
//	ResultSet keys = stmt.getGeneratedKeys();
//	if (keys.next()) {
//		int newFilmId = keys.getInt(1);
//		film.setFilmId(newFilmId);
//		if (film.getFilms() != null && film.getFilms().size() > 0) {
//			sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features)"
//					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
//			stmt = conn.prepareStatement(sql);
//			for (Film films : film.getFilms()) {
//				stmt.setInt(1, films.getFilmId());
//				stmt.setInt(2, newFilmId);
//				updateCount = stmt.executeUpdate();
//			}
//		}
//	}
//} else {
//	film = null;
//}
//
// When a film is displayed, the user can choose to delete the film. If they
// choose this option, the film object is passed to the DAO's deleteFilm.
//

// Test this using films you created using createFilm above - you don't need to
// be able to delete existing films, which have child records referencing them.
// Implement a film update operation.