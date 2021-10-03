#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll mcd(ll a,ll b){
    if(b==0)return a;
    else return mcd(b,a%b);
}

ll mcm(ll a,ll b){
    return (b/mcd(a,b))*a;
}

int main(){

    ll a,b;
    cout<<"Calcular MCD y MCM. Ingrese dos numeros\nNumero A: ";
    cin>>a;
    cout<<"Numero B: ";
    cin>>b;
    cout<<"MCD(A,B) = "<<mcd(a,b)<<"\n";
    cout<<"MCM(A,B) = "<<mcm(a,b)<<"\n";
}

