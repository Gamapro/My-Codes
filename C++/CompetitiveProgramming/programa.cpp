#include <bits/stdc++.h>
using namespace std;
 
#define fi first
#define se second
#define pb push_back
#define eb emplace_back
#define mp make_pair
#define EPS 1e-9
#define INF  (ll)1e18 + 5    /// 10^18 + 5
#define all(a)  a.begin(),a.end()
#define bitOn(i,j) ((i)&((ll)1<<j))
#define setBit(i,j) ((i)|((ll)1<<j))
#define forn(i,n) for(int i=0;i<n;i++)
#define fo(i,a,b) for(int i=a;i<b;i++)
#define dbg(x) cout << #x"=" << x << '\n';
#define dbg2(x,y) cout << #x"=" << x << " " << #y"=" << y << '\n';
#define dbg3(x,y,z) cout << #x"=" << x << " " << #y"=" << y << " " << #z"=" << z << '\n';
const int MOD = 1e9 + 7;
const int mod = 998244353;
//更新前缀最大值
typedef long long ll;
typedef vector <int> vi;
typedef vector <ll> vll;
typedef vector < vi > vvi;
typedef vector < vll > vvll;
typedef pair <int,int> pii;
typedef pair <ll,ll> pll;
typedef vector < pii > vpii;
typedef vector < pll > vpll;
typedef vector < set <int> > vsi;

ll dp[3000][3000][2];

ll bt(int l, int r, vi &v, int turno,ll x, ll y){
    if(l>r) return x-y;
    if(dp[l][r][turno] != -1) return dp[l][r][turno];
    if(turno == 0){
        return dp[l][r][turno] = max(bt(l+1,r,v,1-turno,x+v[l],y),bt(l,r-1,v,1-turno,x+v[r],y));
    }else{
        return dp[l][r][turno] = min(bt(l+1,r,v,1-turno,x+v[l],y),bt(l,r-1,v,1-turno,x+v[r],y));
    }
}

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
   
    int n,k;
    cin>>n;
    vi v(n);
    forn(i,n){
        cin>>v[i];
    }
    
    ll ans = 0; 
    ans = bt(0,n-1,v,0,0,0);
    cout<<ans<<'\n';

}
  




