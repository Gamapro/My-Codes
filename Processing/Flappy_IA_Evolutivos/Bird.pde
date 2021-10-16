class Bird{
  
  float y = height/2;
  float x = 50;
  float radio = 20;
  float speed = 0.45;
  float gravity = 0.5;
  int score = 0;
  float jumpRate = 1.01;
  boolean alive = true;
  boolean jump = false;
  float speedFactor = 6.2;
  Perceptron perceptron; 
  
  Bird(){
    perceptron = new Perceptron();
  }
  
  boolean hits(Pipe p){
    if(y < p.y1 || y >  p.y2){
       if(  x > p.x && x < p.x+p.rect_width){
         return true; 
       }
    }
    return false;
  }
  
  void show(){
    if(!alive) return;
    fill(250,250,0);
    circle(x,y,radio);
    return;
  }
  
  void update(Pipe p){
    if(!alive) return;
    // args -> bird.x, bird.y, closest pipe, bias
    float args[] = { x/width, y/height, p.x/width, p.y1/height, p.y2/height, 1};
    if(perceptron.predict(args) == 1){
    // if(keyPressed == true && keyCode == 0){
      speed = max(-jumpRate*speedFactor,min(speed-jumpRate,jumpRate)); 
    }
    y = max(0,min(y + speed, height));
    speed = speed + gravity;
    return;
  }
  
}
