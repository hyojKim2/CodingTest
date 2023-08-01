a, b= map(int, input().split())
k=b
cnt=0
while (True):
    if k%10==1:
        k=int(k/10)#끝자리 1인경우 제거하기
        cnt+=1
    else:
        k=k/2 #나눠주기
        cnt+=1
        
    if k==a:
        cnt+=1
        break
    if k<a or k!=int(k):#구할 수 없는 경우
        cnt=-1
        break
        
print(cnt)