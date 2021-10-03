#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

bool esPrimo(ll x){
    for(ll i=2;i*i<=x;i++){
        if(x%i == 0)return false;
    }
    return true;
}

int main(){

    ll x;    
    cout<<"Numero: ";
    cin>>x;
    cout<<"El numero "<<(esPrimo(x)?"":"NO ")<<"es primo\n";

}
