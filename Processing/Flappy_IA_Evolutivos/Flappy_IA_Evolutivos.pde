  // Flappy bird

Population population;
int it = 0;

void setup(){
  size(800, 600);
  noStroke();
  population = new Population();
}

void draw(){
  
  for(int i = 0 ; i < max(1,it); i++){
    background(0);
    population.show();
    population.update();
    fill(255);
    textSize(40);
    text("Cont "+population.max_score+"  Vivos "+population.count_alive, width/3, 50);   
  }
}

void mousePressed(){
 it+=10; 
 it%=50;
}
