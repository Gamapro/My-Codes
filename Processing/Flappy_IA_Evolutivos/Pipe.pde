  class Pipe{
  
  float rect_width;
  float offset;              
  float x;
  float y1;
  float y2;
  boolean hit;
  
  Pipe(){
     rect_width = 20;
     offset = 120;
     x = random(50,width);                // a
     y1 = random(10,height/2 + 100);     // b
     y2 = y1 + offset;                  // c
     hit = false;
  }
  
  void show(){
    noStroke();
    fill(0,200,100);
    if(hit) fill(220,30,30);
    rect(x,0,  rect_width, y1);
    rect(x,y2, rect_width, height-y1);
    return;
  }
  
  void update(){
    if(x + rect_width <= 0){
       y1 = random(20,height/2);
       y2 = y1 + offset;
       x = width;
       hit = false;
    }else{
      x--; 
    }
    return;
  }
  
}
