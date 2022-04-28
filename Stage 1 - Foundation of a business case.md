# Stage 1 - Foundation Of A Business Case

***

### Brainstorming Ideas
Here we write down all the ideas that we had for a exam project.

- <u>Future Electricity Prices</u>\
Is it possible to calculate precise estimates of future electricity prices, if we use historic electricity and weather data on elements like 
wind speed and sun?
- <u>Car value reduction</u>\
Is it possible to find and use historic data on new and used cars, to estimate how much value reduction a given car has 
on each kilometre?
- <u>Animal Shelter Predictions</u>\
Is it possible to calculate the chances of a given animals chance to get adopted from a animal shelter, based on age 
and type of animal?
- <u>Breast Cancer calculations</u>
Is it possible to calculate the chances of a woman getting breast cancer, based on historic data on historic data on 
health and lifestyle diseases?
- <u>New Music Popularity calculations</u>\
Is it possible to calculate a new songs chances of getting into the top 10/100/1000 hitlists, based on various 
information about the song - such as length, theme, release date, lyrics, etc?
***
### Search for data sources and choose a idea.
Based on our search for various data sources related to the different topics, we have decided to go with the idea of 
calculating a songs chance of hitting a top list.

Our reasons for going with this topic, is the amount of data available, as well as the total complexity of the project.\
Besides these points the project can be analyzed from many angels and directions which allows us to cover many datascience tactics and algorithms.

#### We have found different data sets which can be used to reach our goal to make predictions of a songs popularity:

- Total list of Top 500's through the times since 2017 at Spotify.\
https://www.kaggle.com/datasets/dhruvildave/spotify-charts


- Lyrics for each song\
https://www.azlyrics.com/lyrics/ <span style="color: green">Artist</span> / <span style="color: orange">Song Title </span><span>.html</span>

***
### Formulate the following

**Context**\
As an upcoming artist it can be difficult to determine which features that has the biggest impact on a songs chance to become a hit song.\
We speculate that features like the following, play a big role in how well a song is received and how likely it is to succeed.


*These features include, but is not limited to:* 
  - Danceability.
  - Energy.
  - Key.
  - Loudness.
  - Mode.
  - Speechiness.
  - Acousticness.
  - Instrumentalness.
  - Liveness.
  - Valence.
  - Tempo.
  - Lyrics.
  


**Purpose**\
The purpose of this project is to provide a tool, for music producers, that can help determine a set of music features and the relationship between these features, based on an analytic and scientific approach.

To accomplish this goal, we seek to write a program that analyses the musical features of the top/most successful songs and based on this data, analyse an inputed songs musical features to determin how likely it is to hit a spot among the top hitting songs.


**Hypotheses for a data science problem definition.**

Is it possible to predict a songs chance of hitting the Top 200 chart on Spotify, based on Danceability, Energy, Key, Loudness, Mode, Speechiness, Acousticness, Instrumentalness, Liveness, Valence, Tempo.

**0Hypotheses**

A songs features does not affect a songs ability to hit the top 200 globally.

***

### Futher more, answer 

**What is in the focus of your interest?**

The focus/interest of this project is to provide a tool that may help musicians/songwriters to determine and tweak specific muscial features about a song based on the current top hit songs.

The goal is to give an estimation, in percentage, about how likely a song is to hit a specific spot in the top x collections. 


**Why is it interesting?**

Our interest in this project sparks from the curiosity to see if the top hitting songs follow a specific musical technical pattern - and if this knowledge can be used to estime a given songs succes.

If so can these data be used to create a hit song - or at least increase the chance of succes.


**Which outcome do you expect from your research?**

From this research we expect to find a correlation between the different features.

We also expect to see a specific pattern in the features of the top songs.

Lastly we expect to see specific words in the lyrics and a pattern between topics discussed in these lyrics. 


**Who may be a user of the results?**

The overall user will be "*Any person with an interest in music theory*".

To be more specific we expect the user to be a musical, music producer or teacher that wants to receive an estimation on a song. But user can use this product since there's no need for music theory to estimate a song
