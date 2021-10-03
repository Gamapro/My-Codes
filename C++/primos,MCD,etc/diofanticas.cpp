#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll x,y;

ll mcd(ll a,ll b){
    if(b==0){ return a; }
    else return mcd(b,a%b);
}

void extendedEuclid(ll a,ll b){
    if(b==0){ 
        cout<<"A: "<<a<<", B: "<<b<<'\n';
        x=1; y=0; 
        return;
    }
    extendedEuclid(b,a%b);
    cout<<"X: "<<x<<", Y: "<<y<<"\n\n";
    cout<<"A: "<<a<<", B: "<<b<<'\n';
    int x1 = y;
    int y1 = x - (a/b)*y;
    x = x1;
    y = y1;
}

void diofantic(ll a, ll b, ll c){
    ll d = mcd(a,b);
    if(c%d != 0){
        cout<<"No tiene solucion, C debe de ser divisible entre mcd(A,B).";
        return;
    }
    extendedEuclid(a,b);
    cout<<"A: "<<a<<", B: "<<b<<", C: "<<c<<'\n';
    cout<<"Soluciones: U = "<<x<<", V = "<<y<<"\n";
    cout<<x*c<<' '<<y*c<<'\n';
}

int main(){

    ll a,b,c;
    cout<<"Calcular Ecuacion Diofantica. A*u + B*v = C . Ingrese los numeros\nNumero A: ";
    cin>>a;
    cout<<"Numero B: ";
    cin>>b;
    cout<<"Numero C: ";
    cin>>c;
    diofantic(a,b,c);
}


