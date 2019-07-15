package com.movieland.databasecreator.utils;

public class Constants {
	public static final String MOVIE = "movie.txt";
	public static final String USER = "user.txt";
	public static final String REVIEW = "review.txt";
	public static final String POSTER = "poster.txt";
	public static final String GENRE = "genre.txt";

	public static final int LINE_LENGTH = 200;
	public static final String RATING = "rating";
	public static final String PRICE = "price";

	public static final String GENRE_TABLE = "CREATE TABLE IF NOT EXISTS genre (" +
		"ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
		"genre varchar(255) NOT NULL" +
		");";

	public static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS user (" +
		"ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
		"user_name varchar(255) NOT NULL, " +
		"email varchar(255) NOT NULL, " +
		"password varchar(255) NOT NULL" +
		");";

	public static final String MOVIE_TABLE = "CREATE TABLE IF NOT EXISTS movie (" +
		"ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
		"name varchar(255) NOT NULL, " +
		"year varchar(255) NOT NULL, " +
		"country varchar(255) NOT NULL, " +
		"genre varchar(255) NOT NULL, " +
		"description varchar(2000) NOT NULL, " +
		"rating varchar(255) NOT NULL, " +
		"price varchar(255) NOT NULL" +
		");";

	public static final String POSTER_TABLE = "CREATE TABLE IF NOT EXISTS poster (" +
		"ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
		"name varchar(255) NOT NULL, " +
		"link varchar(255) NOT NULL " +
		");";

	public static final String REVIEW_TABLE = "CREATE TABLE IF NOT EXISTS review (" +
		"ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
		"name varchar(255) NOT NULL, " +
		"user_name varchar(255) NOT NULL, " +
		"description varchar(2000) NOT NULL" +
		");";

}
