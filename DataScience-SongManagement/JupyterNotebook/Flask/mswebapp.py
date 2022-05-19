
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

# Create An Instance (Of the application)
app = Flask(__name__, template_folder='./templates')

@app.route('/barchart')
def barchart():
   df = pd.DataFrame({
      'Fruit': ['Apples', 'Oranges', 'Bananas', 'Apples', 'Oranges', 
      'Bananas'],
      'Amount': [4, 1, 2, 2, 4, 5],
      'City': ['SF', 'SF', 'SF', 'Montreal', 'Montreal', 'Montreal']
   })
   fig = px.bar(df, x='Fruit', y='Amount', color='City', 
      barmode='group')
   graphJSON = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)
   return render_template('visual.html', graphJSON=graphJSON)

@app.route('/piechart')
def piechart():
   df = pd.DataFrame({
      'Fruit': ['Apples', 'Oranges', 'Bananas', 'Melons', 'Cherries', 
      'Pinapples'],
      'Amount': [4, 1, 2, 2, 4, 5],
   })
   fig = px.pie(df, names='Fruit', values='Amount')
   graphJSON = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)
   return render_template('visual.html', graphJSON=graphJSON)

@app.route('/scatterplot')
def scatterplot():
   df = pd.DataFrame({
      'x': [0, 1, 2, 5, 7, 10, 12, 15, 19, 24],
      'y': [4, 2, 7, 15, 11, 19, 3, 5, 9, 8]
   })
   fig = px.scatter(df, x='x', y='y')
   graphJSON = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)
   return render_template('visual.html', graphJSON=graphJSON)

@app.route('/pcascatter')
def pcascatter():
    df = px.data.iris()
    X = df[['sepal_length', 'sepal_width', 'petal_length', 'petal_width']]

    pca = PCA(n_components=2)
    components = pca.fit_transform(X)

    fig = px.scatter(components, x=0, y=1, color=df['species'], labels={'0': 'X-Value', '1': 'Y-Value'})
    graphJSON = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)
    return render_template('visual.html', graphJSON=graphJSON)

if __name__ == '__main__':
    app.run(debug=True)
