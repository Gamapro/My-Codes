import numpy as np
import random
import matplotlib.pyplot as plt
import h5py
import keras 

modelo = "./modelo/modelo.h5"
pesos = "./modelo/pesos.h5"

cnn = keras.models.load_model(modelo)
cnn.load_weights(pesos)

from keras.utils import to_categorical
from keras.datasets import mnist

(train_data,train_label), (test_data,test_label) = mnist.load_data()
test_data = test_data.reshape(10000,28,28,1)
test_label = to_categorical(test_label)


res = cnn.predict(test_data[:10])
for i in range (0,10):
    a = np.argmax(res[i])
    b = np.argmax(test_label[i])
    print("Prediccion: " + str(a)  + " , Real: " + str(b))

cosa = random.randrange(0,10000)
plt.imshow(test_data[cosa])
res = np.argmax(cnn.predict(test_data[:cosa]))
print("Prediccion: " + str(res)  + " , Real: " + str(np.argmax(test_label[cosa])))
plt.show()
