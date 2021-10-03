#include <bits/stdc++.h>
using namespace std;
#define fi first
#define se second
#define pb push_back
#define INF (ll)1e18 +5
#define all(a) a.begin(),a.end()
#define bitOn(i,j) ((i)&((ll)1<<j))
#define setBit(i,j) i=((i)|((ll)1<<j))
#define forn(i,n) for(ll i=0;i<n;i++)
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
ll t,n,k,m,h,a,b,c,x,y,q,d;

int main(){
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);

	cin>>n;
	while(n--){
		cin>>a;
		k = 0;
		while( a > 9 ){
			b = 1;
			while(a){
				b*=(a%10);
				a/=10;
			}
			k++;
			a = b;
		}
		cout<<k<<'\n';
	}

}

