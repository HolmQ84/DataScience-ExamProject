
# Import libraries
import numpy as np

# from sklearn.externals 
import joblib
import pickle
from flask import Flask, request, jsonify, render_template
import pandas as pd
import json
import plotly
import plotly.express as px
from sklearn.decomposition import PCA

#imports for polyregression
from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import LinearRegression
poly_reg = PolynomialFeatures(degree=4)

#Spotify
import spotipy
from spotipy.oauth2 import SpotifyClientCredentials

spotify_client_id = "3a2f65eb20164b24b59b7fdd6876bb51"
spotify_client_secret = "9f6d3a070cdf4eb8adda14a794d60469"

#Genius credentials
genius_token = "4SoLPv5UHyFZyAe5T-PhxS-bRCRrdNIgMNpeqjjIaWvnRbUmTpoGxd9knxBtlQyg"

#Authentication spotify - without user
client_credentials_manager = SpotifyClientCredentials(client_id="3a2f65eb20164b24b59b7fdd6876bb51", client_secret="9f6d3a070cdf4eb8adda14a794d60469")
sp = spotipy.Spotify(client_credentials_manager = client_credentials_manager)

#models
gaussian_model = joblib.load('../../5 - Communicate results/popularity_prediction_model.pkl')
regression_model = joblib.load('../../5 - Communicate results/regressionPredictor.pkl')



# Create An Instance (Of the application)
app = Flask(__name__, template_folder='./templates')

def analyseSongPopularity(songUrl):
    # Get song by songUrl.
    features = sp.audio_features(songUrl)[0]
    # Convert to dataframe.
    df = pd.DataFrame(features, index=['i',])
    # Get values and remove unwanted columns.
    final_set = df.values[:,0:10]
    # Predict popularity of song
    return gaussian_model.predict(final_set)

#For gausian model
@app.route('/predict')
def predict():
    return render_template('prediction.html')

@app.route('/predicted', methods=['GET', 'POST'])
def predicted():
    if request.method == 'POST':
        x1 = request.form['x1']
        print(x1)
        X = [[x1]]
        
        predicted = analyseSongPopularity('https://open.spotify.com/track/6OtCIsQZ64Vs1EbzztvAv4?si=2f482142d5ca42b5')
          
        # return render_template("predicted.html", content=X, prediction=predicted)
        return render_template("predicted.html", content="X", prediction=predicted[0])
    
  
    
@app.route('/predicted/regression', methods=['GET', 'POST'])
def predict_regression():
    if request.method == 'POST':
        x1 = request.form['x1']
        X = [[x1]]
        
        predicted = regression_model.predict(poly_reg.fit_transform(X))
          
        # return render_template("predicted.html", content=X, prediction=predicted)
        return render_template("predictedRegression.html", content="X", prediction=predicted[0])
    

if __name__ == '__main__':
    app.run(port= 5000, debug=True)
