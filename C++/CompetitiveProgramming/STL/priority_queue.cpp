#include <bits/stdc++.h>
using namespace std;

int main(){

    priority_queue<int> pq;  

//         MAX-HEAP  
/*
             7
           /   \
          5     1
         /\
        3  4

        5 3 7 1

*/
//         MIN-HEAP  
/*
             1
           /   \
          5     7
         /\
        3  4

        5 3 7 1

*/

    pq.empty();  // Esta vacio?
    pq.size();   // Cuantos elementos hay
    pq.push();   // Inserta elemento en el heap
    pq.pop();    // Popea el mayor elemento
    pq.top();    // Mayor elemento

}



