#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

bool esPrimo(ll x){
    for(ll i=2;i*i<=x;i++){
        if(x%i == 0)return false;
    }
    return true;
}

void descomposicion(ll x){

    cout<<"Descomposicion: ";
    bool ya = false;
    for(int i=2;x>1;i++){
        int c=0;
        while(x%i == 0){
            c++;
            x/=i;
        }
        if(c){
            cout<<(!ya?"":" * ");
            cout<<i<<"^"<<c;
            ya = true;
        }
    }
    cout<<'\n';
    return;
}

int main(){

    ll x;    
    cout<<"Numero: ";
    cin>>x;
    cout<<"El numero "<<(esPrimo(x)?"":"NO ")<<"es primo\n";
    descomposicion(x);

}

