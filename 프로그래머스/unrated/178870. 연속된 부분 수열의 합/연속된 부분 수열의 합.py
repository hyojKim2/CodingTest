def solution(sequence, k):
    
    l=0
    r=-1
    sum=0
    answer=[]
    while(True):
        if(sum<k):
            r+=1
            if( r>=len(sequence)):
                break
            sum+=sequence[r]
        else:# sum>=k라면 이동이동
            sum-=sequence[l]
            if( l>=len(sequence)):
                break
            l+=1
        if(sum==k): ##sum==k
            answer.append([l,r])
    answer.sort(key=lambda x: (x[1]-x[0], x[0]))
    return answer[0]