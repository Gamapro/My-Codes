class SegmentTreeValUpd{
public:
		
	// Update value, query range
		
	vector<ll> v,st;
	int n;
	
	SegmentTreeValUpd(){}
	SegmentTreeValUpd(int _n) : n(_n) {
		v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void init(int _n){
		n = _n; v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void read(){ for(int i=0;i<n;i++) cin>>v[i]; }

	void build(){
	    for(int i=0;i<n;i++){ st[i+n]=v[i]; }
	    for(int i=n-1;i>0;i--){ st[i]=st[i*2]+st[i*2+1]; }
	}
	
	void update(int index,ll val){
	    st[index+=n]=val;
	    while(index/=2){ st[index]=st[index*2]+st[index*2+1]; }
	}
	
	ll query(int L,int R){  /// rango [ L , R )
	    ll ans=0;
	    for(L+=n,R+=n;L<R;L/=2,R/=2){
	        if(L%2)ans+=st[L++];
	        if(R%2)ans+=st[--R];
	    }
	    return ans;
	}

};

class SegmentTreeRangeUpd{
public:
		
	// Update range, query value		
	
	vector<ll> v,st;
	int n;
	
	SegmentTreeRangeUpd(){}
	SegmentTreeRangeUpd(int _n) : n(_n) {
		v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void init(int _n){
		n = _n; v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void read(){ for(int i=0;i<n;i++) cin>>v[i]; }

	void build(){
	    for(int i=0;i<n;i++){ st[i+n]=v[i]; }
	}
	
	void update(int L,int R,ll val){ /// rango [ L , R )
		for(L+=n,R+=n;L<R;R/=2,L/=2){
			if(L&1)st[L++]+=val;
			if(R&1)st[--R]+=val;
		}
	}
	
	ll query(int p){ 
	    ll ans=0;
	    for(p+=n;p;p/=2) ans+=st[p];
		return ans;
	}

};

