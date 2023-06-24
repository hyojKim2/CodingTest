def solution(x, y, n):
    s = set() #순서가 없다.  중복이 없다. set은 집합
    s.add(x) #s집합에 x넣음
    cnt=0 #최소횟수를 세는
    
    while(s):
        if(y in s): #같으면 종료, cnt 반환
            return cnt
        t=set() #임시로 빈 집합 만들어준다 
        for i in s: #s의 원소에 대해 수행하고, 빈 집합 t에 추가해주어 원소 갱신
            if(i*2<=y):
                t.add(i*2)
            if(i*3<=y):
                t.add(i*3)
            if(i+n<=y):
                t.add(i+n)
        s=t #s를 t로 대치 
        cnt+=1 
            

    return -1