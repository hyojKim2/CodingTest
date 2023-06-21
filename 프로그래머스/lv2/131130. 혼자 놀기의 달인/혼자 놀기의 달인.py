def solution(cards):
    Mval=0 #값을 갱신해가며
    for i in range(len(cards)): # 8,6,3,7...카드의 값으로 나오게된다.
        box=[0 for i in range (len(cards))] #카드순서대로 
        cnt1=0
        cnt2=0
        k=i
        while(box[k]==0): #박스가 열리지 않았을 때,
            cnt1+=1#상자1카운트+1
            box[k]=1#상자를 열어준다
            k=cards[k]-1 #숫자를 바꿔준다 
        #1박스의 수가 정해짐,
        idx2=0
        for j in range(len(box)):
            if box[j]==0: 
                idx2=j
                break#열리지 않은 가장 앞순번 박스를 가져옴
        #2번째박스
        for n in range(idx2, len(box)):
            m=n
            cnt2=0
            while(box[m]==0): #박스가 열리지 않았을 때,
                cnt2+=1#상자1카운트+1
                box[m]=1#상자를 열어준다
                m=cards[m]-1 #숫자를 바꿔준다 
            #2박스의 수가 정해짐
            if cnt1*cnt2>Mval:
                Mval=cnt1*cnt2
            #곱을 구해 갱신
        
            
        
    return Mval