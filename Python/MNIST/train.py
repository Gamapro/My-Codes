#import tensorflow as tf
import sys
import os
from keras.preprocessing.image import ImageDataGenerator
from keras import optimizers
from keras.models import Sequential
from keras.layers import Dense, Flatten, Dropout, Activation, Conv2D, MaxPooling2D
from keras.callbacks import EarlyStopping, TensorBoard
from keras.utils import to_categorical
from keras import backend as K
from keras.datasets import mnist
import matplotlib.pyplot as plt

K.clear_session()

# Separar los datos en test y train
(train_data,train_label), (test_data,test_label) = mnist.load_data()

#plt.imshow(train_data[0])
#plt.show()
# print(train_data[0].shape)

# Resizear los datos para el modelo
train_data = train_data.reshape(60000,28,28,1)
test_data = test_data.reshape(10000,28,28,1)

# One-hot-encode  , normalizar las etiquetas
train_label = to_categorical(train_label)
test_label = to_categorical(test_label)

#print(train_label[0])

# Crear CNN

cnn = Sequential()

cnn.add(Conv2D(64, kernel_size=3, activation='relu', input_shape=(28,28,1)))
cnn.add(Conv2D(32, kernel_size=3, activation='relu'))
cnn.add(Conv2D(16, kernel_size=3, activation='relu'))

cnn.add(Flatten())
cnn.add(Dense(32, activation='relu'))
cnn.add(Dropout(0.2));
cnn.add(Dense(10, activation='softmax'))

# Compilar el modelo

cnn.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

# Entrenar el modelo

cnn.fit(train_data, train_label, validation_data=(test_data, test_label), epochs=3)

# Guardar el modelo

cnn.save("./modelo/modelo.h5")
cnn.save_weights("./modelo/pesos.h5")

print("Proceso Finalizado!")



