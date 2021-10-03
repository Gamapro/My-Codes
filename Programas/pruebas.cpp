#include <bits/stdc++.h>

using namespace std;

int n,m;
vector<string> arr;
set<string> st;

string solve() {
	
    for( int i = 0 ; i < m; i++){
    	if(st.count(arr[i])) return arr[i];
    	st.insert(arr[i]);
    }
    
    for( int i = m ; i < n; i++){
    	st.erase(st.find(arr[i-m]));
    	if(st.count(arr[i])) return arr[i];
    	st.insert(arr[i]);
    }
    return "";
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);cout.tie(nullptr);
    
    cin>>n>>m;
    arr.assign(n,"");
    
    for(int i = 0 ; i < n; i++){
    	getline(cin, arr[i]);
    }
    
    string ret = solve();
    
    if(ret == "") cout << "El desfile de perritos estara bien hecho";
    else          cout << "Habran dos perritos con el nombre " << ret << " al mismo tiempo";

}