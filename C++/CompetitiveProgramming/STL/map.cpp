#include <bits/stdc++.h>
using namespace std;

int main(){

    //     K     V
    map<string, int> st;
    multimap<string, int> mst;
    unordered_map<string,int> unst;
    unordered_multimap<string,int> unst;

/**


    long arr[10];

        K    V
    arr[0] = 1;
     [0,n-1]

    "Pedro" -> 12
    "Juan" ->  20
    arr["juan"] = 10;

    -1 -> 10
    -5 -> 23

                            
     [4,5,6,7,1,2,3,4,5,6,7]
  %5 [4,0,1,2,1,2,3,4,0,1,2]
    
    6%5 = 1

- Funcion hash
- Lista de vectores

    -----------
    0|[5,5]
    1|[6,1,6,11,16,21,26,31,36]
    2|[7,2,7]
    3|[3]
    4|[4,4]

**/



//  Iteradores
    st.begin();
    st.end();

    st.size();
    st.empty();
    st.insert(make_pair(K,V));  // insert({K,V})  
    st.erase(K);
    st.clear();


    st.find(K); // Iterador
    // Pair<K,V>   k = par->first V = par->second
    st.count(K);

}



