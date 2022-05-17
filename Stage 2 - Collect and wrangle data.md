# Stage 2 - Data

In the folder Jupyter Notebook, we are working on collecting and wrangling the data.

We are working with a Spotify top chart csv file, with over 26 million entries.

We have cut down this dataset into a subset, to be able to process the data within reasonable time limits.

Then we combine this dataset with a spotify dev link, to access additional data about the songs - including audio features like danceability, instrumentalness, etc.

Additionally we are working on getting the lyrics from each song, and converting them into a bag of words, that we can use to calculate the weights of different words in the song lyrics.

This is done to have alot of relevant data, for calculating the chances of a song hitting a top chart based on all these different variables.
