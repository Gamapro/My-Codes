/******************************************************/
/*                   MERGING                          */
/******************************************************/


template<class T>
class STValUpd{
public:
	
	// SegmentTreeValUpd
	// Template and Merge
	// Update value, query range
		
	vector<T> v;
	vector<T> st;
	int n;
	
	STValUpd(){}
	STValUpd(int _n) : n(_n) {
		v.resize(n);
		st.resize(2*n+5);
	}
	
	void read(){ for(int i=0;i<n;i++) cin>>v[i]; }

	T merge(T a, T b){
		int k = a.fi + b.fi;
		int k2 = min(a.se.fi, b.se.se);
		return {k + (k2*2),{ a.se.fi+b.se.fi-k2, a.se.se+b.se.se-k2}};
	}

	void build(){
	    for(int i=0;i<n;i++){ st[i+n]=v[i]; }
	    for(int i=n-1;i>0;i--){ st[i]=merge(st[i*2],st[i*2+1]); }
	}
	
	void update(int index, T val){
		for(st[index+=n]=val;index>>=1;)
			st[index] = merge(st[index<<1], st[index<<1|1]);
	}
	
	T query(int L,int R){  /// rango [ L , R )
	    T ansl={0,{0,0}}, ansr={0,{0,0}};
	    for(L+=n,R+=n;L<R;L>>=1,R>>=1){
	        if(L&1)ansl=merge(ansl,st[L++]);
	        if(R&1)ansr=merge(st[--R],ansr);
	    }
	    return merge(ansl, ansr);
	}

};


/******************************************************/
/*                      RMQ                           */
/******************************************************/

class STValUpd{
public:
	
	// SegmentTreeValUpd
	// RMQ
	// Update value, query range
		
	vector<ll> v,st;
	int n;
	
	STValUpd(){}
	STValUpd(int _n) : n(_n) {
		v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void init(int _n){
		n = _n; v.assign(n,0); st.assign(2*n+5,0);
	}
	
	void read(){ for(int i=0;i<n;i++) cin>>v[i]; }

	void build(){
	    for(int i=0;i<n;i++){ st[i+n]=v[i]; }
	    for(int i=n-1;i>0;i--){ st[i]=max(st[i*2],st[i*2+1]); }
	}
	
	void update(int index,ll val){
		for(st[index+=n]=val;index>>=1;) st[index]=max(st[index*2],st[index*2+1]);
	}
	
	ll query(int L,int R){  /// rango [ L , R )
	    ll ans=0;
	    for(L+=n,R+=n;L<R;L>>=1,R>>=1){
	        if(L&1)ans=max(ans,st[L++]);
	        if(R&1)ans=max(ans,st[--R]);
	    }
	    return ans;
	}

};


/******************************************************/
/*                 Range Sum                          */
/******************************************************/

class STValUpd{
public:
	
	// SegmentTreeValUpd
	// RANGE SUM
	// Update value, query range
		
	vector<ll> v,st;
	int n;
	
	STValUpd(){}
	STValUpd(int _n) : n(_n) {
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
		for(st[index+=n]=val;index>>=1;) st[index]=st[index*2]+st[index*2+1];
	}
	
	ll query(int L,int R){  /// rango [ L , R )
	    ll ans=0;
	    for(L+=n,R+=n;L<R;L>>=1,R>>=1){
	        if(L&1)ans+=st[L++];
	        if(R&1)ans+=st[--R];
	    }
	    return ans;
	}

};

class STRangeUpd{
public:
	
	// SegmentTreeRangeUpd
	// RANGE SUM
	// Update range, query value		
	
	vector<ll> v,st;
	int n;
	
	STRangeUpd(){}
	STRangeUpd(int _n) : n(_n) {
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
		for(L+=n,R+=n;L<R;L>>=1,R>>=1){
			if(L&1)st[L++]+=val;
			if(R&1)st[--R]+=val;
		}
	}
	
	ll query(int p){ 
	    ll ans=0;
	    for(p+=n;p;p>>=1) ans+=st[p];
		return ans;
	}

};

/******************************************************/
/*               Lazy Propagation                     */
/******************************************************/

class STLazy{
public:
	
	// Segment Tree Lazy Propagation
		
	vector<ll> v,st,d;
	int n, h;
	
	STLazy(){}
	STLazy(int _n) : n(_n) { 
		v.assign(n,0); st.assign(2*n+5,0);
		d.assign(2*n+5,0);
		h = sizeof(int) * 8 - __builtin_clz(n);
	}
	void read(){ for(int i=0;i<n;i++) cin>>v[i]; }

	void apply(int p, ll value) {
	  	st[p] += value;
	  	if(p < n) d[p] += value;
	}
	
	void build(int p) {
	  	while(p > 1) p >>= 1, st[p] = min(st[p<<1], st[p<<1|1]) + d[p];
	}
	void build_tree(){
	    for(int i=0;i<n;i++){ inc(i,i+1,v[i]); } 
	}
	
	void push(int p) {
	  	for(int s = h; s > 0; --s){
	    	int i = p >> s;
	    	if(d[i] != 0) {
	    		apply(i<<1, d[i]);
	      		apply(i<<1|1, d[i]);
	      		d[i] = 0;
	    	}
	  	}	
	}
	
	void inc(int L, int R, ll value) {
		L += n, R += n;
		int l0 = L, r0 = R;
		for(;L<R;L>>=1,R>>=1){
			if(L&1) apply(L++, value);
			if(R&1) apply(--R, value);
		}
		build(l0);
		build(r0 - 1);
	}
	
	ll query(int L, int R) {
		L += n, R += n;
		push(L);
	  	push(R - 1);
	  	ll ans = INF;
	  	for(;L<R;L>>=1,R>>=1){
	    	if(L&1) ans = min(ans, st[L++]);
	    	if(R&1) ans = min(st[--R], ans);
	  	}
	  	return ans;
	}

};
