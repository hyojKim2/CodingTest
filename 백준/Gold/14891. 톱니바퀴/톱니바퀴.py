from collections import deque


t=[[] for i in range (4)]

for i in range(4):
    t[i]=(deque(list(input())))
    

k=int(input())


idx=[]
way=[]

for i in range (k):
    a, b =(list(map(int, input().split())))
    a-=1
    idx.append(a)
    way.append(b)

for i in range (k):
    change=[0,0,0,0]
    ori=way[i]
    change[idx[i]]=ori
    
    for j in range(idx[i], 0, -1) : #<-왼쪽 방향
        if t[j][6]!=t[j-1][2]:#다르다면 돌린다
            way[i]*=-1
            change[j-1]=way[i]#도는 방향 저장
        else:
            break #같다면 돌릴 수 없으니 탈출
    way[i]=ori
    
    for j in range(idx[i], 3) : #->오른쪽 방향
        if t[j][2]!=t[j+1][6]:#다르다면 돌린다
            way[i]*=-1
            change[j+1]=way[i]#도는 방향 저장
        else:
            break #같다면 돌릴 수 없으니 탈출
    
    for i, rot in enumerate(change):
        if rot!=0 :
            t[i].rotate(rot) #돌려준다
    
    #좌우 방향등이있을때, 반드시 한 번에 하지 않아도 된다. 범위 나눠서 해도 됨!!!!


sum= int(t[0][0])*1 + int(t[1][0])*2 + int(t[2][0])*4 + int(t[3][0])*8

print(sum)

