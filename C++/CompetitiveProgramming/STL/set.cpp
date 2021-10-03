#include <bits/stdc++.h>
using namespace std;

int main(){
    
    set<int> st;
    multiset<int> mst;
    unordered_set<int> unst;

    // O(log) > O(1)

/*

    1,1,2,3,4,5,5,5,5,5
    Set-> 1,2,3,4,5
    Multiset -> 1,1,2,3,4,5,5,5,5,5

*/

    // Iteradores
    st.begin(); // Primer elemento
    st.end();   // Hipotetico ultimo elemento

    st.size();      // Cuantos
    st.empty();     // Esta vacio
    st.insert(5);   // Inserta
    st.erase(5);    // Elimina
    st.clear();     // Limpia

    
    st.find(5);     // Iterador
             // Si no esta, regresa st.end()
    st.count(5);    // 1 si esta, 0 si no esta

    st.upper_bound(5); // Iterador a la ultima ocurrencia
    st.lower_bound(5); // Iterador a la primera ocurrencia
    

}




