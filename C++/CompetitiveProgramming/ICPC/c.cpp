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

class UnionFind{
private:
	vector<int> p, rank, setSizes;
    vector<string> menores;
	int numSets;
public:
	UnionFind(int N, vector<string> &v) {
		numSets = N;
		rank.assign(N, 0);
		menores = v;
        p.assign(N, 0);
		for (int i = 0; i < N; i++){
			p[i] = i;
        }
		setSizes.assign(N, 1);
	}
	int findSet(int i) {
		return (p[i] == i) ? i : p[i] = findSet(p[i]);
	}
	bool isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	void unionSet(int i, int j) {
		int x = findSet(i), y = findSet(j);
		if(!(x==y)) {
            if(menores[x].size() < menores[y].size()){
                menores[y] = menores[x];
            }
            else if(menores[y].size() < menores[x].size()){
                menores[x] = menores[y];
            }else{
                menores[x] = min(menores[x],menores[y]);
                menores[y] = min(menores[x],menores[y]);
			}
            if (rank[x] > rank[y]) {
				setSizes[findSet(x)] += setSizes[findSet(y)];
				p[y] = x;
			} else {
				setSizes[findSet(y)] += setSizes[findSet(x)];
				p[x] = y;
				if (rank[x] == rank[y])
					rank[y]++;
			}
			numSets--;
		}
	}
	int setSize(int i) {
		return setSizes[findSet(i)];
	}
	int numDisjointSets() {
		return numSets;
	}
    
    string getMin(int i){
        int x = findSet(i);
        return menores[x];
    }

};

ll t,n;
string s,s2,w;
vector<pair<string,string> > e;
map<string,int> seto;
vector<string> v;

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
    
    cin>>n;
    forn(i,n){
        cin>>s>>s2;
        e.eb(s,s2);
        seto[s]=1;
        seto[s2]=1;
    }
    
    t=0;
    for(map<string,int>::iterator it = seto.begin(); it != seto.end(); it++){
        v.pb(it->fi);
        seto[it->fi] = ++t;
        //cout<<it->fi<<' '<<it->se<<'\n';
    }

    n = v.size();
    
    UnionFind uf(n,v); 
    for(pair<string,string> p : e){
        uf.unionSet(seto[p.fi]-1,seto[p.se]-1);
        //cout<<p.fi<<' '<<p.se<<'\n';
    }
    //forn(i,n){ cout<<v[i]<<' '<<uf.getMin(seto[v[i]]-1); cout<<'\n'; } 
    cin.ignore();
    getline(cin,s);
    stringstream ss(s);
    t=0;
    while(ss >> w){
        if(t)cout<<' ';
        if(seto[w]!=0)cout<<uf.getMin(seto[w]-1);
        else cout<<w;
        t++;
    }
    
    cout<<'\n';
}
 
