import pygame
import numpy as np
import time

# Init
pygame.init()

width, height = 1000, 1000
screen = pygame.display.set_mode((width,height))

# Background :v
background = (25, 25, 25)
screen.fill(background)

ncx, ncy = 50,50   # Num de celdas en x y y
dimCX, dimCY = width/ncx , height/ncy # Ancho de los cuadrados
colM, colV = (128, 128, 128), (255,255,255)

# Estado de las celdas
gameState = np.zeros((ncx,ncy))

para = False

# Ejecucion
while True:

    screen.fill(background) # Limpiar el CANVAS
    time.sleep(0.1)

    aux = np.copy(gameState)

    e = pygame.event.get()
    for event in e:
        if event.type == pygame.KEYDOWN:
            para = not para
        
        mouseClick = pygame.mouse.get_pressed()
        sum = 0
        for x in mouseClick:
            sum+=x
        if sum > 0:
            posX, posY = pygame.mouse.get_pos()
            celX, celY = int(np.floor(posX/dimCX)), int(np.floor(posY / dimCY))
            aux[celX,celY] = not mouseClick[2]

    for x in range(ncx):
        for y in range(ncy):
            
            if not para:

                sum = 0
                for i in range(-1,2):
                    for j in range (-1,2):
                        if i or j:
                            sum += gameState[(x+i+ncx)%ncx,(y+j+ncy)%ncy]

                # Regla 1 : Celula muerta con 3 vecinas vivas, revive
                if gameState[x,y] == 0 and sum == 3:
                    aux[x,y] = 1
           
                # Regla 2 : Celda viva con menos de 2 o mas de 3 vecinos vivos, muere
                if gameState[x,y] == 1 and ( sum < 2 or sum > 3):
                    aux[x,y] = 0

            coord = [
                (x * dimCX, y * dimCY),
                ((x+1) * dimCX, y * dimCY),
                ((x+1) * dimCX, (y+1) * dimCY),
                (x * dimCX, (y+1) * dimCY)
            ]
            if(aux[x,y]):
                pygame.draw.polygon(screen,colV,coord,0)
            else:
                pygame.draw.polygon(screen,colM,coord,1)
        
    gameState = np.copy(aux)

    pygame.display.flip()
