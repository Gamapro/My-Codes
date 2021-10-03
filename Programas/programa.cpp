#include <bits/stdc++.h>
using namespace std;
#define fi first
#define se second
#define pb push_back
#define INF (ll)1e18 +5
#define all(a) a.begin(),a.end()
#define bitOn(i,j) ((i)&((ll)1<<j))
#define setBit(i,j) i=((i)|((ll)1<<j))
#define forn(i,n) for(int i=0;i<n;i++)
#define dbg(x) cout<<#x"="<<x<<'\n';
#define dbg2(x,y) cout<<#x"="<<x<<" "<<#y"="<<y<<'\n';
#define dbg3(x,y,z) cout<<#x"="<<x<<" "<<#y"="<<y<<" "<<#z"="<<z<<'\n';
#define MOD 1000000007
//更新前缀最大值
typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<vi> vvi;
typedef vector<vll> vvll;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
 
ll t,n,k,m,h,a,b,c,x,y,q;
 
vector<vector<ll>> cap;
 
ll bfs(int s, int t, vector<int> &p){
	queue<int> q;
	q.push(s);
	while(!q.empty()){
		int padre = q.front(); q.pop();
		if(padre == t) return 1;
		for(int hijo = 0; hijo <= n + m + 1; hijo++){
			if(p[hijo] == -1 && cap[padre][hijo] > 0){
				p[hijo] = p[padre]+1;
				q.push(hijo);
			}
		}
	}
	return 0;
}

bool dfs(int nodo, int t, ll c, ll &f, int n, vector<int> &l, vector<int> &p) {
	if(nodo == t) {
	    f+=c;
	    while(nodo){
	      	cap[p[nodo]][nodo] -= c;
	    	cap[nodo][p[nodo]] += c;
	    	nodo = p[nodo];
		}
		return 1;
	}
	for(int hijo = 0; hijo <= t; hijo++){
    	if(l[hijo] == l[nodo] + 1 && cap[nodo][hijo] > 0){
      		p[hijo] = nodo;
	      	if(dfs(hijo, t, min(cap[nodo][hijo], c), f, n, l, p)) return 1;
		}
	}
	return 0;
}
 
ll maxFlow(int s, int t, int n){
	ll max_flow = 0;
	vector<int> p2(n, 0);
	while(1){
		vector<int> parent(n, -1);
		parent[s] = 0;
		if(!bfs(s,t,parent)) return max_flow;
		while(dfs(s,t,INF,max_flow, n, parent, p2));
	}
	return max_flow;
}

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
    
    cin>>n>>m>>k;
    cap.assign(n+m+2,vll(n+m+2,0LL));
    while(k--){
    	cin>>a>>b;
    	a++; b++;
    	cap[a][b+n] = 1;
    }
    for(int i = 1; i<= n; i++){ cap[0][i] = 1; }
    for(int i = n+1; i<= n+m; i++){ cap[i][n+m+1] = 1; }
    
    ll k = maxFlow(0,n+m+1,n+m+2);
    
    vector<pair<int,int>> e;
  	for(int i = 1; i <= n; i++)
    	for(int j = n + 1; j <= n + m; j++)
      	if(cap[j][i]) e.push_back({i, j});
  	cout<<e.size()<<'\n';
  	//for(auto x : e) cout<<x.fi<<' '<<x.se - n<<'\n';
    
    
}