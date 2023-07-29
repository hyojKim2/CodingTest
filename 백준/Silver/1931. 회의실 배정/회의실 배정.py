# 2023-07-29 파이썬 이코테 스터디 3 그리디알고리즘


import sys
input = sys.stdin.readline


n=int(input())

time=[]

for i in range(n):
    a, b=map(int, input().split())
    time.append([a,b])



# time=[[1,4],[3,5],[0,6],[5,7],[3,8],[5,9],[6,10],
#      [8,11],[8,12],[2,13],[12,14]]

time.sort()
time.sort(key = lambda x: x[1])#끝나는시간에대하여정렬

fin=time[0][1]
cnt=1


for i in range(1, n):
    if fin<=time[i][0]: 
        cnt+=1
        fin=time[i][1]
    
        
print(cnt)
            
     

