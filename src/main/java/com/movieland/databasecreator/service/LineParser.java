package com.movieland.databasecreator.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static com.movieland.databasecreator.utils.Constants.*;

public class LineParser {

	private static String line;
	private static int ID = 1;

	public static void parseLine(File file, BufferedReader reader)
		throws IOException, SQLException {

		String fileName = file.getName();
		if (fileName.equals(MOVIE)) {
			createMovieTable(reader);
		}
		if (fileName.equals(USER)) {
			createUserTable(reader);
		}
		if (fileName.equals(REVIEW)) {
			createReviewTable(reader);
		}
		if (fileName.equals(POSTER)) {
			createPosterTable(reader);
		}
		if (fileName.equals(GENRE)) {
			createGenreTable(reader);
		}
	}

	private static void createMovieTable(BufferedReader reader)
		throws IOException, SQLException {
		String name = "";
		String year = "";
		String country = "";
		String genre = "";
		String description = "";
		String rating = "";
		String price = "";

		while ((line = reader.readLine()) != null) {

			if (!line.equals("")) {
				if (line.contains("/")) {
					name = line;
				} else if (line.length() == 4) {
					if (String.valueOf(Integer.parseInt(line)).length() == 4) {
						year = line;
					}
				} else if (Character.isUpperCase(line.charAt(0)) &&
					line.length() < LINE_LENGTH) {
					country = line;
				} else if (Character.isLowerCase(line.charAt(0)) && !line.contains(RATING) && !line.contains(PRICE)) {
					genre = line;
				} else if (line.length() > LINE_LENGTH) {
					description = line;
				} else if (line.contains(RATING)) {
					rating = line;
				} else if (line.contains(PRICE)) {
					price = line;
				}
			}

			if (!name.equals("") && !year.equals("") && !country.equals("") && !genre.equals("") && !description.equals("") && !rating.equals("") && !price.equals("")) {
				String sql = "INSERT INTO movie (id, name, year, country, genre, description, rating, price) VALUES(" + ID++ + ", \"" + name + "\", " + "\"" + year + "\", " + "\"" + country + "\", " + "\"" + genre + "\", " + "\"" + description + "\", " + "\"" + rating + "\", " + "\"" + price + "\");";
				TableCreator.createTable(sql, MOVIE_TABLE);
				name = "";
				year = "";
				country = "";
				genre = "";
				description = "";
				rating = "";
				price = "";
			}
		}
	}

	private static void createUserTable(BufferedReader reader)
		throws IOException, SQLException {
		String name = "";
		String email = "";
		String password = "";
		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				if (Pattern.matches(".*\\p{InCyrillic}.*", line)) {
					name = line;
				} else if (line.contains("@")) {
					email = line;
				} else {
					password = line;
				}
			}
			if (!name.equals("") && !email.equals("") && !password.equals("")) {
				String sql = "INSERT INTO user (id, user_name, email, password) VALUES(" + ID++ +
					", \"" + name + "\", " + "\"" + email + "\", " + "\"" + password + "\");";
				TableCreator.createTable(sql, USER_TABLE);
				name = "";
				email = "";
				password = "";

			}
		}
	}

	private static void createReviewTable(BufferedReader reader)
		throws IOException, SQLException {
		String name = "";
		String userName = "";
		String description = "";
		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				if (line.length() > 50) {
					description = line;
				} else if (Character.isUpperCase(line.substring(line.indexOf(" ") + 1).charAt(0))) {
					userName = line;
				} else {
					name = line;
				}
			}
			if (!name.equals("") && !userName.equals("") && !description.equals("")) {
				String sql = "INSERT INTO review (id, name, user_name, description) VALUES(" + ID++ +
					", \"" + name + "\", " + "\"" + userName + "\", " + "\"" + description + "\");";
				TableCreator.createTable(sql, REVIEW_TABLE);
				name = "";
				userName = "";
				description = "";
			}
		}
	}

	private static void createPosterTable(BufferedReader reader)
		throws IOException, SQLException {

		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				String sql =
					"INSERT INTO poster (id, name, link) VALUES(" + ID++ + ", " +
						"\"" + line.substring(0, line.indexOf("http")) + "\", " + "\"" + line.substring(line.indexOf("http")) + "\");";
				TableCreator.createTable(sql, POSTER_TABLE);
			}
		}
	}

	private static void createGenreTable(BufferedReader reader)
		throws IOException, SQLException {
		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				String sql = "INSERT INTO genre (id, genre) VALUES(" + ID++ + ", " +
					"\"" + line + "\");";
				TableCreator.createTable(sql, GENRE_TABLE);
			}
		}
	}
}
