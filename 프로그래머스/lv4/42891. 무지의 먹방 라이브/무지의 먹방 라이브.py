from operator import itemgetter

def solution(food_times, k):
    foods=[]
    n=len(food_times)
    for i in range(n):
        foods.append((food_times[i], i+1))#tuple
    
    foods.sort() #food_times[i] 기준으로 오름차순 정렬 
    
    pretime = 0
    for i, food in enumerate(foods): #i는 인덱스
        diff= food[0] - pretime
        if diff!=0:
            spend= diff * n
            if spend<= k:
                k-=spend
                pretime=food[0]
            else:
                k %= n
                sublist= sorted(foods[i:], key = itemgetter(1)) #1번 인덱스에 대하여 오름차순 정렬
                return sublist[k][1]
                
        n -= 1
       
    return -1
    
    
    
    
    
#     idx=0
          
#     for i in range(k):
#         if (food_times[idx]!=0):
#             food_times[idx]-=1
        
#         idx+=1
#         if (idx==len(food_times)):
#             idx=0 #인덱스 범위 초기화
        
        
#         while(food_times[idx]==0):
#             if food_times.count(0)==len(food_times):
#                 return -1
#             idx+=1
#             if(idx==len(food_times)):
#                 idx=0
        
        
#     return idx+1
