from sys import stdin,stdout

def cout(x):
    print(x,end=' ')
    return

#arr=[int(i) for i in stdin.readline().split()]
#n , m = map(int , input().split())
#imp = [0 for i in range(m)]
#for i in reversed(range(n)):

n = map(int,input().split())
aux = [int(i) for i in stdin.readline().split()]
i = 0
v = [(x,i++) for x in aux]
#for i in range(len(aux)):
#    v.append((aux[i],i))
v.sort()
#print(v)

res = []
inf = 1000000000

for i in range(len(v)):
    a = min( abs(v[i][0]-v[i-1][0]) if i>0 else inf, abs(v[i][0]-v[i+1][0]) if i+1<len(v) else inf )
    b = max( abs(v[i][0]-v[0][0]), abs(v[i][0]-v[len(v)-1][0]) )
    res.append((v[i][1],a,b))

res.sort()
for x in res:
    #print(x)
    print(str(x[1])+" "+str(x[2]))
