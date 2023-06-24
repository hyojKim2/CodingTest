def solution(targets):
    targets.sort(key=lambda x: (x[1])) #x[0]에 대해 오름차순정렬
    cnt=0
    s=e=0
    for target in targets:
        if(target[0]>=e):
            cnt+=1
            e=target[1]
    
    return cnt