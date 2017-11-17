from flask import Flask, render_template,request
from scipy.misc import imsave, imread, imresize
import numpy as np
import keras.models
import base64
import sys 
import os
import re
import flask
import json
from PIL import Image
from io import BytesIO
from flask import jsonify
sys.path.append(os.path.abspath("./model"))
from load import * 
app = Flask(__name__)
global model, graph
model, graph = init()

app = Flask(__name__)

def convertImage(imgData1):
	with open('output.png','wb') as output:
		output.write(base64.b64decode(imgData1))

@app.route('/predict', methods=['GET', 'POST'])
def get_json():
    imgData = request.get_json()
    convertImage(imgData['image'])
    print("debug")
    x = imread('output.png',mode='L')
    x = np.invert(x)
    x = imresize(x,(28,28))
    x = x.reshape(1,28,28,1)
    print("debug2")
    with graph.as_default():
		out = model.predict(x)
		print(out)
		print(np.argmax(out,axis=1))
		print("debug3")
		response = np.array_str(np.argmax(out,axis=1))
		dic = {}
		dic.update({'image':response})
		dic = flask.jsonify(dic)
		return dic
    return 'OK'

if __name__ == "__main__":
    port = int(os.environ.get('PORT', 5000))
    app.run(host='0.0.0.0', port=port)    