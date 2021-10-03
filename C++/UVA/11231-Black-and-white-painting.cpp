#include <bits/stdc++.h>
using namespace std;
 
#define fi first
#define se second
#define pb push_back
#define mp make_pair
#define EPS 1e-9
#define INF  1e15 +1    /// 10^15 + 1
#define INF2 ((ll)1)<<63 /// 2^63
#define all(a)  a.begin(),a.end()
#define bit(i,j) ((i)&((ll)1<<j))
#define setbit(i,j) ((i)|((ll)1<<j))
#define forn(i,n) for(int i=0;i<n;i++)
#define fo(i,a,b) for(int i=a;i<b;i++)
#define dbg(x) cout << #x"=" << x << '\n';
#define dbg2(x,y) cout << #x"=" << x << " " << #y"=" << y << '\n';
#define dbg3(x,y,z) cout << #x"=" << x << " " << #y"=" << y << " " << #z"=" << z << '\n';
const int MOD = 1000000007;
const int mod = 998244353;
const int nala5 = 1e5 +5;

typedef long long ll;
typedef vector <int> vi;
typedef vector <ll> vll;
typedef vector < vi > vvi;
typedef vector < vll > vvll;
typedef pair <int,int> pii;
typedef pair <ll,ll> pll;
typedef vector < pii > vpii;
typedef vector < pll > vpll;
typedef vector < vpii > vvpii;
typedef vector < vpll > vvpll;
typedef vector < set <int> > vsi;
typedef vector < set <ll> > vsll;

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
    int a,b,c,ca=1;
    while(cin>>a>>b>>c,a!=0 && b!=0){
        a-=7; b-=7;
        cout<<((a*b+c)/2)<<'\n';
    }

}	
