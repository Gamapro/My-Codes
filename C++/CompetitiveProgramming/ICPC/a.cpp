#include <bits/stdc++.h>
using namespace std;
 
#define fi first
#define se second
#define pb push_back
#define eb emplace_back
#define mp make_pair
#define mp make_pair
#define EPS 1e-9
#define EPS2 1e-6
#define INF  1e18 + 5    /// 10^18 + 5
#define all(a)  a.begin(),a.end()
#define bit(i,j) ((i)&((ll)1<<j))
#define setbit(i,j) ((i)|((ll)1<<j))
#define forn(i,n) for(int i=0;i<n;i++)
#define fo(i,a,b) for(int i=a;i<b;i++)
#define dbg(x) cout << #x"=" << x << '\n';
#define dbg2(x,y) cout << #x"=" << x << " " << #y"=" << y << '\n';
#define dbg3(x,y,z) cout << #x"=" << x << " " << #y"=" << y << " " << #z"=" << z << '\n';
const int MOD = (int)1e9 + 7;
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

int n,q;
char c;
int a,b;
vsi adj;
map<pii,int> m;

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
    pii par(0,0); 
    int M=0,cantMax=0;
    cin>>n>>q;
    adj.resize(n+1);
    while(q--){
        cin>>c;
        if(c=='R'){
            cin>>a>>b;
            pii p(a,b);
            m[p]++;
            if(adj[a].size()==0){
                adj[a].insert(b);
            }else{
                int b2 = *adj[a].begin();
                if(m[p] > m[mp(a,b2)]){
                    adj[a].clear();
                    adj[a].insert(b);
                }else if(m[p] == m[mp(a,b2)]){
                    adj[a].insert(b); 
                }
            }


            if(m[p] > M){
                M = m[p];
                par = p;
                cantMax = 1;
            }else if(m[p] == M){
                cantMax++;
            }


        }else if(c=='Q'){
            cin>>a;
            if(adj[a].size() == 0){
                cout<<"No info";
            }else if(adj[a].size() > 1){
                cout<<"Multiple"; 
            }else{
                cout<<*adj[a].begin();
            }
            cout<<'\n';
        }else{
            if(n==1){
                cout<<1<<' '<<1;
                cout<<'\n';
            }if(cantMax != 1){
                cout<<"Multiple\n"; 
            }else{
                cout<<par.fi<<' '<<par.se;
                cout<<'\n';
            }
        }
    }

}
 
