from collections import deque
def dfs(v):
	print(v, end=" ")
	for i in range(1,n+1):
		if(list[v][i] and not visited_dfs[i]):
			visited_dfs[i]=True
			dfs(i)

def bfs(v):
	queue=deque()
	queue.append(v)
	while queue:
		a=queue.popleft()
		print(a, end=" ")
		for i in range(1, n+1):
			if(list[a][i] and not visited_bfs[i]):
				visited_bfs[i]=True
				queue.append(i)

n,m,v = map(int, input().split())
list=[[False]*(n+1) for _ in range(n+1)]
visited_dfs=[False]*(n+1)
visited_bfs=[False]*(n+1)
for i in range(m):
	a, b=map(int, input().split())
	list[a][b]=True
	list[b][a]=True
visited_dfs[v]=True
visited_bfs[v]=True
dfs(v)
print()
bfs(v)
