from __future__ import absolute_import, division, print_function

# TensorFlow and tf.keras
import tensorflow as tf
from tensorflow import keras
from numpy import array
# Helper libraries
import numpy as np
import matplotlib.pyplot as plt

print(tf.__version__)

class_names = ['accident' , 'no-accident']

test_data = []
with open('data_run_1.log') as my_file:
    test_data = my_file.readlines()


train_data = []
train_labels = []
for line in test_data :
    line = line.split(',')
    train_labels.append(line[3])
    del line[3]
    test_array = array(line)
    train_data.append(test_array)

train_labels = np.array(train_labels)
train_data = np.array(train_data)

model = keras.Sequential([
    keras.layers.Dense(2, activation=tf.nn.relu),
    keras.layers.Dense(2, activation=tf.nn.softmax)
])

model.compile(optimizer='adam',
              loss='mean_squared_error',
              metrics=['accuracy'])

model.fit(train_data, train_labels, epochs=5)

#test_loss, test_acc = model.evaluate(test_images, test_labels)

