n=int(input())
n=list(map(int, str(n)))
k=int(len(n)/2)

sum1=0
sum2=0

for i in range(k):
    sum1+=int(n[i])

for i in range(k, len(n)):
    sum2+=int(n[i])
    
if sum1==sum2:
    print("LUCKY")
else:
    print("READY")