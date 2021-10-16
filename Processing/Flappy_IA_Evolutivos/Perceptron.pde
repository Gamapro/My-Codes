class Perceptron{

    // args -> bird.x, bird.y, closest pipe {x,y1,y2}, bias
    int num_par = 6;
    float weights[] = new float[num_par];  
  
    Perceptron(){
      num_par = 6;
      for(int i = 0 ; i < num_par; i ++){
          weights[i] = random(-1,1);
      }
    }
  
    int sign(float x){
      return (x<0)?-1:1;
    }
    
    int predict(float[] inputs){      
      float sum = 0.0;
      for(int i = 0 ; i < num_par; i++){
         sum += weights[i] * inputs[i];
      }
      return sign(sum);
    }
    
}
  
