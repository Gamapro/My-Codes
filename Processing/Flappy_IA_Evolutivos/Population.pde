class Population{
 
  int num_pipes = 5;
  int num_birds = 100;
  Bird birds[] = new Bird[num_birds];;
  Pipe pipes[] = new Pipe[num_pipes];
  float dif;
  int dist;
  int max_score;
  int count_alive;
  float mutation_rate = 0.005;
  
  Population(){
    dif = width/num_pipes; // dist between pipes
    dist = 2;              
    for(int i = 0 ; i < num_birds; i++){
      birds[i] = new Bird();
    }
    for(int i = 0 ; i < num_pipes; i++){
      pipes[i] = new Pipe();
      pipes[i].x = dif* (i+dist);
    }
  }
  
  void show(){
    for(Bird bird : birds){
      bird.show();
    }
    for(Pipe pipe : pipes){
      pipe.show();
    }
  }
  
  void update(){
    
    Pipe closest_pipe = pipes[0];
  
    for(int i = 0 ; i < num_pipes; i++){
      
      if(pipes[i].x < closest_pipe.x) closest_pipe = pipes[i];
      
      for(Bird bird : birds){
        if(bird.hits(pipes[i]) && bird.alive){
          pipes[i].hit = true;
          bird.alive = false;
        }else if(bird.alive && bird.y>=0 && bird.y <= height && bird.x - bird.radio == pipes[i].x+pipes[i].rect_width && !bird.hits(pipes[i])){
          bird.score++;
        }
      }
      
      pipes[i].update();
      
    }
    
    max_score = 0;
    count_alive = 0;
    for(Bird bird : birds){
       bird.update(closest_pipe);
       max_score = max(max_score, bird.score);
       if(bird.alive) count_alive++; 
    }
    
    if(count_alive == 0 || max_score == 100){
      reset();
    }
    
  }
  
  Bird selection(float prob[]){
    float r = random(0, 1);
    int ind = 0;
    while(r - prob[ind] > 0 && ind+1 < prob.length){
      r-=prob[ind];
      ind++;
      if(ind == num_birds) return new Bird();
    }
    return birds[ind];
  }
  
  void reset(){
    
    // selection -> fitness probabilidad
    // crossover -> parent a - b
    // mutation 
    
    /****** FITNESS ******/ 
    float fitness[] = new float[num_birds];
    int i = 0;
    int sum_score = 0;
    for(Bird bird : birds){
       bird.score*=bird.score;
       sum_score += bird.score;
    }
    sum_score = max(sum_score, 1);
    for(Bird bird : birds){
       fitness[i++] = (bird.score)/sum_score;
    }
    /****** FITNESS ******/
    
    /****** CROSSOVER ******/
    Bird children[] = new Bird[num_birds];
    for(i = 0 ; i < num_birds; i++){
        
        children[i] = new Bird();
      
        Bird parent_a = selection(fitness);
        Bird parent_b = selection(fitness);
        
        /****** MUTAR PERCEPTRON ******/
        for(int j = 0 ; j < children[i].perceptron.num_par; j++){
          float pick = random(0,1);
          if(pick <= 0.5) children[i].perceptron.weights[j] = parent_a.perceptron.weights[j];
          else            children[i].perceptron.weights[j] = parent_b.perceptron.weights[j];
        
        /****** MUTATION ******/
          
          children[i].perceptron.weights[j] += random(-1,1) * mutation_rate;
          
        /****** MUTATION ******/
          
          pick = random(0,1);
          if( pick >= 0.95 ) children[i] = new Bird();
      
        }
        
    }
    /****** CROSSOVER ******/
    
    for(i = 0 ; i < num_birds; i++){
      birds[i] = children[i]; 
    }
    
    resetPipes();
    max_score = 0;
    return;
  
  }
  
  void resetPipes(){
    for(int i = 0 ; i < num_pipes; i++){
      pipes[i] = new Pipe();
      pipes[i].x = (i+dist)*dif;
     }
     return;
  }
  
  
}
