#include <bits/stdc++.h>
using namespace std;

#define se second
#define fi first

int main(){

    // STL
    // Standard Template Library 
    /*
    
    - Vector 
    - List (SinglyLinkedList) X

    - Queue 
    - Stack
    - Dequeue

    - Priority_queues (Heap) HeapSort
    - O(log(n)) -  Insertar y Eliminar

    - Set
    - Map
    - Multiset/ Multimap
    - O(log(n)) -  Insertar y Eliminar

    - Unordered_set (HashTables)
    - Unordered_map (HashTables)
    
    - Pair   (first, second) 

    */
    

    vector< vector< vector<int> > > v;
    
    int n = 4;
    cin>>n;

// INSERTAR VECTORES VACIOS

    for(int i = 0;i < 3;i++){
        
        v.emplace_back(vector<vector<int> >()); 

        for(int j = 0;j<n;j++){
            v[i].emplace_back(vector<int>());
        }
        if(i == 2){
            for(int j = 0;j<n-1;j++){
                v[i].emplace_back(vector<int>());
            }
        }
    }

// INSERTAR ELEMENTOS CON EMPLACE_BACK

    for(int i = 0;i < 3;i++){
        if(i == 0){ 
            for(int j = 0; j<n;j++){
                for(int k = 0; k<=j;k++){
                    v[i][j].emplace_back(j+1);
                }
            }
        }else if(i == 1){
            for(int j = 0; j<n;j++){
                for(int k = n-j-1; k>=0; k--){
                    v[i][j].emplace_back(n-j);
                }
            }
        }else{
            for(int j = 0; j<n;j++){
                for(int k = 0; k<=j;k++){
                    v[i][j].emplace_back(j+1);
                }
            }
            for(int j = 1; j<n;j++){
                for(int k = n-j-1; k>=0; k--){
                    v[i][j+n-1].emplace_back(n-j);
                }
            }

        }
    }
    
// IMPRIMIR

    for(int i = 0;i < v.size();i++){
        for(int j = 0; j< v[i].size();j++){
            for(int k = 0; k<v[i][j].size();k++){
                cout<<' '<<v[i][j][k];
            }
            cout<<'\n';
        }
        cout<<'\n';
    }

// vector< vector< map< vector<int>, int > > > m;

/*

4

[
   [ 1
   [ 2 2
   [ 3 3 3
   [ 4 4 4 4
]
[
   [ 4 4 4 4
   [ 3 3 3
   [ 2 2
   [ 1
]
[
   [ 1 
   [ 2 2  
   [ 3 3 3 
   [ 4 4 4 4 
   [ 3 3 3
   [ 2 2
   [ 1
]






*/


}







