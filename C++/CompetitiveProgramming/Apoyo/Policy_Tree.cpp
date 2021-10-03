#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update

// Codeforces entry : https://codeforces.com/blog/entry/11080

using namespace std;
using namespace __gnu_pbds;

typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
template <class T> using Tree = tree<T, null_type, less<T>, rb_tree_tag,tree_order_statistics_node_update>;

//  Apparently, the tree supports the same operations as the set but also there are two new features  // it is find_by_order() and order_of_key(). 
// find_by_order() -> returns an iterator to the k-th largest element (counting from zero)
// order_of_key()  -> the number of items in a set that are strictly smaller than our item.

Tree<int> s;

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n  = 10;
    cin>>n;
    for(int i = 0; i < n; i++){
        s.insert(i);
    }
    for(int i = 0; i < n; i++){
        // tree.erase(i);
    	cout << s.order_of_key(i) << " ";
    }
    cout<<'\n';
    for(int i = 0; i < n; i++){
        // tree.erase(i);
    	cout << *s.find_by_order(i) << " ";
    }
}