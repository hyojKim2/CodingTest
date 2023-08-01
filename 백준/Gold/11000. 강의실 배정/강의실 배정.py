
import heapq

import sys
input = sys.stdin.readline

n=int(input())
arr=[]

for i in range (n):
    a, b=list(map(int, input().split()))
    arr.append([a,b])
    

arr.sort() #시작시간으로 정렬

heaps=[] #minheap생성!! 부모가 자식보다 작고, 자식간에는 대소x
heapq.heappush(heaps, arr[0][1]) # 첫 수업의 끝시간을 heap넣는다 

for i in range (1, n):
    if (heaps[0]> arr[i][0] ):
        heapq.heappush(heaps, arr[i][1]) #heap에 원소추가
    else: #이어서 가능하다면
        heapq.heappop(heaps) #가장 작은 원소(root노드) 삭제해서 갱신
        heapq.heappush(heaps, arr[i][1]) #heap에 원소추가

#ex [[1,3]] -> [[1, 3], [2, 4]] -> [[2, 4], [3,5]] 이렇게 들어가게된다
#*실제로는 끝시간만 들어가는데 보기편하라고 위와같이 표기함
                
print(len(heaps)) #heaps의 크기를 반환하면 됨
        
        



    