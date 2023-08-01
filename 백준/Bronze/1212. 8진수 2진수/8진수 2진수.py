# import sys
# input=sys.stdin.readline

n=input()
arr=list(n) #리스트에 저장
k=len(arr)
ten=0

two=[]

for i in range (k):
    arr[i]=int(arr[i])

if(arr[0]==0):
    print(0)
    exit()
    
for i in range(k):
    temp=[]
    while(arr[i]>0):
        temp.append(arr[i]%2)
        arr[i]=int(arr[i]/2)
    if (i!=0 and len(temp)!=3):
        while(len(temp)<3):
            temp.append(0)
    temp.reverse()
    two+=temp
    
    
print(*two, sep='')    
    