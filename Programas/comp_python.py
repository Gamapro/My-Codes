n = int(input())
k = int(input())
dp = [0 for i in range(n)]
dp[0] = k-1
dp[1] = (k-1)*k
for i in range(2,n):
	dp[i] = (k-1) * (dp[i-1] + dp[i-2])
print(dp[n-1])