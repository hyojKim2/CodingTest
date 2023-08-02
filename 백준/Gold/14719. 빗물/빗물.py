h, w =map(int, input().split())
arr=[]
arr=list(map(int, input().split()))

s_idx=0

for i in range (w):
    if arr[i]!=0:
            s_idx=i #시작 인덱스구하기
            break
            
temp=[]
water=0
top=0
top_idx=0

#for i in range (s_idx+1, w):

i=s_idx+1
while(i<w):
    if arr[s_idx] > arr[i] :# 기준보다 낮은 경우 
        temp.append(arr[i])
        if(top <= arr[i]):
            top=arr[i] #높은 기둥 갱신
            top_idx=i
    else: #같거나더 높은 경우, 구하기
        if(top<=arr[i]):
            top=arr[i] #높은 기둥 갱신
            top_idx=i
        if (s_idx!=top_idx):
            k=(min(arr[s_idx], top))*(top_idx-s_idx-1) -sum(temp[0:top_idx-s_idx-1])
            water+=k
            #print(s_idx, top_idx, k, water)
        s_idx=top_idx
        temp=[]
        top=0
        top_idx=0
            
    if i+1 == w:#끝까지 온 경우
        if(top!=0): #top이 생성되었다면 거기까지 구하기
            k=(min(arr[s_idx], top))*(top_idx-s_idx-1) -sum(temp[0:top_idx-s_idx-1])
            water+=k
            #print(s_idx, top_idx, k, water)
            s_idx=top_idx
            i=s_idx-1
            temp=[]
            top=0
            top_idx=0
            
    i+=1
    
print(water)
        