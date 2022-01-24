package dbadapter;

import datatypes.TimeData;

	// Class represents a movie

public class Movie {
	

		private String title;
		private String director;
		private String actors;
		private TimeData publishingDate;
		private double averageRate;
		private int mid;
		
		public Movie(String title, String director, String actors, TimeData publishingDate, double averageRate) {
			super();
			this.title = title;
			this.director = director;
			this.actors = actors;
			this.publishingDate = publishingDate;
			this.setAverageRate(averageRate);
		}
		
		public Movie(String title, String director, String actors, TimeData publishingDate) {
			super();
			this.title = title;
			this.director = director;
			this.actors = actors;
			this.publishingDate = publishingDate;
			this.setAverageRate(0.0);
		}
		
		public Movie(int mid, String title, String director, String actors, TimeData publishingDate, double averageRate) {
			super();
			this.mid = mid;
			this.title = title;
			this.director = director;
			this.actors = actors;
			this.publishingDate = publishingDate;
			this.setAverageRate(averageRate);
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		
		public String getActors() {
			return actors;
		}
		public void setActors(String actors) {
			this.actors = actors;
		}

		public TimeData getPublishingDate() {
			return publishingDate;
		}

		public void setPublishingDate(TimeData publishingDate) {
			this.publishingDate = publishingDate;
		}

		public int getMid() {
			return mid;
		}

		public void setMid(int mid) {
			this.mid = mid;
		}

		public double getAverageRate() {
			return averageRate;
		}

		public void setAverageRate(double averageRate) {
			this.averageRate = averageRate;
		}
		
		
	}

