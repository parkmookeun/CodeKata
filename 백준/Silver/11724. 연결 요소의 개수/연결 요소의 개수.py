#연결 요소의 개수 구하기
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)
n,m = map(int,input().split())

graph = [[] for i in range(n+1)]
visited = [False]*(n+1)
for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(start,visited,graph):
    #print(start)
    visited[start] = True
    for node in graph[start]:
        if not visited[node]:
            dfs(node, visited, graph)

answer = 0
for i in range(1, n+1):
    if not visited[i]:
        answer += 1
        dfs(i, visited, graph)


print(answer)