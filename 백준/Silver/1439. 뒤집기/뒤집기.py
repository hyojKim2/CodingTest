num=input()
num=list(map(int,str(num)))
cnt_zero=0
cnt_one=0

if num[0]==1:
    cnt_zero+=1
else:
    cnt_one+=1
    
for i in range (len(num)-1):
    if num[i]!=num[i+1]:
        if num[i+1]==1:
            cnt_zero+=1
        else:
            cnt_one+=1

        
print(min(cnt_zero, cnt_one))
