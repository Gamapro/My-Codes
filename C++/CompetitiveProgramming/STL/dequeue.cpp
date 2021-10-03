#include <bits/stdc++.h>
using namespace std;

int main(){

    dequeue<int> q; 

    q.empty();  // Esta vacio?
    q.size();   // Cuantos elementos hay
    
    // Queue
    q.push_front();
    q.pop_front();

    // Stack
    q.push_back();
    q.pop_back();
    
    q.front();  // Primer elemento
    q.back();  // Primer elemento

    /*

             Dequeue
    Q->  -   4,5,6,7  -  <-St
        Front       Back

        Push        Push
         ->          <-
        Pop         Pop


    */


}
