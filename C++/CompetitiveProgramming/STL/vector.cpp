#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main(){

    vector<int> v; //   v(n)   v(n,val)

    // Iteradores  //  b           e->a->d->null  
    v.begin();     // [1,2,3,4,5]
    v.end();       //            e

    // Assignacion
    v.clear();     // Limpia
    v.resize(n);   // resize(5)   [0,0,0,0,0]
    v.assign(n,0); // cuantos y con que los va a rellenar

    // AÑADIR
    v.emplace_back(); // emplace_back(1,2) 
    v.push_back();    // push_back({1,2})
    v.pop_back();     // [1,2,3,4] -> [1,2,3]

    v.size();  //Cuantos elementos
    v.empty(); // Bool, Esta vacio o no?

    // sort(v.begin(), v.end());

}
